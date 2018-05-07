package com.kodilla.good.patterns.tasks;

import java.util.Objects;

public class Product {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProductName(), product.getProductName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProductName());
    }
}
