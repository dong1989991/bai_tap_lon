package buoi10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {
    public List<Brands> getAll()
    {
        final String sql="SELECT * FROM `brands`";
        List<Brands> brandsList=new ArrayList<>();
        try{
            Connection conn=MyConnection.getConnection();

            //gui cac cau lenh sql den csdl
            Statement stmt=conn.createStatement();

            // thuc hien de truy van select
            ResultSet rs=stmt.executeQuery(sql);

            while(rs.next())
            {
                Brands b=new Brands();
                b.setId(rs.getInt("id"));
                b.setBrand_name(rs.getString("brand_name"));
                b.setBrand_address(rs.getString("brand_address"));
                //b.getBrand_address(rs.getString("brand_address"));
                brandsList.add(b);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


return  brandsList;
    }
    public Brands getById(long id)
    {
        final String sql="SELECT * FROM `brands` WHERE `id` = " +id;
        Brands b=null;
        try{
            Connection conn=MyConnection.getConnection();

            //gui cac cau lenh sql den csdl
            Statement stmt=conn.createStatement();

            // thuc hien de truy van select
            ResultSet rs=stmt.executeQuery(sql);

            if(rs.next())
            {
                b=new Brands();
                b.setId(rs.getInt("id"));
                b.setBrand_name(rs.getString("brand_name"));
                b.setBrand_address(rs.getString("brand_address"));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
return b;
    }
    public List<Products> getAllProductByBrand(long brandID)
    {   Brands b=getById(brandID);
            if(b==null)
            {
                throw new RuntimeException(" hang khong ton tai");
            }
        final String sql="SELECT * FROM products WHERE `brand_id`="+brandID;
       List<Products> productsList=new ArrayList<>();
        try
        {
        Connection conn=MyConnection.getConnection();

        Statement stmt=conn.createStatement();

        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next())
        {
            Products p=new Products();
            p.setId(rs.getInt("id"));
            p.setProduct_name(rs.getString("product_name"));
            p.setProduct_price(rs.getInt("product_price"));
            p.setProduct_size(rs.getString("product_size"));
            p.setProduct_color(rs.getString("product_color"));
            p.setBrand_id(rs.getInt("brand_id"));
            productsList.add(p);
        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

            return productsList;
    }

    public void insert(Brands brand)
    {

        final String sql=String.format("INSERT INTO  `brands` values (null,'%s','%s') ",
        brand.getBrand_name(),brand.getBrand_address()
        );
        try
        {
            Connection conn=MyConnection.getConnection();
            Statement stmt=conn.createStatement();

            long rs=stmt.executeUpdate(sql);
            if(rs==0)
                System.out.println("them that bai");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update(Brands brand,long id)
    {
        Brands b = getById(id);
        if (b == null) {
            throw new RuntimeException("Hãng không tồn tại!");
        }

        final String sql = String.format(
                "UPDATE `brands` SET `brand_name`='%s', `brand_address`='%s' WHERE `id` = '%d'",
                brand.getBrand_name(), brand.getBrand_address(), id
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(long id)
    {
        final String sql="DELETE FROM `brands` where `id`="+id;
        try
        {
            Connection conn=MyConnection.getConnection();
            Statement stmt=conn.createStatement();

            long rs=stmt.executeUpdate(sql);
            if(rs==0)
                System.out.println("xoa that bai");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
