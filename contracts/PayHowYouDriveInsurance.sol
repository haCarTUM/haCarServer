pragma solidity ^0.4.4;

import './mortal.sol';

contract PayHowYouDriveInsurance is mortal {

    address public customer;
    address public insurance;
    address public car;

    uint public monthlyPolicy;
    uint private max;

    uint public moneyCustomer = 0; // customer stores money in contract, the variable part of the insurance
    uint public moneyInsurance = 0; // insurance gets amount of customer money, the fixed part of the insurance
    uint public bonus; //How much reward the user gets for each driving level

    enum InsuranceState { CREATED, ACTIVE, INACTIVE, WITHDRAWN }

    InsuranceState public insuranceState;

    event PayoutRequested(uint amount, address cust);

    function PayHowYouDriveInsurance(uint _monthlyPolicy, address _customer, address _car, uint _bonus, uint _max) public {
        monthlyPolicy = _monthlyPolicy;
        customer = _customer;
        car = _car;
        max = _max;
        bonus = _bonus;
        
        insurance = msg.sender;
        
        moneyInsurance = monthlyPolicy;

        insuranceState = InsuranceState.CREATED;
    }


    modifier sufficientPolicyMoney(uint _money) {
        uint _asdf = msg.value;
        require(_money >= monthlyPolicy);
        _;
    }

    modifier customerOnly(address _customer) {
        require(customer == _customer);
        _;
    }

    modifier insuranceOnly(address _insurance) {
        require(insurance == _insurance);
        _;
    }

    modifier carOnly(address _car) {
        require(car == _car);
        _;
    }

    modifier belowMax(uint _sum){
        require(_sum <= max);
        _;
    }

    ///Buy the insurance for `monthlyPolicy`
    function buy() public payable 
        sufficientPolicyMoney(msg.value)
        customerOnly(msg.sender) {

        require(insuranceState == InsuranceState.CREATED);
        
        insuranceState = InsuranceState.ACTIVE;
    }

    function setDrivingLevel(uint8 _level) public carOnly(msg.sender) {
        require(insuranceState == InsuranceState.ACTIVE);

        moneyCustomer = (5-_level)*bonus;
        moneyInsurance = monthlyPolicy - moneyCustomer;
    }

    function withdrawInsuranceMoney() public insuranceOnly(msg.sender) {
        insurance.transfer(moneyInsurance);
        insuranceState = InsuranceState.WITHDRAWN;
        moneyInsurance = 0;
    }

    function withdrawCustomerMoney() public customerOnly(msg.sender) {
        customer.transfer(moneyCustomer);
        insuranceState = InsuranceState.INACTIVE;
        moneyCustomer = 0;
    }

    function getBalance() public constant returns(uint) {
        return this.balance;
    }

    function requestPayout(uint _amount) public belowMax(_amount) customerOnly(msg.sender) {
        PayoutRequested(_amount, customer);
    }
}
