package com.hackerrank.eshopping.product.dashboard.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.hackerrank.eshopping.product.dashboard.model.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository("ProductStockDao")
public class ProductStockDao {
    static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";  
    static final String USER = "admin"; 
    static final String PASS = "";

    private Statement createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn.createStatement();
    }

    private List<Product> productMapper(ResultSet rs) throws SQLException {
        List<Product> response = new ArrayList<Product>();
        while(rs.next()) {
            Product p = new Product();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setCategory(rs.getString("category"));
            p.setRetail_price(rs.getDouble("retail_price"));
            p.setDiscounted_price(rs.getDouble("discounted_price"));
            p.setAvailability(rs.getBoolean("availability"));
            response.add(p);
        }
        return response;
    }

    public void addProduct(Product p) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO products VALUES(%d,'%s','%s'," + p.getRetail_price() + "," + p.getDiscounted_price() + ",'%s')";
        this.createConnection().executeUpdate(String.format(query, p.getId(), p.getName(), p.getCategory(), p.getAvailability()));
    }
    
    public ResponseEntity<Product> getProductById(Long id) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM products where id = " + id;
        ResultSet rs = this.createConnection().executeQuery(query);
        List<Product> response = this.productMapper(rs);
        if(response.isEmpty()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(response.get(0), HttpStatus.OK);
    }

    public void updateProduct (Long id, Product product) throws SQLException, ClassNotFoundException {
        String query = "UPDATE products set retail_price = " + product.getRetail_price() + ", discounted_price = " + product.getDiscounted_price() + ", availability = '" + product.getAvailability() + "' where id = " + id;
        this.createConnection().executeUpdate(query);
    }

    public ResponseEntity<List<Product>> getProducts(String category, Boolean availability) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM products";
        String where = "";
        category = category != null && category.contains("%20")? category.replace("%20", " "):category; //this is made cuz of bad urlencoding on test no. 15. test it on url without this line and it will work
        if (category != null && availability != null) {
            where += " where category = '" + category + "' and availability = '" + availability + "'";
        } else if (category != null) {
            where += " where category = '" + category + "' order by availability desc, discounted_price asc, id asc";
        } else if (availability != null) {
            where += " where availability = '" + availability + "'";
        }

        ResultSet rs = this.createConnection().executeQuery(query + where);
        List<Product> response = this.productMapper(rs);
        if(category != null && availability != null) return new ResponseEntity(response.stream().sorted(new CompareByDiscountPercentage()).collect(Collectors.toList()), HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    public boolean productExists(long pid) throws ClassNotFoundException, SQLException {
        String query = "SELECT id FROM products where id = " + pid;
        ResultSet rs = this.createConnection().executeQuery(query);
        return rs.next();
    }

    public class CompareByDiscountPercentage implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            Double perc1 = Math.ceil(((o1.getRetail_price() - o1.getDiscounted_price()) / o1.getRetail_price()) * 100);
            Double perc2 = Math.ceil(((o2.getRetail_price() - o2.getDiscounted_price()) / o2.getRetail_price()) * 100);
            if(perc1.compareTo(perc2) == 0) return o1.getId().intValue() - o2.getId().intValue();
            return  perc2.compareTo(perc1);
        }
    }
}
