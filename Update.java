package CRUD;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
    public static void main(String[] args) {

        try {
            // Load and register the diver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_app", "root", "pradipyadav@123");

            PreparedStatement pst = con.prepareStatement("UPDATE user SET city=? WHERE name=? ");

            pst.setString(1, "Mumbai");
            pst.setString(2, "ravi");

            int count = pst.executeUpdate();
            if (count > 0) {
                System.out.println("Update the data successfully");
            } else {
                System.out.println("Unable to update the database");
            }

            pst.close();
            con.close();


        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
