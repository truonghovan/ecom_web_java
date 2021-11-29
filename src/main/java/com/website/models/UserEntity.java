package com.website.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name ="password")
    private String passWord;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name ="username", unique = true)
    private String username;

    @Column(name ="status")
    private Integer status;

    @Column(name = "address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
    private List<GoodsReceivedEntity> goodsReceivedEntityList ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity") //mappedBy có giá trị trùng với biến khai báo ở lớp comment
    private List<CommentEntity> commentEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipperEntity")
    private List<CartEntity> cartEntity_shipperList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeEntity")
    private List<CartEntity> cartEntity_employeeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientEntity")
    private List<CartEntity> cartEntity_clientList;

    public UserEntity() {
        this.setStatus(1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public List<CartEntity> getCartEntity_shipperList() {
        return cartEntity_shipperList;
    }

    public void setCartEntity_shipperList(List<CartEntity> cartEntity_shipperList) {
        this.cartEntity_shipperList = cartEntity_shipperList;
    }

    public List<CartEntity> getCartEntity_employeeList() {
        return cartEntity_employeeList;
    }

    public void setCartEntity_employeeList(List<CartEntity> cartEntity_employeeList) {
        this.cartEntity_employeeList = cartEntity_employeeList;
    }

    public List<CartEntity> getCartEntity_clientList() {
        return cartEntity_clientList;
    }

    public void setCartEntity_clientList(List<CartEntity> cartEntity_clientList) {
        this.cartEntity_clientList = cartEntity_clientList;
    }

}
