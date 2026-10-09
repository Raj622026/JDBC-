import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Product {
    String url="jdbc:mysql://localhost:3306/products_db?user=root&password=12345";
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet rs=null;
    void createProduct(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url);
            System.out.println("Connection Done");


            String sql = "INSERT INTO product (name, price, quantity, category, description) VALUES (?, ?, ?, ?, ?)";
            preparedStatement=connection.prepareStatement(sql);

            //product 1
            preparedStatement.setString(1, "Mobile");
            preparedStatement.setDouble(2, 25000.0);
            preparedStatement.setInt(3, 10);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.setString(5, "Samsung Mobile");
            preparedStatement.addBatch();

            //2
            preparedStatement.setString(1, "Mouse");
            preparedStatement.setDouble(2, 2500.0);
            preparedStatement.setInt(3, 10);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.setString(5, "DELL mouse");
            preparedStatement.addBatch();
            //3
            preparedStatement.setString(1, "Mobile");
            preparedStatement.setDouble(2, 250000.0);
            preparedStatement.setInt(3, 10);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.setString(5, "Samsung  FOLD 8 Mobile");
            preparedStatement.addBatch();
            //4
            preparedStatement.setString(1, "Mobile");
            preparedStatement.setDouble(2, 12300.0);
            preparedStatement.setInt(3, 10);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.setString(5, "VIVO Mobile");
            preparedStatement.addBatch();

            int res[]=preparedStatement.executeBatch();
            System.out.println("Data inserted"+ Arrays.toString(res));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void updateProduct(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url);
            System.out.println("Connection done");

            String sql="update product set description=?  where id=?";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,"Iphone 18pro");
            preparedStatement.setInt(2,1);

            int res=preparedStatement.executeUpdate();
            System.out.println("Update the data "+res);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void deleteProduct(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url);
            System.out.println("Connection done");
            String sql="delete from product where id=?";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("Enter the id which you want to delete : ");
            preparedStatement.setInt(1,new Scanner(System.in).nextInt());

            int res=preparedStatement.executeUpdate();
            System.out.println("Deleted row "+res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void readProduct(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url);
            System.out.println("Connection done");
            String sql="select id,name, price, quantity, category, description from product ";
            preparedStatement = connection.prepareStatement(sql);
            rs=preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("------------------------");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
