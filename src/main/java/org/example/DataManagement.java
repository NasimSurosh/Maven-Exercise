package org.example;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataManagement {

    public static void sqlCreateTable(Statement statement) throws SQLException {
        dropTable(statement);
        String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION " +
                "(id INT , " +
                "name VARCHAR(255), " +
                "lastName VARCHAR(255), " +
                "age INT)";
        statement.executeUpdate(sql);
    }
    public static void insertDataIntoTable(Statement statement) throws SQLException {
        try{
            String sql = "INSERT INTO REGISTRATION (id,name, lastName, age) VALUES (1,'John', 'Doe', 25);";
            statement.executeUpdate(sql);
        }catch (SQLException s){
            s.printStackTrace();
        }
    }
    private static void dropTable(Statement statement) throws SQLException {
        String sql = "DROP TABLE IF EXISTS REGISTRATION";
        statement.executeUpdate(sql);
    }
    
    public static ArrayList<Person> getDataFromTable(Statement statement) throws SQLException{
      
      String sql = "select id, name, lastName, age from REGISTRATION";
      
      ResultSet rs = statement.executeQuery(sql);
      
      ArrayList<Person> peopleList = new ArrayList<>();
      while(rs.next()) {
        int id = rs.getInt("id");
        String first = rs.getString("name");
        String last = rs.getString("lastName");
        int age = rs.getInt("age");
        peopleList.add(new Person(id,first, last, age));

      }
      rs.close();
      return peopleList;
      
      
      
    }
}
