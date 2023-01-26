package io.red.cleanarchgpt.infra;

import io.red.cleanarchgpt.core.entities.Cart;
import io.red.cleanarchgpt.core.entities.Product;
import io.red.cleanarchgpt.core.gateway.ProductGateway;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class H2DatabaseGateway implements ProductGateway {
    private final JdbcTemplate jdbcTemplate;

    public H2DatabaseGateway(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product findById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?",
                new Object[] { id }, (rs, rowNum) ->
                {
                    return new Product(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getDouble("price"));
                });
    }

    public void saveCart(Cart cart){
        jdbcTemplate.update("INSERT INTO cart (user_id) VALUES (?)", cart.getUserId());
        for(Product item: cart.getItems()){
            jdbcTemplate.update("INSERT INTO cart_items (cart_id, product_id) VALUES (?, ?)",
                    cart.getId());
        }
    }
}
