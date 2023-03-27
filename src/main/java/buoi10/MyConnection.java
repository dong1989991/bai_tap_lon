package buoi10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final  class MyConnection {
public static  final String URL_DB="jdbc:mySQL://localhost:3306/bkacad";
public  static  final String USER_DB="root";
public  static final String PASSWORD_DB="123456789";
public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL_DB,USER_DB,PASSWORD_DB);
}
}
