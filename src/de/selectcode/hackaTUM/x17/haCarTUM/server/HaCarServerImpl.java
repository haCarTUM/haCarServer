package de.selectcode.hackaTUM.x17.haCarTUM.server;

import de.selectcode.hackaTUM.x17.haCarTUM.util.User;

import javax.jws.WebService;

@WebService(endpointInterface = "de.selectcode.hackaTUM.x17.haCarTUM.server.HaCarServer")
public class HaCarServerImpl implements HaCarServer {
    private AzureAdapter azure;
    private InsuranceCompanyPolicy policy;

    public HaCarServerImpl() {
        azure = new AzureAdapter();
        policy = new InsureDummy();
    }

    public void setPolicy(InsuranceCompanyPolicy policy) {
        this.policy = policy;
    }

    @Override
    public void addDriveData(float x, float y, float z, int carID) {
        azure.addDriveData(x, y, z, carID);
    }

    public String addCustomer(String first, String last, String ether) {
        // TODO: verify ether
        final int user = azure.addUser(first, last, ether);
        if (user == -1) {
            return "well, that didn't work";
        }
        return "Welcome to haCarTUM, " + first + " " + last;
    }

    @Override
    public String addVehicle(int customerID, int vehicleID) {
        if (azure.addCar(customerID, vehicleID)) {
            return "the car " + vehicleID + " is now smartly insured!";
        }
        return "this did not work. maybe this car is already insured?";
    }

    @Override
    public String evaluateDrive(int customerID, int vehicleID) {
        return "your new rating: " + azure.getRatingForUser(vehicleID);
    }

    @Override
    public String refund(int customerID, int amount) {
        if (policy == null) {
            return "sorry, but the policy has no rules about refunding yet";
        }
        int ref = policy.doesUserGetRefund(customerID, amount);
        if (ref == 0) {
            return "sorry, but we could not accept your request. You should drive more carefully!";
        }
        return String.format("that was successful. you will receive %d cents.", ref);
    }

    @Override
    public void recalculateContracts() {
        for (User user : azure.getUsers()) {
            user.notifyOfChange("Your account will be charged in the next days!");
        }
    }
}