package BaiTapLon.DAO;

import BaiTapLon.Connection.MyConnection;
import BaiTapLon.Model.Accounts;

import java.sql.*;

public class AccountsDAO {
    public int  dang(String a,String b) {
        int kq=0;
        try {

            Connection conn = MyConnection.getConnection();
           // final String sql = String.format("SELECT * FROM accounts WHERE user_name='%s' AND password_name='%s'",a,b);
            final String sql = String.format("SELECT * FROM accounts WHERE CAST(user_name as BINARY(100)) = CAST('%s' as BINARY(100)) " +
                    "AND CAST(password_name as BINARY(100)) = CAST('%s' as BINARY(100))",a,b);

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);


            // Kiểm tra kết quả truy vấn
            if (rs.next()) {
                return 1;
               // System.out.println("Đăng nhập thành công");
            } else {
                return 0;
               // System.out.println("Tài khoản hoặc mật khẩu không đúng");
            }
          // conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
