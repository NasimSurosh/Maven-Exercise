package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Transaction {
  
  public void createTransaction() throws SQLException {
    Connection connection = DBConnection.getConnection();
    Statement stmt = null;
    try {
        stmt = connection.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        DataManagement.sqlCreateTable(stmt);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnection.closeConnection(connection);
    }
}
public void insertTransaction() {
    try (Connection connection = DBConnection.getConnection();
         Statement stmt = connection.createStatement()) {
        DataManagement.insertDataIntoTable(stmt);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

  public ArrayList<Person> readTransaction(){
    ArrayList<Person> people = new ArrayList<>();
    
    Connection connection = DBConnection.getConnection();
    try {
     Statement statement = connection.createStatement();
     people = DataManagement.getDataFromTable(statement);
     connection.setAutoCommit(true);
     
    }
    catch(SQLException e) {
      e.printStackTrace();
    }
    return people;
    
  }
  
  public void DisplayResult() {
    System.out.println("display");
    Transaction transaction = new Transaction();
    ArrayList<Person> result = transaction.readTransaction();
    
    for(Person person:result) {
      System.out.println("Name: " + person.getName() +
          " " + person.getLastName()+ " " + "age: " + person.getAge());
    }
    
  }

}
