package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudOperations {
    public static void main(String[] args) {

        try{

        // load the driver from the jar file , which is provided by specific vendors;
        Class.forName("com.mysql.cj.jdbc.Driver");

        // aab apka Driver jo my sql ka hai wo apne aap ko register karwa diya hai , DriverManager ke under

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_app" ,"root","pradipyadav@123");

        PreparedStatement pst =con.prepareStatement("INSERT INTO user   VALUES (?,?,?,?,?)");
        pst.setString(1,"Pradip");
        pst.setString(2,"pradip@gmail.com");
        pst.setString(3,"pradip123");
        pst.setString(4,"male");
        pst.setString(5,"Nashik");

            int i = pst.executeUpdate();  // agar database me values insert ho gaye tho ye values 0 se bada dega

            if(i>0){
                System.out.println("Data Insert Successfully");
            }else{
                System.out.println("Data is not inserted successfully");
            }

            pst.close();
            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }




        }
}
