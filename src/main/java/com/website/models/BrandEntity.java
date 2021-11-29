package com.website.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Brand")
public class BrandEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private Integer status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandEntity")
    private List<ProductEntity> productEntityList ;

    public BrandEntity() {
        this.status=1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    public BrandEntity(Integer id, String brandName, String image, Integer status, List<ProductEntity> productEntityList) {
        this.id = id;
        this.brandName = brandName;
        this.image = image;
        this.status = status;
        this.productEntityList = productEntityList;
    }

}
