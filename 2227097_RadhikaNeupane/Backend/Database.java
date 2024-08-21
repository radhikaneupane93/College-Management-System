package Backend;

import java.sql.*;

public class Database{

private static final Connection connection = getDBConnection();

public static  Connection getDBConnection(){
    
    try {
     String connectionString = "jdbc:mysql://"+Config.dbHost+":"+ Config.dbPort +
                "/"+ Config.dbName;
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(connectionString, Config.dbUser, Config.dbPass);
 } catch (SQLException e) {
     e.printStackTrace();
 }
    return connection;
}

public static Statement getStatement() {
      try {
          return connection.createStatement();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;

  }
}