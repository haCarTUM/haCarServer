package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.jws.*;

/**
 * Server Interface
 */
@WebService
public interface HaCarServer {
    /**
     * @param vehicleID adds a new customer to the contract
     * @return the text for the app
     */
    String addCustomer(@WebParam(name = "vehicleID") String vehicleID);

    /**
     * @param customerID the vehcile / customer ID % TODO?!
     * @return the text for the app, analyzing all un-analyzed data
     */
    String evaluateDrive(@WebParam(name = "customerID") int customerID);

    /**
     * @param customerID the vehcile / customer ID % TODO?!
     * @param amount     the amount of money <b>(in cent)</b> the customer wants back
     * @return the text for the app
     */
    String refund(@WebParam(name = "customerID") int customerID, int amount);

    /**
     * recalculates the contract of every customer.
     * TODO: find a way to notify them
     */
    void recalculateContracts();
}