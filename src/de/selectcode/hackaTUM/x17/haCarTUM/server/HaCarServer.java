package de.selectcode.hackaTUM.x17.haCarTUM.server;

import javax.jws.*;

/**
 * Server Interface
 */
@WebService
public interface HaCarServer {
    /**
     * @param first first name of the new user
     * @param last  last name of the new user
     * @param ether the ether credentials of the new user
     * @return the welcoming text for the app
     */
    String addCustomer(@WebParam(name = "first name") String first, @WebParam(name = "last name") String last,
                       @WebParam(name = "ether") String ether);

    /**
     * @param customerID which customer ...
     * @param vehicleID  wants to add which car?
     * @return the text for the app
     */
    String addVehicle(@WebParam(name = "customerID") int customerID, @WebParam(name = "vehicleID") int vehicleID);

    /**
     * @param customerID the ID of the customer
     * @param vehicleID  the ID of the car
     * @return the text for the app, analyzing all un-analyzed data
     */
    String evaluateDrive(@WebParam(name = "customerID") int customerID, @WebParam(name = "vehicleID") int vehicleID);

    /**
     * @param customerID the vehcile / customer ID % TODO?!
     * @param amount     the amount of money <b>(in cent)</b> the customer wants back
     * @return the text for the app
     */
    String refund(@WebParam(name = "customerID") int customerID, int amount);

    /**
     * recalculates the contract of every customer.
     */
    void updateContracts();

    /**
     * Create a new contract for a customer
     * @param carAddress
     * @param customerAddress
     */
    boolean createContract(@WebParam(name = "carAddr") String carAddress, @WebParam(name = "cutsAddr") String customerAddress);

    /**
     * has to be set before refund may be called
     *
     * @param policy the refunding policy
     */
    void setPolicy(@WebParam(name = "insurance refund policy") InsuranceCompanyPolicy policy);

    /**
     * @param x  accelerateX
     * @param y  accelerateY
     * @param z  accelerateZ
     * @param id the ID of the car (cf. addVehicle)
     */
    /*void addDriveData(@WebParam(name = "xAccel") float x, @WebParam(name = "yAccel") float y,
                      @WebParam(name = "zAccel") float z, @WebParam(name = "vehicleID") int id);*/
}