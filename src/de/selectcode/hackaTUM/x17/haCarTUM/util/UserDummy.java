package de.selectcode.hackaTUM.x17.haCarTUM.util;

import java.util.ArrayList;

public class UserDummy extends User {
    public UserDummy(int customerID, String first, String last, String ether) {
        this.customerID = customerID;
        this.first = first;
        this.last = last;
        this.ether = ether;
        this.vehicleIDs = new ArrayList<>();
    }

    @Override
    public void notifyOfChange(String text) {
        System.out.println("i'm to lazy ...");
        // do nothing
    }
}
