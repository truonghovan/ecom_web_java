//package com.website.test;
//
//import com.website.dao.DetailCategoryDAO;
//import com.website.dao.UserDAO;
//import com.website.models.DetailCategoryEntity;
//import com.website.models.UserEntity;
//import org.testng.annotations.Test;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class UserTest  {
//    @Test
//    public void checkFindAll() {
//        UserDAO userDAO = new UserDAO();
//        List<UserEntity> list = userDAO.findAll();
//    }
//
//    @Test
//    public void checkUpdate() {
//        UserDAO userDAO = new UserDAO();
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId( 1);
//        userEntity.setFullname("Nghia");
//        UserEntity newEntity=  userDAO.update(userEntity);
//
//    }
//
//    @Test
//    public void checkSave() {
//        UserDAO userDAO = new UserDAO();
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(23);
//        userEntity.setFullname("NghiaBui");
//        userEntity.setEmail("FF");
//        userEntity.setPhone_number("11");
//        userEntity.setPassWord("11");
//        userEntity.setRole("1");
//
//        userDAO.save(userEntity);
//
//    }
//
//    @Test
//    public void checkFindById() {
//        UserDAO userDAO = new UserDAO();
//
//        UserEntity u = userDAO.findById(1);
//
//    }
//
//    @Test
//    public void checkFindByByProperty() {
//        UserDAO userDAO = new UserDAO();
//        String property ="fullName";
//        Object value = "NghiaBui12";
//        String sortExpression ="id";
//        String sortDirection ="DESC";  //ASC|DESC
//        Object[] objects = userDAO.findByProperty(property,value,sortExpression,sortDirection);
//
//    }
//
//    @Test
//    public void checkFindAllDetailCategory() {
//        DetailCategoryDAO detailCategoryDAO = new DetailCategoryDAO();
//        List<DetailCategoryEntity> lst = detailCategoryDAO.findAll();
//
//    }
//}
