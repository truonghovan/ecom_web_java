package com.website.models;

import javax.persistence.*;

@Entity
@Table(name = "Product_GoodReceived")
public class Product_GoodReceived_Entity {

    @EmbeddedId
    Product_GoodReceived_Key id;

    @Column(name = "status")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @MapsId("goodsreceived_id")
    @JoinColumn(name = "goodsreceived_id")
    private GoodsReceivedEntity goodsReceivedEntity;

    @ManyToOne
    @MapsId("pro_id")
    @JoinColumn(name = "pro_id")
    private ProductEntity productEntity;

    public Product_GoodReceived_Entity() {
        this.status = 1;
    }

    public Product_GoodReceived_Key getId() {
        return id;
    }

    public void setId(Product_GoodReceived_Key id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public GoodsReceivedEntity getGoodsReceivedEntity() {
        return goodsReceivedEntity;
    }

    public void setGoodsReceivedEntity(GoodsReceivedEntity goodsReceivedEntity) {
        this.goodsReceivedEntity = goodsReceivedEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
