package BaiTapLon.DAO;

import BaiTapLon.Connection.MyConnection;
import BaiTapLon.Model.Departments;
import BaiTapLon.Model.Employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<Departments> getAllDepartments() {
        List<Departments> departmentsList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM departments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Departments departments = new Departments();
                departments.setDepartment_id(rs.getString("department_id"));
                departments.setDepartment_name(rs.getString("department_name"));
                departments.setLocation(rs.getString("location"));
                departmentsList.add(departments);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentsList;
    }
    public Departments getByIdDepartments(String id) {
        final String sql=String.format("SELECT * FROM departments WHERE department_id='%s' or department_name='%S' or location='%S'",id,id,id);
        Departments b = null;


        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                b = new Departments();
                b.setDepartment_id(rs.getString("department_id"));
                b.setDepartment_name(rs.getString("department_name"));
                b.setLocation(rs.getString("location"));

            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    public void insertDepartment(Departments d)
    {
        final String sql = String.format("INSERT  INTO `departments` VALUES ( '%s','%s','%s') ",
                d.getDepartment_id(),d.getDepartment_name(),d.getLocation()
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception d1) {
            d1.printStackTrace();
        }
    }
    public void updatePB(Departments departments, String id) {
        Departments tmp = getByIdDepartments(id);
        if (tmp == null) {
            System.out.println("Không tồn tại phòng ban có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE `departments` SET `department_name` = '%s', `location`= '%s'  WHERE `department_id`='%s' ",
                departments.getDepartment_name(),
                departments.getLocation(),
                id

        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void deletePB(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql =  String.format("DELETE  FROM departments WHERE department_id='%s'",id);

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("\n\nXoá thất bại");
                System.out.println("Không có bộ phận "+id+" trong công ty.");
            }
            else System.out.println("\n\nXóa thành công!!!");
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
