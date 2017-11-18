package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.jws.WebService;

@WebService(endpointInterface = "de.selectcode.hackaTUM.x17.haCarTUM.server.HaCarServer")
public class HaCarServerImpl implements HaCarServer {
    public String addCustomer(String user) {
        // TODO: register
        return "Welcome to haCarTUM, owner of the car " + user;
    }

    @Override
    public String evaluateDrive(int customerID) {
        // TODO: SQL stuff
        return "drive could not be analyzed";
    }

    @Override
    public String refund(int customerID, int amount) {
        // TODO
        return "sorry, but we could not accept your request. You should drive more carefully!";
    }

    @Override
    public void recalculateContracts() {
        // TODO
    }
}