package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="ITEMS")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    private void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        value = BigDecimal.valueOf((long)quantity).multiply(price);
    }

    public Item() {
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name="ITEM_ID",unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    @NotNull
    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    @Column(name="QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NotNull
    @Column(name="VALUE")
    public BigDecimal getValue() {
        return value;
    }


    private void setValue(BigDecimal value) {
        this.value = value;
    }
}
