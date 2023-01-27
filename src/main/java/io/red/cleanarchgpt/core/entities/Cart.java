package io.red.cleanarchgpt.core.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fkcart_product_id")
    private List<Product> items;

    public Cart() {
    }

//    public Cart(Long userId){
//        this.userId = userId;
//        this.items = new ArrayList<>();
//    }

    public Cart(Long id, Long userId, List<Product> items) {
        this.id = id;
        this.userId = userId;
        this.items = items;
    }

    public Cart(Long userId, List<Product> items) {
        this.userId = userId;
        this.items = items;
    }

    public void addItem(Product product){
        items.add(product);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Product> getItems() {
        return items;
    }
}
