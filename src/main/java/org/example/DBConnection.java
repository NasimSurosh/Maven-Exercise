package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  private static final String user = "postgres";
  private static final String pwd = "Nasim646016";
  private static final String url = "jdbc:postgresql://localhost:5432/test";
  
  public static Connection getConnection() {
    Connection connection = null;
    try {
        connection = DriverManager.getConnection (url, user,pwd);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        connection.setAutoCommit(true);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;
}
public static void closeConnection(Connection connection) {
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  }
}
