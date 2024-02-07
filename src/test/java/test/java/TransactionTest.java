package test.java;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.DBConnection;
import org.example.Transaction;
import org.junit.Test;

public class TransactionTest {

  @Test
  public void test_EX_1() throws SQLException {
      Transaction transaction = new Transaction();
      transaction.createTransaction();
      transaction.insertTransaction();
      transaction.DisplayResult();
      int total = countRecords();
      
     // Assert.assertEquals(4, total);
      assertEquals(1, total);
  }
  private int countRecords() {
      int total = 0;
      try (Connection connection = DBConnection.getConnection(); 
          Statement stmt = connection.createStatement()) {
          String sql = "SELECT COUNT(*) AS total FROM REGISTRATION ";
          ResultSet count = stmt.executeQuery(sql);
          while(count.next()){
              total = count.getInt("total");
          }
          return total;
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return total;
  }

}
