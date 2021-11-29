package com.website.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;


@Entity
@Table(name = "Cart")
public class CartEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "status")
    private Integer status;

    //ToDo Dang lam carts

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private UserEntity shipperEntity;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private UserEntity employeeEntity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity clientEntity;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(/*fetch = FetchType.EAGER, */mappedBy = "cartEntity")
    private List<Product_Cart_Entity> productCartEntityList;

    @Column(name = "payments")
    private Integer payments;

    @Column(name = "buyDate")
    private Date buyDate;

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public CartEntity() {

        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        this.setStatus(1);
        this.setBuyDate(date);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserEntity getShipperEntity() {
        return shipperEntity;
    }

    public void setShipperEntity(UserEntity shipperEntity) {
        this.shipperEntity = shipperEntity;
    }

    public UserEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(UserEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public UserEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(UserEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<Product_Cart_Entity> getProductCartEntityList() {
        return productCartEntityList;
    }

    public void setProductCartEntityList(List<Product_Cart_Entity> productCartEntityList) {
        this.productCartEntityList = productCartEntityList;
    }

    
}
