package BaiTapLon.DAO;

import BaiTapLon.Connection.MyConnection;
import BaiTapLon.Model.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeesDAO {

    public List<Employees> getAll() {
        List<Employees> employeesList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            // goi hàm Connection và lấy lcass MyConnection và từ class đó lấy hàm getMyconnection
            Connection conn = MyConnection.getConnection();


            final String sql = "SELECT * FROM employees";
// tao ra dối tượng stament
            Statement stmt = conn.createStatement();
            // gọi câu lệnh thực thi với sql
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employees employees = new Employees();
                employees.setEmployees_id(rs.getString("employees_id"));
                employees.setEmployees_name(rs.getString("employees_name"));
                employees.setGender(rs.getString("gender"));
                employees.setEmail(rs.getString("email"));
                employees.setPhone_number(rs.getString("phone_number"));
                employees.setEmployees_job(rs.getString("employees_job"));
                employees.setSalary(rs.getLong("salary"));
                employees.setDepartment_id(rs.getString("department_id"));
                employeesList.add(employees);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesList;
    }
    public List<Employees> getIdAll(String id) {
        List<Employees> employeesList2 = new ArrayList<>();
        // employeesList2=null;
        try {
            // goi hàm Connection và lấy lcass MyConnection và từ class đó lấy hàm getMyconnection
            Connection conn = MyConnection.getConnection();


            final String sql=String.format("SELECT * FROM employees WHERE employees_id='%s' or " +
                    "email='%S' or phone_number='%S' or employees_name='%s'",id,id,id,id);
// tao ra dối tượng stament
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();


            while (rs.next()) {
                Employees employees = new Employees();
                employees.setEmployees_id(rs.getString("employees_id"));
                employees.setEmployees_name(rs.getString("employees_name"));
                employees.setGender(rs.getString("gender"));
                employees.setEmail(rs.getString("email"));
                employees.setPhone_number(rs.getString("phone_number"));
                employees.setEmployees_job(rs.getString("employees_job"));
                employees.setSalary(rs.getLong("salary"));
                employees.setDepartment_id(rs.getString("department_id"));
                employeesList2.add(employees);
            }
            rs.close();
            stmt.close();
            conn.close();
            return employeesList2;


        } catch (Exception e) {
            e.printStackTrace();
        }
       return employeesList2;
        //return  null;
    }

public Employees getById(String id) {
    final String sql=String.format("SELECT * FROM employees WHERE employees_id='%s' or email='%S' or phone_number='%S' or employees_name='%s'",id,id,id,id);
    Employees b = null;


    try {
        Connection conn = MyConnection.getConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            b = new Employees();
               b.setEmployees_id(rs.getString("employees_id"));
               b.setEmployees_name(rs.getString("employees_name"));
               b.setGender(rs.getString("gender"));
               b.setEmail(rs.getString("email"));
               b.setPhone_number(rs.getString("phone_number"));
               b.setEmployees_job(rs.getString("employees_job"));
               b.setSalary(rs.getLong("salary"));
               b.setDepartment_id(rs.getString("department_id"));
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return b;
}
    public void insert(Employees e) {
        final String sql = String.format("INSERT  INTO `employees` VALUES ( '%s','%s','%s','%s','%s','%s' ,'%d','%s') ",
                e.getEmployees_id(),e.getEmployees_name(),e.getGender(),e.getEmail(),e.getPhone_number(),
                e.getEmployees_job(),e.getSalary(),e.getDepartment_id()
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
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void delete(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql =  String.format("DELETE  FROM employees WHERE employees_id='%s' or " +
                    "email='%S' or phone_number='%S' or employees_name='%s'",id,id,id,id);

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateNV(Employees employees, String id) {
        Employees tmp = getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE `employees` SET `employees_name` = '%s', `gender`= '%s' ," +
                        "`email`='%s',`phone_number`='%s',`employees_job`" +
                        "='%s',`salary`='%d',`department_id`='%s' WHERE `employees_id`='%s' ",
                employees.getEmployees_name(),
                employees.getGender(),
                employees.getEmail(),
                employees.getPhone_number(),
                employees.getEmployees_job(),
                employees.getSalary(),
                employees.getDepartment_id(),
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
    public void choNVNull( String id) {

        final String sql = String.format("UPDATE `employees` SET `department_id` = null WHERE `department_id`='%s' ",
                id
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void chuyenPhongBanChoNhanVien(Employees employees, String id) {
        Employees tmp = getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE `employees` SET `department_id` = '%s' WHERE `employees_id`='%s' ",

                employees.getDepartment_id(),
                employees.getEmployees_id()

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

}
