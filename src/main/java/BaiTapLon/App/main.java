package BaiTapLon.App;

import BaiTapLon.DAO.AccountsDAO;
import BaiTapLon.DAO.DepartmentDAO;
import BaiTapLon.DAO.EmployeesDAO;
import BaiTapLon.Model.Departments;
import BaiTapLon.Model.Employees;

import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
    private  static EmployeesDAO employeesDAO=new EmployeesDAO();
    private static AccountsDAO accountsDAO=new AccountsDAO();
    private static   List<Employees> employeesList = employeesDAO.getAll();
    public static DepartmentDAO departmentDAO=new DepartmentDAO();
    public static List<Departments> departmentsList=departmentDAO.getAllDepartments();
    private static void dangNhap()
    {
        Scanner khoiTao=new Scanner(System.in);
        int dem=3;
        System.out.println("\n--------Phần mền quản lý nhân viên công ty ABC------- ");
        while (dem>0)
        {
            System.out.print("Nhập tài khoản:");
            String a=khoiTao.nextLine();
            System.out.print("Nhập mật khẩu:");
            String b=khoiTao.nextLine();
            System.out.println();
            if(accountsDAO.dang(a,b)==1)
            {
                System.out.println("Đăng nhập thành công !!!");
                dem=0;

            }
            else
            {
                System.out.println("Đăng nhập thất bại !!! ");
                dem=dem-1;
                if(dem!=0)
                    System.out.println("Bạn còn "+dem+" lần nhập tài khoản và mật khẩu !!!\n");
                else
                {
                    System.out.println("Bạn đã nhập sai 3 lần. Thoát chương trình !!! ");
                    System.exit(0);
                }


            }
        }

    }
    public static void showAll()
    {
        for(int i=0;i<215;i++)
            System.out.print("_");
        System.out.println();
        System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20s %-20s", "ID Nhân viên","Tên nhân viên", "Giới tính", "Email", "Số điện thoại","Công việc","Lương","ID bộ phận");
        System.out.println();
        for (int i = 0; i < employeesList.size(); i++) {
            Employees em = employeesList.get(i);
            System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20d %-20s |\n", em.getEmployees_id(), em.getEmployees_name(),em.getGender(),em.getEmail(),em.getPhone_number(),em.getEmployees_job(),em.getSalary(),em.getDepartment_id());


        };
        for(int i=0;i<215;i++)
            System.out.print("_");
    }
    public  static void showAllDepartment()
    {
        for(int i=0;i<72;i++)
            System.out.print("_");
        System.out.println();
        System.out.printf("| %-20s %-30s %-15s", "ID Phòng Ban","Tên Phòng Ban", "Location");
        System.out.println();
        for (int i = 0; i < departmentsList.size(); i++) {
            Departments de = departmentsList.get(i);
            System.out.printf("| %-20s %-30s %-15s |\n", de.getDepartment_id(), de.getDepartment_name(),de.getLocation());


        };
        for(int i=0;i<72;i++)
            System.out.print("_");
    }
    private static void themNV(Scanner in){
        Scanner khoitao=new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên cần thêm:");
        int a= khoitao.nextInt();
        List<Employees> employeesListNV = new ArrayList<>();

        for(int i=0;i<a;i++)
        {
            Employees employees = new Employees();
           // List<Employees> employeesListNV = new ArrayList<>();
            System.out.println("\n");
            System.out.println("Nhập thông tin nhân viên thứ:"+(i+1));
          //  Employees employees = new Employees();

            System.out.print("Nhập ID nhân viên : ");
            String idnv=new Scanner(System.in).nextLine();
            employees.setEmployees_id(idnv);

            System.out.print("Nhập Họ Và Tên : ");
            String htnv=new Scanner(System.in).nextLine();
            employees.setEmployees_name(htnv);

            System.out.print("Nhập Giới Tính : ");
            String gtnv=new Scanner(System.in).nextLine();
            employees.setGender(gtnv);

            System.out.print("Nhập Email : ");
            String emailnv=new Scanner(System.in).nextLine();
            employees.setEmail(emailnv);

            System.out.print("Nhập phone : ");
            String sdtnv=new Scanner(System.in).nextLine();
            employees.setPhone_number(sdtnv);

            System.out.print("Nhập employees job : ");
            String jobnv=new Scanner(System.in).nextLine();
            employees.setEmployees_job(jobnv);

            System.out.print("Nhập lương : ");
            long luongnv=new Scanner(System.in).nextLong();
            employees.setSalary(luongnv);

            System.out.print("Nhập id bộ phận: : ");
            String idbp=new Scanner(System.in).nextLine();
            employees.setDepartment_id(idbp);


            employeesListNV.add(employees);
         //   System.out.println(employeesListNV);
        }

        System.out.println("-----------------------THÔNG TIN VỪA NHẬP-------------------------------");
        for(int j=0;j<215;j++) System.out.print("_");
        System.out.println();

        System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20s %-20s", "ID Nhân viên","Tên nhân viên", "Giới tính", "Email", "Số điện thoại","Công việc","Lương","ID bộ phận");
        System.out.println();
        for (int j = 0; j < employeesListNV.size(); j++) {
            Employees em = employeesListNV.get(j);
            System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20d %-20s |\n", em.getEmployees_id(), em.getEmployees_name(),em.getGender(),em.getEmail(),em.getPhone_number(),em.getEmployees_job(),em.getSalary(),em.getDepartment_id());
          //  System.out.println("\n");
            employeesDAO.insert(em);

        };
        for(int i=0;i<215;i++)
            System.out.print("_");
        System.out.println("\n");
        System.out.println("Thêm "+employeesListNV.size()+" thông tin nhân viên thành công!!!");

    }
    public static void themPB(Scanner in)
    {
        Departments departments=new Departments();

        System.out.print("Nhập id bộ phận:");
        departments.setDepartment_id(in.nextLine());

        System.out.print("Nhập tên bộ phận:");
        departments.setDepartment_name(in.nextLine());

        System.out.print("Nhập vị trị của bộ phận:");
        departments.setLocation(in.nextLine());
       // departmentDAO.insertDepartment(departments);

        System.out.println("-----------------------THÔNG TIN VỪA NHẬP-------------------------------");
        for(int j=0;j<72;j++) System.out.print("_");

        System.out.println("\n");
        System.out.printf("| %-20s %-30s %-15s", "ID Phòng Ban","Tên Phòng Ban", "Location");
        System.out.println();
        Departments de=departments;
        System.out.printf("| %-20s %-30s %-15s |\n", de.getDepartment_id(), de.getDepartment_name(),de.getLocation());
        departmentDAO.insertDepartment(departments);
        for(int i=0;i<72;i++)
            System.out.print("_");
        System.out.println("\n");
        System.out.println("Thêm  thông tin bộ phận thành công!!!");
    }
    public static void mainMenu()
    {
        System.out.println(" _____________________________QUẢN LÝ NHÂN VIÊN______________________________");
        System.out.println("| 1.Thêm/sửa/xoá/cập nhật thông tin cho nhân viên.                           |");
        System.out.println("| 2.Thêm/sửa/xoá/cập nhật thông tin cho phòng ban.                           |");
        System.out.println("| 3.Tìm kiếm một nhân viên bất kì theo mã, tên, số điện thoại hoặc email.    |");
        System.out.println("| 4.Thêm nhân viên vào phòng ban/ xoá nhân viên khỏi phòng ban.              |");
        System.out.println("| 5.Chuyển phòng ban cho một nhân viên.                                      |");
        System.out.println("| 6.Tính thuế thu nhập cá nhân cho một nhân viên bất kì.                     |");
        System.out.println("| 7.Hiển thị tất cả nhân viên trong công ty.                                 |");
        System.out.println("| 8.Hiển thị tất cả các bộ phận trong công ty.                               |");
        System.out.println("| 0.Thoát.                                                                   |");
        System.out.println(" ____________________________________________________________________________\n\n");
    }
    public static void mainMenuNhanVien()
    {
        System.out.println("\n");
        System.out.println(" _____________QUẢN LÝ NHÂN VIÊN_______________");
        System.out.println("| 1.Thêm nhân viên.                           |");
        System.out.println("| 2.Sửa thông tin theo id của nhân viên.      |");
        System.out.println("| 3.Xóa nhân viên theo id của nhân viên.      |");
        System.out.println("| 0. Thoát.                                   |");
        System.out.println(" _____________________________________________\n");
    }
    public static void mainMenuPhongBan()
    {
        System.out.println("\n _____________QUẢN LÝ PHÒNG BAN_______________");
        System.out.println("| 1.Thêm một phòng ban                        |");
        System.out.println("| 2.Sửa thông tin cho phòng ban.              |");
        System.out.println("| 3.Xóa phòng ban theo ID của phòng ban       |");
        System.out.println("| 0. Thoát.                                   |");
        System.out.println(" _____________________________________________\n");
    }
    public static void caseNV()
    {    int optionNV=-1;
        Scanner in = new Scanner(System.in);
        do
        {
            mainMenuNhanVien();
            System.out.print("Nhập lựa chọn cho nhân viên: ");
            try{
                optionNV = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Bạn đã nhập ký tự vui lòng lựa chọn số trên menu.");
            }

            if (optionNV < 0 || optionNV > 3) {
                System.out.println("Chỉ nhập các lựa chọn có trong menu. Mời bạn nhập lại.\n\n\n");
                continue;}
            switch (optionNV)
            {
                case 1:
                    themNV(in);

                    break;
                case 2:
                    updateNhanVien(in);
                    break;
                case 3:
                    xoaNhanVien();


            }
        }
        while(optionNV!=0);
    }
    public static void casePB()
    {    int optionNV=-1;
        Scanner in = new Scanner(System.in);
        do
        {
            mainMenuPhongBan();
            System.out.print("Nhập lựa chọn cho phòng ban: ");
            try{
                optionNV = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Bạn đã nhập ký tự vui lòng lựa chọn số trên menu.");
            }

            if (optionNV < 0 || optionNV > 3) {
                System.out.println("Chỉ nhập các lựa chọn có trong menu. Mời bạn nhập lại.\n\n\n");
                continue;}
            switch (optionNV)
            {
                case 1:

                    themPB(in);

                    break;
                case 2:
                    updateThongTinPhongBan(in);
                    break;
                case 3:
                    xoaPhongBan(in);
                    break;
            }
        }
        while(optionNV!=0);
    }
    public static void xoaNhanVien()
    {   Scanner in=new Scanner(System.in);
        System.out.print("Nhap employees id hoặc họ và tên hoặc số điện thoại hoặc email nhân viên bạn cần xóa:");
        String a=in.nextLine();
        List<Employees> employeesList2 = employeesDAO.getIdAll(a);
        employeesDAO.getIdAll(a);
        while(employeesList2.size()==0)
        {

            System.out.println("\n");
            System.out.println("Không nhân viên nào phù hợp với thông tin bạn vừa nhập");
            System.out.println("1. Để tiếp tục tìm kiếm\n2.Thoát");
            try{
                int luachon=-1;
                Scanner khoiTao=new Scanner(System.in);
                luachon= khoiTao.nextInt();
                switch (luachon)
                {
                    case 1: System.out.print("Mời bạn nhập lại thông tin cần xóa:");
                        a=in.nextLine();
                        employeesList2 = employeesDAO.getIdAll(a);
                        employeesDAO.getIdAll(a);
                        continue;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println(" Nhập sai lựa chọn");
                        // System.exit(0);
                }

            }
            catch (InputMismatchException e)
            {
                System.out.println("Chỉ lựa chọn các lựa chọn bên trên.");
            }
        }
        //   System.out.println(employeesDAO.getByID(a));
        for(int i=0;i<215;i++)
            System.out.print("_");
        System.out.println();
        System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20s %-20s", "ID Nhân viên","Tên nhân viên", "Giới tính", "Email", "Số điện thoại","Công việc","Lương","ID bộ phận");
        System.out.println();
        for (int i = 0; i < employeesList2.size(); i++) {
            Employees em = employeesList2.get(i);
            System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20d %-20s |\n", em.getEmployees_id(), em.getEmployees_name(),em.getGender(),em.getEmail(),em.getPhone_number(),em.getEmployees_job(),em.getSalary(),em.getDepartment_id());


        };
        for(int i=0;i<215;i++)
            System.out.print("_");
        System.out.println("\n");
        System.out.println("Bạn có chắc chắn muốn xóa nhân viên với thông tin như trên.");
        System.out.println("1. Xóa nhân viên.\n0. Thoát");
        int luaChon=-1;
        luaChon=in.nextInt();

        switch (luaChon)
        {
            case 1:
                employeesDAO.delete(a);
                System.out.println("Xóa Thành công!!!");
                break;
            case 0:
                break;
        }

    }
    public static void timKiemNhanVienBatKy()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap employees id hoặc họ và tên hoặc số điện thoại hoặc email nhân viên bạn cần tìm:");
        String a=in.nextLine();
        List<Employees> employeesList2 = employeesDAO.getIdAll(a);
        employeesDAO.getIdAll(a);
        while(employeesList2.size()==0)
        {

            System.out.println("\n");
            System.out.println("Không nhân viên nào phù hợp với thông tin bạn vừa nhập");
            System.out.println("1. Để tiếp tục tìm kiếm\n2.Thoát");
            try{
                int luachon=-1;
                Scanner khoiTao=new Scanner(System.in);
                luachon= khoiTao.nextInt();
                switch (luachon)
                {
                    case 1: System.out.print("Mời bạn nhập lại thông tin cần tìm kiếm:");
                        a=in.nextLine();
                        employeesList2 = employeesDAO.getIdAll(a);
                        employeesDAO.getIdAll(a);
                        continue;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println(" Nhập sai lựa chọn");
                       // System.exit(0);
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Chỉ lựa chọn các lựa chọn bên trên.");
            }
        }
            //   System.out.println(employeesDAO.getByID(a));
            for(int i=0;i<215;i++)
                System.out.print("_");
            System.out.println();
            System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20s %-20s", "ID Nhân viên","Tên nhân viên", "Giới tính", "Email", "Số điện thoại","Công việc","Lương","ID bộ phận");
            System.out.println();
            for (int i = 0; i < employeesList2.size(); i++) {
                Employees em = employeesList2.get(i);
                System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20d %-20s |\n", em.getEmployees_id(), em.getEmployees_name(),em.getGender(),em.getEmail(),em.getPhone_number(),em.getEmployees_job(),em.getSalary(),em.getDepartment_id());


            };
            for(int i=0;i<215;i++)
                System.out.print("_");
            System.out.println("\n");


    }
    public static void updateNhanVien(Scanner in)
    {
        Employees employees = new Employees();
        System.out.print("Nhập id nhân viên cần cập nhật : ");
        String idnv=new Scanner(System.in).nextLine();
        employees.setEmployees_id(idnv);

        System.out.println("\n");
        System.out.println("-----------------------THÔNG TIN NHÂN VIÊN CŨ-------------------------------");
        for(int j=0;j<215;j++) System.out.print("_");
        System.out.println();
        Employees em=employeesDAO.getById(idnv);
        System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20s %-20s", "ID Nhân viên","Tên nhân viên", "Giới tính", "Email", "Số điện thoại","Công việc","Lương","ID bộ phận");
        System.out.println();
        System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20d %-20s |\n", em.getEmployees_id(), em.getEmployees_name(),em.getGender(),em.getEmail(),em.getPhone_number(),em.getEmployees_job(),em.getSalary(),em.getDepartment_id());
        for(int i=0;i<215;i++)
            System.out.print("_");
        System.out.println("\n");

        System.out.print("Nhập Họ Và Tên : ");
        String htnv=new Scanner(System.in).nextLine();
        employees.setEmployees_name(htnv);

        System.out.print("Nhập Giới Tính : ");
        String gtnv=new Scanner(System.in).nextLine();
        employees.setGender(gtnv);

        System.out.print("Nhập Email : ");
        String emailnv=new Scanner(System.in).nextLine();
        employees.setEmail(emailnv);

        System.out.print("Nhập phone : ");
        String sdtnv=new Scanner(System.in).nextLine();
        employees.setPhone_number(sdtnv);

        System.out.print("Nhập employees job : ");
        String jobnv=new Scanner(System.in).nextLine();
        employees.setEmployees_job(jobnv);

        System.out.print("Nhập lương : ");
        long luongnv=new Scanner(System.in).nextLong();
        employees.setSalary(luongnv);

        System.out.print("Nhập id bộ phận: : ");
        String idbp=new Scanner(System.in).nextLine();
        employees.setDepartment_id(idbp);

        employeesDAO.updateNV(employees, idnv);

        System.out.println("\n");
        System.out.println("-----------------------THÔNG TIN NHÂN VIÊN SAU UPDATE-------------------------------");
        for(int j=0;j<215;j++) System.out.print("_");
        System.out.println();
        Employees em1=employeesDAO.getById(idnv);
        System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20s %-20s", "ID Nhân viên","Tên nhân viên", "Giới tính", "Email", "Số điện thoại","Công việc","Lương","ID bộ phận");
        System.out.println();
        System.out.printf("| %-20s %-30s %-15s %-40s %-20s %-40s %-20d %-20s |\n", em1.getEmployees_id(), em1.getEmployees_name(),em1.getGender(),em1.getEmail(),em1.getPhone_number(),em1.getEmployees_job(),em1.getSalary(),em1.getDepartment_id());
        for(int i=0;i<215;i++)
            System.out.print("_");
        System.out.println("\n");

    }
    public static void updateThongTinPhongBan(Scanner in)
    {
        Departments departmentsUpdate=new Departments();

        System.out.print("Nhập id của phòng ban cần cập nhật:");
        String id=in.nextLine();

        Departments e=departmentDAO.getByIdDepartments(id);
        System.out.println("-----------------------THÔNG TIN PHÒNG BAN TRƯỚC KHI THAY ĐỔI-------------------------------");
        for(int j=0;j<72;j++) System.out.print("_");

        System.out.println("\n");
        System.out.printf("| %-20s %-30s %-15s", "ID Phòng Ban","Tên Phòng Ban", "Location");
        System.out.println();
        System.out.printf("| %-20s %-30s %-15s |\n", e.getDepartment_id(), e.getDepartment_name(),e.getLocation());
        for(int i=0;i<72;i++) System.out.print("_");

        System.out.print("\nNhập tên của phòng ban:");
        departmentsUpdate.setDepartment_name(in.nextLine());

        System.out.print("Nhập vị trí của phòng ban:");
        departmentsUpdate.setLocation(in.nextLine());

        System.out.println("-----------------------THÔNG TIN PHÒNG BAN SAU KHI THAY ĐỔI-------------------------------");
        for(int j=0;j<72;j++) System.out.print("_");
        System.out.println("\n");
        System.out.printf("| %-20s %-30s %-15s", "ID Phòng Ban","Tên Phòng Ban", "Location");
        System.out.println("\n");
        System.out.printf("| %-20s %-30s %-15s |\n", e.getDepartment_id(), departmentsUpdate.getDepartment_name(),departmentsUpdate.getLocation());
        for(int i=0;i<72;i++) System.out.print("_");

        departmentDAO.updatePB(departmentsUpdate,id);
    }
    public static void xoaPhongBan(Scanner in)
    {
       // Departments departmentsUpdate=new Departments();

       System.out.print("Nhập id của phòng ban cần xóa:");
        String id=in.nextLine();
        employeesDAO.choNVNull(id);
        departmentDAO.deletePB(id);
    }
    public static void chuyenPhongBanNV(Scanner in)
    {
        try{
        Employees employees = new Employees();
        System.out.print("Nhập id nhân viên cần chuyển phòng ban : ");
        String idnv=new Scanner(System.in).nextLine();
        employees.setEmployees_id(idnv);

        System.out.println("\n");
        System.out.println("-----------------------THÔNG TIN NHÂN VIÊN CŨ TRƯỚC KHI  -------------------------------");
        for(int j=0;j<45;j++) System.out.print("_");
        System.out.println();
        Employees em=employeesDAO.getById(idnv);
        System.out.printf("| %-20s %-20s", "ID Nhân viên","ID bộ phận");
        System.out.println();
        System.out.printf("| %-20s %-20s |\n", em.getEmployees_id(), em.getDepartment_id());
        for(int i=0;i<45;i++)
            System.out.print("_");
        System.out.println("\n");

        System.out.print("Nhập id bộ phận: : ");
        String idbp=new Scanner(System.in).nextLine();
        employees.setDepartment_id(idbp);

        employeesDAO.chuyenPhongBanChoNhanVien(employees, idnv);

        System.out.println("\n");
        System.out.println("-----------------------THÔNG TIN NHÂN VIÊN SAU UPDATE-------------------------------");
        for(int j=0;j<45;j++) System.out.print("_");
        System.out.println();
        Employees em1=employeesDAO.getById(idnv);
        System.out.printf("| %-20s %-20s", "ID Nhân viên","ID bộ phận");
        System.out.println();
        System.out.printf("| %-20s %-20s |\n", em1.getEmployees_id(), em1.getDepartment_id());
        for(int i=0;i<45;i++)
            System.out.print("_");
        System.out.println("\n");}
        catch (NullPointerException e)
        {
            System.out.println("\n\n\nKhông có nhân viên với mã id vừa nhập.");
        }

    }
    public static void luaCHon4()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("\n");
        System.out.println(" _____________QUẢN LÝ NHÂN VIÊN_______________");
        System.out.println("| 1.Thêm nhân viên vào phòng ban.             |");
        System.out.println("| 2.Xóa nhân viên ra khỏi phòng ban.          |");
        System.out.println("| 0. Thoát.                                   |");
        System.out.println(" _____________________________________________\n");
        int luachon=-1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vui lòng nhập một số nguyên từ 0 đến 2: ");
        String input = scanner.nextLine();
        int number=-1;
        String pattern = "[0-2]";
        if (input.matches(pattern)) {
            number= Integer.parseInt(input);
        } else {
            while (input.matches(pattern)==false)
            {
                System.out.print("Bạn đã nhập sai lựa chọn. Vui lòng nhập lại:");
                input = scanner.nextLine();
            }
            number=Integer.parseInt(input);
        }
        switch (number)
        {
            case 1:
                themNV(in);
                break;
            case 2:
                xoaNhanVien();
                break;
            case 0:
                break;
        }

    }
    public static void tinhThueThuNhapCaNhan()
    {
        int luachon=-1;
        while(luachon!=0)
        {
        try
    {
        Employees e=new Employees();
        Scanner khoiTao=new Scanner(System.in);
        System.out.print("Nhập id của nhân viên:");
        String idNV=khoiTao.nextLine();
        e=employeesDAO.getById(idNV);
        long luong=23000*e.getSalary();
        System.out.println("Thông tin lương trước thuế của nhân viên "+e.getEmployees_name() +" là:" + luong+ " VND");
        luachon=0;
        long luongTinhThue=luong-11000000;
        if(luongTinhThue<=0)
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+"không phải trả thuế với mức hiện tại.");
        }
        else if(luongTinhThue>0 && luongTinhThue<=5000000)
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+" phải nộp:"+(luongTinhThue*0.05)+" VND tiền thuế");
            long l= (long) (luong-(luongTinhThue*0.05));
            System.out.println("Số tiền nhận sau thuế là:"+l);
        }
        else if(luongTinhThue>5000000 && luongTinhThue<=10000000)
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+" phải nộp:"+(luongTinhThue*0.1)+" VND tiền thuế");
            long l= (long) (luong-(luongTinhThue*0.1));
            System.out.println("Số tiền nhận sau thuế là:"+l);
        }
        else if(luongTinhThue>10000000 && luongTinhThue<=18000000)
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+" phải nộp:"+(luongTinhThue*0.15)+" VND tiền thuế");
            long l= (long) (luong-(luongTinhThue*0.15));
            System.out.println("Số tiền nhận sau thuế là:"+l);
        }
        else if(luongTinhThue>18000000 && luongTinhThue<=32000000)
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+" phải nộp:"+(luongTinhThue*0.2)+" VND tiền thuế");
            long l= (long) (luong-(luongTinhThue*0.2));
            System.out.println("Số tiền nhận sau thuế là:"+l);
        }
        else if(luongTinhThue>32000000 && luongTinhThue<=52000000)
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+" phải nộp:"+(luongTinhThue*0.25)+" VND tiền thuế");
            long l= (long) (luong-(luongTinhThue*0.25));
            System.out.println("Số tiền nhận sau thuế là:"+l);
        }
        else if(luongTinhThue>52000000 && luongTinhThue<=80000000)
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+" phải nộp:"+(luongTinhThue*0.3)+" VND tiền thuế");
            long l= (long) (luong-(luongTinhThue*0.3));
            System.out.println("Số tiền nhận sau thuế là:"+l);
        }
        else
        {
            System.out.println("Nhân viên "+e.getEmployees_name()+" phải nộp:"+(luongTinhThue*0.35)+" VND tiền thuế");
            long l= (long) (luong-(luongTinhThue*0.35));
            System.out.println("Số tiền nhận sau thuế là:"+l);
        }
    }
        catch (NullPointerException e1)
        {
            System.out.println("Bạn đã nhập sai mã nhân viên, Mời nhập lại.");

            System.out.println("Bạn có muốn tiếp tục:\n1.Tiếp tục.\n2.Thoát.");
            Scanner scanner = new Scanner(System.in);
           // System.out.print("Vui lòng nhập một số nguyên từ 0 đến 9: ");
            String input = scanner.nextLine();
            int number=-1;
            String pattern = "[1-2]";
            if (input.matches(pattern)) {
                number= Integer.parseInt(input);
            } else {
                while (input.matches(pattern)==false)
                {
                    System.out.print("Bạn đã nhập sai lựa chọn. Vui lòng nhập lại:");
                    input = scanner.nextLine();
                }
                number=Integer.parseInt(input);
            }
            switch (number)
            {
                case 1:
                    luachon=1;
                    break;
                case 2:
                    System.exit(0);
            }
        }
        }


    }
    public static void main(String[] args) {
//showAllDepartment();
       dangNhap();
        Scanner in = new Scanner(System.in);
        int option = -1;


        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            try{
                option = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Bạn đã nhập ký tự vui lòng lựa chọn số trên menu.");
            }

            if (option < 0 || option > 8) {
                System.out.println("Chỉ nhập các lựa chọn có trong menu. Mời bạn nhập lại.\n");
                continue;
            }
            switch (option) {
                case 1:
                    caseNV();
                    break;
                case 2:
                    casePB();
                    break;
                case 3:
                    timKiemNhanVienBatKy();
                    break;
                case 4:
                    luaCHon4();
                    break;
                case 5:
                    chuyenPhongBanNV(in);
                    break;
                case 6:
                    tinhThueThuNhapCaNhan();
                    break;
                case 7:
                    showAll();
                    break;
                case 8:
                    showAllDepartment();
                    break;
            }

        }
        while (option != 0);
        in.close();
    }


}
