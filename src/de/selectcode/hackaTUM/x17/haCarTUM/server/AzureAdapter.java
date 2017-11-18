package de.selectcode.hackaTUM.x17.haCarTUM.server;

import de.selectcode.hackaTUM.x17.haCarTUM.util.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE users (
  id        INT PRIMARY KEY IDENTITY (1, 1),
  firstname VARCHAR(128),
  lastname  VARCHAR(128),
  ether     TEXT
);

CREATE TABLE cars (
  customer INT,
  carNr    INT PRIMARY KEY,
  rating   FLOAT,
  absData  INT
);

CREATE TABLE drive_data (
  nr  INT PRIMARY KEY IDENTITY (1, 1),
  car INT,
  x   FLOAT,
  y   FLOAT,
  z   FLOAT,
);
 */

/**
 * communication with the Azure Database & the AI
 * TODO
 */
public class AzureAdapter {

    public static void main(String[] args) {

        // Connect to database
        String hostName = "hacartum.database.windows.net";
        String dbName = "trainingsdaten";
        String user = "matthias";
        String password = "Palladium$1";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM dbo.sensor_data";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getFloat(1) + " "
                            + resultSet.getFloat(2) + " " +
                            +resultSet.getFloat(4));
                }
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param last  last name
     * @param first first name
     * @param ether     his ether "credential"
     * @return -1 if failed, otherwise the customer id
     */
    int addUser(String last, String first, String ether) {
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

    void addDriveData(float x, float y, float z, int carID) {
        // TODO
    }

}
