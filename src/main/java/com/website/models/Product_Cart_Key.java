package com.website.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Product_Cart_Key implements Serializable {

    @Column(name = "pro_id")
    private Integer pro_id;

    @Column(name = "cart_id")
    private Integer cart_id;

    public Product_Cart_Key() {
    }

    public Product_Cart_Key(Integer pro_id, Integer cart_id) {
        this.pro_id = pro_id;
        this.cart_id = cart_id;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product_Cart_Key)) return false;
        Product_Cart_Key that = (Product_Cart_Key) o;
        return getPro_id().equals(that.getPro_id()) && getCart_id().equals(that.getCart_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPro_id(), getCart_id());
    }
}
