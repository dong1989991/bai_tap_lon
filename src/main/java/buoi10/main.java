package buoi10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    static  ProductDAO productDAO=new ProductDAO();
    static  BrandDAO brandDAO=new BrandDAO();
    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ SẢN PHẨM ---");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Xóa sản phẩm theo mã");
        System.out.println("4. Câp nhật thông tin sản phẩm");
        System.out.println("5. Lấy thông tin hãng sx");
        System.out.println("6. Top 5 sản phẩm có giá trị cao nhất");
        System.out.println("7. Danh sách hãng sản xuất");
        System.out.println("8. Thêm hãng sản xuất");
        System.out.println("9. Xóa hãng sản xuất theo mã");
    }
    private static  void option1()
    {
        List<Products> productList = productDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "STT", "Tên sản phẩm", "Giá sản phẩm", "Màu sắc");
        System.out.println();
        for (int i = 0; i < productList.size(); i++) {
            Products p = productList.get(i);
            System.out.printf("%-20d %-20s %-20d %-20s\n", (i+1), p.getProduct_name(), p.getProduct_price(), p.getProduct_color());
        };

    }
    public static void main(String[] args) {
//        BrandDAO brandDAO=new BrandDAO();
//        System.out.println(brandDAO.getAll());
//        System.out.println(brandDAO.getById(1));
//        List<Products> list=brandDAO.getAllProductByBrand(1);
//        System.out.println(list);
//
//
//        Brands brands1 = new Brands();
//        brands1.setBrand_name("nhan nam");
//        brands1.setBrand_address("lai chau");
//        brandDAO.insert(brands1);
//       System.out.println(brandDAO.getAll());
//        ProductDAO productDAO=new ProductDAO();
//        System.out.println(productDAO.getAll());
//        System.out.println(productDAO.getById(1));

        Scanner in=new Scanner(System.in);
        int option=-1;
        do{
            mainMenu();
            System.out.println("nhap lua chon");
            option= in.nextInt();
            switch (option)
            {
                case 1:
                    option1();
                    break;
            }
        }
        while(option!=0);
    }
}
