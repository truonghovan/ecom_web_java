package com.website.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Product_GoodReceived_Key implements Serializable {

    @Column(name = "goodsreceived_id")
    private Integer goodsreceived_id;

    @Column(name = "pro_id")
    private Integer pro_id;

    public Product_GoodReceived_Key() {
    }

    public Product_GoodReceived_Key(Integer goodsreceived_id, Integer pro_id) {
        this.goodsreceived_id = goodsreceived_id;
        this.pro_id = pro_id;
    }

    public Integer getGoodsreceived_id() {
        return goodsreceived_id;
    }

    public void setGoodsreceived_id(Integer goodsreceived_id) {
        this.goodsreceived_id = goodsreceived_id;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product_GoodReceived_Key)) return false;
        Product_GoodReceived_Key that = (Product_GoodReceived_Key) o;
        return getGoodsreceived_id().equals(that.getGoodsreceived_id()) && getPro_id().equals(that.getPro_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoodsreceived_id(), getPro_id());
    }
}
