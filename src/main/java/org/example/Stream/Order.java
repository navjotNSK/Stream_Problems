package org.example.Stream;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private Long id;

    public Order(Long id, LocalDate deliveryDate, LocalDate orderDate, String status, Customer customer, Set<Product> products) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.status = status;
        this.customer = customer;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }

    public Order(Long id, LocalDate orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }

    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;


    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    //    @Builder.Default
    Set<Product> products;

    public Set<Product> getProducts() {
        if (products ==null) {
            products = new HashSet<>();
        }
        return products;
    }
}