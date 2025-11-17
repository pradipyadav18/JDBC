package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_app","root","pradipyadav@123");

            PreparedStatement pst=con.prepareStatement("Delete from user WHERE name=? ");
            pst.setString(1,"Pradip");

            int count = pst.executeUpdate();

            if(count >1){
                System.out.println("Deleted SUccessfully");
            }else{
                System.out.println("Unable to delete the data");
            }

            pst.close();
            con.close();



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }
}
