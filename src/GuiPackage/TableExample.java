package GuiPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableExample {

    TableExample()throws SQLException {
        Connection c = null;
     try{
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
         System.out.println("Opened database successfully");
         String q="insert into newtable(id,software_name,client_name,created_date) values(?,?,?,?);";
         PreparedStatement preparedStatement = c.prepareStatement(q);

         preparedStatement.setInt(1,10);
         preparedStatement.setString(2,"asdasd");
         preparedStatement.setString(3,"kkjkj");
         preparedStatement.setString(4,"213121");
         preparedStatement.executeUpdate();

         c.close();
     }catch(Exception e) {
         e.printStackTrace();
         System.exit(0);
     }

    }
    public static void main(String[] args) {
       try{
           new TableExample();
       }catch (Exception e){
           System.out.println(e);
       }
    }
}
