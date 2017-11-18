package de.selectcode.hackaTUM.x17.haCarTUM.server;

import de.selectcode.hackaTUM.x17.haCarTUM.util.User;

import java.util.ArrayList;
import java.util.List;

/**
 * communication with the Azure Database & the AI
 * TODO
 */
public class AzureAdapter {
    // TODO: uplink 'n' stuff

    public AzureAdapter() {
        // ...
    }

    /**
     * @param name    name of the user
     * @param address address of the user, e.g. for invoices
     * @return -1 if failed, otherwise the customer id
     */
    int addUser(String name, String address) {
        return -1;
    }

    List<User> getUsers() {
        // DB.getUsers
        return new ArrayList<>();
    }

    /**
     * @param customerID the number of the user
     * @return his address for invoices etc
     */
    String getAddress(int customerID) {
        // DB.getAddress
        return "12345 example city";
    }

    /**
     * a job for the AI
     * based on all "unused" data
     *
     * @return the current rating in [1, 5]
     */
    int getRatingForUser(int customerID) {
        // AI.calculateRating(uID)
        return -1;
    }

    /**
     * @param userID    the customer
     * @param vehicleID a unique thing of a car (!= colour)
     * @return true in case of success
     * TODO: waiting for response?
     */
    boolean addCar(int userID, int vehicleID) {
        return false;
    }

}
