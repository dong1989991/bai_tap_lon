package sql;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bai1 {
    public static Connection getConnection()  {
        Connection c=null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String url="jdbc:mySQL://localhost:3306/nhasach";
        String username="root";
        String password="123456789";
c=DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return c;
    }
    public static  void closeConnection(Connection c)
    {
    try{
        if(c!=null)
            c.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }



    }
    public  static  void printInfo(Connection c)
    {
        try
        {
            if(c!=null)
            {
                DatabaseMetaData mtdt=c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
