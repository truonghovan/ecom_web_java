package com.website.models;

import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "GoodsReceived")
public class GoodsReceivedEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_goods_received")
    private Date date_Goods_Received;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total_price")
    private Integer total_price;

    @Column(name = "hoanthanh")
    private Integer hoanthanh;

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplierEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goodsReceivedEntity")
    private List<Product_GoodReceived_Entity> productGoodReceivedEntityList;

    public Integer getHoanthanh() {
        return hoanthanh;
    }

    public void setHoanthanh(Integer hoanthanh) {
        this.hoanthanh = hoanthanh;
    }

    public GoodsReceivedEntity() {
        this.setStatus(1);
        this.setHoanthanh(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_Goods_Received() {
        return date_Goods_Received;
    }

    public void setDate_Goods_Received(Date date_Goods_Received) {
        this.date_Goods_Received = date_Goods_Received;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
    }

    public List<Product_GoodReceived_Entity> getProductGoodReceivedEntityList() {
        return productGoodReceivedEntityList;
    }

    public void setProductGoodReceivedEntityList(List<Product_GoodReceived_Entity> productGoodReceivedEntityList) {
        this.productGoodReceivedEntityList = productGoodReceivedEntityList;
    }
}
