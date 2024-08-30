package org.example.Stream;


import java.util.Set;

public class Product {

    private Long id;

    private String name;
    private String category;

    public Product(String category, Double price, Long id, String name, Set<Order> orders) {
        this.category = category;
        this.price = price;
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    public String getCategory() {
        return category;
    }

    public Product(Long id, String name, String category, Double price, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.orders = orders;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", orders=" + orders +
                '}';
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;

    private Set<Order> orders;
}