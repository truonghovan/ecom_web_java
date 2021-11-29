package com.website.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class CategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "catename")
    private String cateName;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private Integer status;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryEntity")
    private List<DetailCategoryEntity> detailCategoryEntityList;





    public CategoryEntity() {
        this.setStatus(1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
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

    public List<DetailCategoryEntity> getDetailCategoryEntityList() {
        return detailCategoryEntityList;
    }

    public void setDetailCategoryEntityList(List<DetailCategoryEntity> detailCategoryEntityList) {
        this.detailCategoryEntityList = detailCategoryEntityList;
    }
}
