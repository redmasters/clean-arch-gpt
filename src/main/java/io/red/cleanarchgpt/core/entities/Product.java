package io.red.cleanarchgpt.core.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id

    private final Long id;
    @Column
    private final String name;
    @Column
    private final double price;

    public Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
