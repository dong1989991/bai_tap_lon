package bai61.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach> {

    public  static SachDAO getInstance(){
        return  new SachDAO();
    }
    @Override
    public int insert(Sach t) {
        int ketQua=0;
        try{
            // buoc 1;tao ket noi den co so du lieu
            Connection con=JDBCUtil.getConnection();
            // buoc2:tao ra dooi tuong statement
            Statement st=con.createStatement();
            //buoc 3 : thuc thi cau lenh sql
            String sql = "INSERT INTO sach (id, tenSach, giaBan, namXuatBan) "+
                    " VALUES ('"+t.getId()+"' , '"+t.getTenSach()+"' , "+ t.getGiaBan()+" , '"+t.getNamXuatBan()+"')";

             ketQua=st.executeUpdate(sql);
            //b4 xu ly ket qua
            System.out.println("ban da thuc thi:"+sql);
            System.out.println("co" + ketQua+" dong thay doi");
            //nuoc 5
            JDBCUtil.closeConnection(con);
        }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        return ketQua;
    }

    @Override
    public int update(Sach t) {
        int ketQua=0;
        try{
            // buoc 1;tao ket noi den co so du lieu
            Connection con=JDBCUtil.getConnection();
            // buoc2:tao ra dooi tuong statement
            Statement st=con.createStatement();
            //buoc 3 : thuc thi cau lenh sql
            String sql = "UPDATE sach "+
                    " SET " +
                    " tenSach='"+ t.getTenSach()+"'"+
                    ", giaBan="+ t.getGiaBan()+
                    ", namXuatBan="+ t.getNamXuatBan()+
                    " WHERE id='"+t.getId()+"\'";

            ketQua=st.executeUpdate(sql);
            //b4 xu ly ket qua
            System.out.println("ban da thuc thi:"+sql);
            System.out.println("co" + ketQua+" dong thay doi");
            //nuoc 5
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(Sach sach) {
        return 0;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        return null;
    }

    @Override
    public Sach selectByID(Sach sach) {
        return null;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        return null;
    }
}
