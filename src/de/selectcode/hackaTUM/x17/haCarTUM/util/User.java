package de.selectcode.hackaTUM.x17.haCarTUM.util;

import java.util.List;

/**
 * the user in the database
 *
 * @author Matthias Kammueller
 */
public abstract class User {
    int CustomerID;
    String name, address;
    List<Integer> vehicleIDs;

    public abstract void notifyOfChange(String text); // TODO: how? what?
}
