package de.selectcode.hackaTUM.x17.haCarTUM.server.ether.teststuff;

import de.selectcode.hackaTUM.x17.haCarTUM.server.AzureAdapter;

public class DBTester {
    public static void main(String[] args) {


        AzureAdapter adapter = new AzureAdapter("trainingsdaten");
        System.out.println(adapter.getUsers());
//        adapter.addUser("huber", "horst", "haha");
//        System.out.println(adapter.getUsers());
//        adapter.addUser("huber", "hans", "hehe");
//        System.out.println(adapter.getUsers());
        adapter.addCar(7, 1);
        adapter.addCar(7, 2);
        adapter.addCar(7, 3);
        System.out.println(adapter.getRatingForVehicle(1));
        adapter.addDriveData(0, 0, 0, 3);
        System.out.println(adapter.getRatingForVehicle(1));
    }
}
