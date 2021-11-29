package com.website.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Supplier")
public class SupplierEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_supplier")
    private String nameSupplier;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private Integer status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplierEntity")
    private List<GoodsReceivedEntity> goodsReceivedEntityList;

    public SupplierEntity() {
        this.setStatus(1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<GoodsReceivedEntity> getGoodsReceivedEntityList() {
        return goodsReceivedEntityList;
    }

    public void setGoodsReceivedEntityList(List<GoodsReceivedEntity> goodsReceivedEntityList) {
        this.goodsReceivedEntityList = goodsReceivedEntityList;
    }
}
