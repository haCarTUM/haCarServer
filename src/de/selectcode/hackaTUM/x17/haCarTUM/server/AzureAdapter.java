package de.selectcode.hackaTUM.x17.haCarTUM.server;

import de.selectcode.hackaTUM.x17.haCarTUM.util.User;
import de.selectcode.hackaTUM.x17.haCarTUM.util.UserDummy;

import java.sql.*;
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
 */
public class AzureAdapter {
    private Connection connection;

    public AzureAdapter() {
        // Connect to database
        String hostName = "hacartum.database.windows.net";
        String user = "flobaader";
        String password = "Florian123";
        String dbName = "predictions";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection to DB-Server  --  Schema: " + schema);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param last  last name
     * @param first first name
     * @param ether his ether "credential"
     * @return -1 if failed, otherwise the customer id
     */
    public int addUser(String last, String first, String ether) {
        // TODO check ether
        String selectSql =
                "INSERT INTO users (firstname, lastname, ether) VALUES ('" + first + "', '" + last + "', '" + ether + "')";

        try {
            Statement statement = connection.createStatement();
            statement.execute(selectSql);

            return 0; // TODO: find a way to get the real cID
        } catch (SQLException e1) {
            e1.printStackTrace();
            return -1;
        }
    }

    public List<User> getUsers() {
        // Create and execute a SELECT SQL statement.
        String selectSql = "SELECT * FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSql)) {
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(new UserDummy(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * a job for the AI
     * based on all "unused" data
     *
     * @param v the vehicle ID
     * @return the current rating in [1, 5]
     */
    public int getRatingForVehicle(int v) {
        //TODO  AI.calculateRating(uID)
        // TODO: check if existent
        int ratingForLastDrives = 2; // AI-Job
        int absLastDrives = 1337; // AI-Job (# of data)
        final float abs = getAbsData(v);
        setRating(v, ((getRating(v) * abs) + ratingForLastDrives * absLastDrives) / (abs + absLastDrives));
        return ratingForLastDrives;
    }

    /**
     * @param car vehicleID
     * @return true on success
     */
    private boolean setRating(int car, float newRating) {
        String selectSql =
                "UPDATE cars SET rating = '" + newRating + "' WHERE carNr ='" + car + "';";

        try {
            Statement statement = connection.createStatement();
            statement.execute(selectSql);
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    /**
     * @param car carID
     * @return the current rating
     */
    private float getRating(int car) {
        String selectSql = "SELECT * FROM cars WHERE carNr = '" + car + "';";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            if (resultSet.next()) {
                return resultSet.getFloat("rating");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return -1;
    }

    /**
     * @param car carID
     * @return the scale of the rating, -1 if failure
     */
    private float getAbsData(int car) {
        String selectSql = "SELECT * FROM cars WHERE carNr = '" + car + "';";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            if (resultSet.next()) {
                return resultSet.getInt("absData");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return -1;
    }

    /**
     * @param userID    the customer
     * @param vehicleID a unique thing of a car (!= colour)
     * @return true in case of success
     * TODO: waiting for response? (maybe in future...)
     */
    public boolean addCar(int userID, int vehicleID) {
        String selectSql =
                "INSERT INTO cars (customer, carNr, rating, absData) VALUES ('" + userID + "', '" + vehicleID + "', 2, 1)";

        try {
            Statement statement = connection.createStatement();
            statement.execute(selectSql);

            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    public void addDriveData(float x, float y, float z, int carID) {
        String selectSql =
                "INSERT INTO drive_data (car, x, y, z) VALUES ('" + carID + "', '" + x + "', '" + y + "', '" + z + "')";

        try {
            Statement statement = connection.createStatement();
            statement.execute(selectSql);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    /**
     *
     * @param userNr the customer ID
     * @return the IDs of his vehicles
     */
    public List<Integer> findVehicles(int userNr) {
        ArrayList<Integer> cars = new ArrayList<>();
        String selectSql = "SELECT * FROM cars WHERE customer = '" + userNr + "';";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                cars.add(resultSet.getInt("carNr"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return cars;
    }

}
