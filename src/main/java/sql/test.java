package sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) throws SQLException {

        try
        {
            // buoc 1 tao ket noi
            Connection connection=Bai1.getConnection();
            // b2: tao ra doi tuong statement
            Statement st=connection.createStatement();
            //b3: thuc thi mot cau lenh ssql
            String sql = "INSERT INTO persons(last_name, first_name, gender, dob, income)"
                    + "VALUES (\"Tran\", \"Thi\", \"C\", \"2000-09-10\", 10000000)";
           int check= st.executeUpdate(sql);
           // b4: xu ly kq
            System.out.println("So dong thay doi:"+check);
if(check > 0)
{
    System.out.println("them du lieu thanh cong");

}else System.out.println("them du lieu that bai");
            //Buoc 5:ngat ket noi
            Bai1.closeConnection(connection);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
