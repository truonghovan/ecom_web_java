package com.website.models;

import javax.persistence.*;

@Entity
@Table(name = "Product_Cart")
public class Product_Cart_Entity {

    @EmbeddedId
    Product_Cart_Key id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name= "unit_price")
    private Integer unitPrice;

    @ManyToOne
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id")
    private CartEntity cartEntity;

    @ManyToOne
    @MapsId("pro_id")
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public Product_Cart_Entity() {
    }

    public Product_Cart_Key getId() {
        return id;
    }

    public void setId(Product_Cart_Key id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public CartEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
