package com.learn.inventory_manager.data;

import com.learn.inventory_manager.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class MySqlInventoryRepository implements InventoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAll() {
        final String sql = "SELECT * FROM Product;";
        return jdbcTemplate.query(sql, productRowMapper());
    }

    @Override
    public Product findById(String productId) {
        final String sql = "SELECT * FROM Product WHERE ProductID = ?;";
        return jdbcTemplate.queryForObject(sql, productRowMapper(), productId);
    }

    @Override
    public Product add(Product product) {
        return null;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean deleteById(String productId) {
        return false;
    }

    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setQuantity(rs.getInt("Quantity"));
            product.setPrice(rs.getBigDecimal("Price"));

            return product;
        };
    }
}
