package de.selectcode.hackaTUM.x17.haCarTUM.server.ether.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.1.
 */
public final class PayHowYouDriveInsurance extends Contract {
    private static final String BINARY = "606060405260006006556000600755341561001957600080fd5b60405160a0806106018339810160405280805191906020018051919060200180519190602001805191906020018051600487905560018054600160a060020a0319908116600160a060020a039889161790915560038054821696881696909617909555600555505060085560028054909116339092169190911790556007556009805460ff19169055610550806100b16000396000f3006060604052600436106100e55763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630f38bdc981146100ea57806312065fe01461010f5780632804b2c0146101225780632cd918e91461015157806343d726d61461016c5780635a477b3a1461017f5780636dbf65f01461019257806375b4d78c146101a55780637a375f76146101b857806389cf3204146101cb5780638f97e3a0146101de5780639609b82a146101f4578063a6f2ae3a1461022b578063c79ec4f514610233578063df32754b14610246578063ee26fac314610259575b600080fd5b34156100f557600080fd5b6100fd61026c565b60405190815260200160405180910390f35b341561011a57600080fd5b6100fd610272565b341561012d57600080fd5b610135610280565b604051600160a060020a03909116815260200160405180910390f35b341561015c57600080fd5b61016a60ff6004351661028f565b005b341561017757600080fd5b61016a6102e4565b341561018a57600080fd5b6100fd61030d565b341561019d57600080fd5b61016a610313565b34156101b057600080fd5b6100fd61037d565b34156101c357600080fd5b6100fd610383565b34156101d657600080fd5b610135610389565b34156101e957600080fd5b61016a600435610398565b34156101ff57600080fd5b61020761041a565b6040518082600381111561021757fe5b60ff16815260200191505060405180910390f35b61016a610423565b341561023e57600080fd5b61016a610481565b341561025157600080fd5b61016a6104eb565b341561026457600080fd5b610135610515565b60065481565b600160a060020a0330163190565b600154600160a060020a031681565b6003543390600160a060020a038083169116146102ab57600080fd5b600160095460ff1660038111156102be57fe5b146102c857600080fd5b5060085460059190910360ff1602600681905560045403600755565b60005433600160a060020a039081169116146102ff57600080fd5b600054600160a060020a0316ff5b60075481565b6001543390600160a060020a0380831691161461032f57600080fd5b600154600654600160a060020a039091169080156108fc0290604051600060405180830381858888f19350505050151561036857600080fd5b506009805460ff191660021790556000600655565b60085481565b60045481565b600254600160a060020a031681565b60055481908111156103a957600080fd5b6001543390600160a060020a038083169116146103c557600080fd5b6001547f35e70bcabb183ad21fb5f8219ea4769ed526f381e55f60717178d5df6ec65b93908490600160a060020a0316604051918252600160a060020a031660208201526040908101905180910390a1505050565b60095460ff1681565b6004543490819081101561043657600080fd5b6001543390600160a060020a0380831691161461045257600080fd5b600060095460ff16600381111561046557fe5b1461046f57600080fd5b50506009805460ff1916600117905550565b6002543390600160a060020a0380831691161461049d57600080fd5b600254600754600160a060020a039091169080156108fc0290604051600060405180830381858888f1935050505015156104d657600080fd5b506009805460ff191660031790556000600755565b6000805473ffffffffffffffffffffffffffffffffffffffff191633600160a060020a0316179055565b600354600160a060020a0316815600a165627a7a72305820c2f236866002686b6ad97e8d20864dd9d951424450775ea445f56a5a54c6f1a70029";

    private PayHowYouDriveInsurance(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private PayHowYouDriveInsurance(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<PayoutRequestedEventResponse> getPayoutRequestedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("PayoutRequested", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PayoutRequestedEventResponse> responses = new ArrayList<PayoutRequestedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PayoutRequestedEventResponse typedResponse = new PayoutRequestedEventResponse();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.cust = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PayoutRequestedEventResponse> payoutRequestedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("PayoutRequested", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PayoutRequestedEventResponse>() {
            @Override
            public PayoutRequestedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PayoutRequestedEventResponse typedResponse = new PayoutRequestedEventResponse();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.cust = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<BigInteger> moneyCustomer() {
        Function function = new Function("moneyCustomer", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getBalance() {
        Function function = new Function("getBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> customer() {
        Function function = new Function("customer", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setDrivingLevel(BigInteger _level) {
        Function function = new Function(
                "setDrivingLevel", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_level)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> close() {
        Function function = new Function(
                "close", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> moneyInsurance() {
        Function function = new Function("moneyInsurance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> withdrawCustomerMoney() {
        Function function = new Function(
                "withdrawCustomerMoney", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> bonus() {
        Function function = new Function("bonus", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> monthlyPolicy() {
        Function function = new Function("monthlyPolicy", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> insurance() {
        Function function = new Function("insurance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> requestPayout(BigInteger _amount) {
        Function function = new Function(
                "requestPayout", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> insuranceState() {
        Function function = new Function("insuranceState", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> buy(BigInteger weiValue) {
        Function function = new Function(
                "buy", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> withdrawInsuranceMoney() {
        Function function = new Function(
                "withdrawInsuranceMoney", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> owned() {
        Function function = new Function(
                "owned", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> car() {
        Function function = new Function("car", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<PayHowYouDriveInsurance> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _monthlyPolicy, String _customer, String _car, BigInteger _bonus, BigInteger _max) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_monthlyPolicy), 
                new org.web3j.abi.datatypes.Address(_customer), 
                new org.web3j.abi.datatypes.Address(_car), 
                new org.web3j.abi.datatypes.generated.Uint256(_bonus), 
                new org.web3j.abi.datatypes.generated.Uint256(_max)));
        return deployRemoteCall(PayHowYouDriveInsurance.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<PayHowYouDriveInsurance> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _monthlyPolicy, String _customer, String _car, BigInteger _bonus, BigInteger _max) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_monthlyPolicy), 
                new org.web3j.abi.datatypes.Address(_customer), 
                new org.web3j.abi.datatypes.Address(_car), 
                new org.web3j.abi.datatypes.generated.Uint256(_bonus), 
                new org.web3j.abi.datatypes.generated.Uint256(_max)));
        return deployRemoteCall(PayHowYouDriveInsurance.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static PayHowYouDriveInsurance load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PayHowYouDriveInsurance(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static PayHowYouDriveInsurance load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PayHowYouDriveInsurance(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class PayoutRequestedEventResponse {
        public BigInteger amount;

        public String cust;
    }
}
