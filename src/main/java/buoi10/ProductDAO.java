package buoi10;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ProductDAO {

    public List<Products> getAll() {
        final String sql = "SELECT * FROM `products`";

        List<Products> productList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Products p = new Products();
                p.setId(rs.getInt("id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setProduct_color(rs.getString("product_color"));
                p.setProduct_size(rs.getString("product_size"));
                p.setBrand_id(rs.getInt("brand_id"));
                p.setProduct_price(rs.getInt("product_price"));
                productList.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    public Products getById(long id) {
        final String sql = "SELECT * FROM `products` WHERE  `id` = " + id;
        Products p = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                p = new Products();
                p.setId(rs.getInt("id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setProduct_color(rs.getString("product_color"));
                p.setProduct_size(rs.getString("product_size"));
                p.setBrand_id(rs.getInt("brand_id"));
                p.setProduct_price(rs.getInt("product_price"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void insert(Products p) {
        final String sql = String.format("INSERT  INTO `products` VALUES ( NULL,'%s','%d','%s','%s','%d' ) ",
                p.getProduct_name(), p.getProduct_price(), p.getProduct_size(), p.getProduct_color(), p.getBrand_id()
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Products product, long id) {
        Products tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Sản phẩm không tồn tại!");
        }

        final String sql = String.format("UPDATE `products` SET `product_name`='%s',`product_price`='%d',`product_size`='%s',`product_color`='%s',`brand_id`='%d' WHERE `id` = '%d'",
                product.getProduct_name(), product.getProduct_price(), product.getProduct_size(), product.getProduct_color(), product.getBrand_id(), id
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


    public void delete(long id) {
        Products product = getById(id);
        if (product == null) {
            throw new RuntimeException("Sản phẩm không tồn tại!");
        }

        final String sql = "DELETE FROM `products` WHERE  `id` = " + id;
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
