package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PRODUCTS")
public class Product {
    private int id;
    private String name;
   // private List<Item> items;

    public Product() {
    }


    public Product(String name) {
        this.name = name;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name="PRODUCT_ID",unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name="PRODUCT_NAME")
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /*@OneToMany(
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY,
            targetEntity = Item.class,
            mappedBy = "product"
    )
    public List<Item> getItems() {
        return items;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }*/
}
