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

    public String addCustomer(String name, String addr) {
        final int user = azure.addUser(name, addr);
        if (user == -1) {
            return "well, that didn't work";
        }
        return "Welcome to haCarTUM, " + name;
    }

    @Override
    public String addVehicle(int customerID, int vehicleID) {
        if (azure.addCar(customerID, vehicleID)) {
            return "the car " + vehicleID + " is now smartly insured!";
        }
        return "this did not work. maybe this car is already insured?";
    }

    @Override
    public String evaluateDrive(int customerID) {
        return "your new rating: " + azure.getRatingForUser(customerID);
    }

    @Override
    public String refund(int customerID, int amount) {
        if (policy == null) {
            return "sorry, but the policy has no rules about refunding yet";
        }
        if (amount == 0) {
            return "sorry, but we could not accept your request. You should drive more carefully!";
        }
        return String.format("that was successful. you will receive %d cents.", amount);
    }

    @Override
    public void recalculateContracts() {
        for (User user : azure.getUsers()) {
            user.notifyOfChange("Your account will be charged in the next days!");
        }
    }
}