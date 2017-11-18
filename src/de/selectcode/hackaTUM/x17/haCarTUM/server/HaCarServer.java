package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.jws.*;

/**
 * Server Interface
 */
@WebService
public interface HaCarServer {
    /**
     * @param name    the name of the new user
     * @param address his address
     * @return the text for the app
     */
    String addCustomer(@WebParam(name = "name") String name, @WebParam(name = "address") String address);

    /**
     * @param customerID which customer ...
     * @param vehicleID  wants to add which car?
     * @return the text for the app
     */
    String addVehicle(@WebParam(name = "customerID") int customerID, @WebParam(name = "vehicleID") int vehicleID);

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
     */
    void recalculateContracts();

    /**
     * has to be set before refund may be called
     *
     * @param policy the refunding policy
     */
    void setPolicy(InsuranceCompanyPolicy policy);
}