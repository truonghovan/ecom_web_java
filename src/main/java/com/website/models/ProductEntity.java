package com.website.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String proName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private Integer price;

    @Column(name = "describe_product")
    private String describePro;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private int status;

/*    @Column(name = "detail_cate_id")
    private int detailCateId;*/

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productEntity")
    private List<CommentEntity> commentEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<Product_GoodReceived_Entity> productGoodReceivedEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<Product_Cart_Entity> productCartEntityList;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "detail_cate_id")
    private DetailCategoryEntity detailCategoryEntity;



    public ProductEntity() {
        this.setStatus(1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescribePro() {
        return describePro;
    }

    public void setDescribePro(String describePro) {
        this.describePro = describePro;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public List<Product_GoodReceived_Entity> getProductGoodReceivedEntityList() {
        return productGoodReceivedEntityList;
    }

    public void setProductGoodReceivedEntityList(List<Product_GoodReceived_Entity> productGoodReceivedEntityList) {
        this.productGoodReceivedEntityList = productGoodReceivedEntityList;
    }

    public List<Product_Cart_Entity> getProductCartEntityList() {
        return productCartEntityList;
    }

    public void setProductCartEntityList(List<Product_Cart_Entity> productCartEntityList) {
        this.productCartEntityList = productCartEntityList;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    public DetailCategoryEntity getDetailCategoryEntity() {
        return detailCategoryEntity;
    }

    public void setDetailCategoryEntity(DetailCategoryEntity detailCategoryEntity) {
        this.detailCategoryEntity = detailCategoryEntity;
    }
}
