package sql03;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoadDriver {
    public static void main(String[] args) throws SQLException{

    List<String> surnames = new ArrayList<>();

            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "passwordhere";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM newdb.students");


         while (resultSet.next()){
             System.out.print(resultSet.getString("first_name")+" ");
             System.out.println(resultSet.getString("last_name"));
             surnames.add(resultSet.getString("last_name"));
         }

    surnames.forEach(System.out::println);

    if(conn != null) { conn.close(); }
    }
}