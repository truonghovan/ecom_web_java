package com.website.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.Cons.Message;
import com.website.models.UserEntity;
import com.website.service.UserService;
import com.website.utils.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/api-user-change-Inf","/api-user-change-password"})
public class UserAPI extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session =req.getSession();
        UserEntity userOld = (UserEntity) session.getAttribute("user");
        UserEntity user = userService.findById(userOld.getId());//Cũ

        String fullname = req.getParameter("fullname");
        String email =req.getParameter("email");
        String address = req.getParameter("address");
        String phonenumber = req.getParameter("phoneNumber");

        if (fullname.equals(user.getFullname()) && email.equals(user.getEmail()) && address.equals(user.getAddress()) && phonenumber.equals(user.getPhone_number())) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/checkout.jsp");
            rd.forward(req,resp);
            return;
        }

        UserEntity oldAccount = user;

        oldAccount.setFullname(fullname);
        oldAccount.setEmail(email);
        oldAccount.setAddress(address);
        oldAccount.setPhone_number(phonenumber);

        boolean check = false;
        Message.reset();

        if(oldAccount.getFullname().equals(""))
        {

            Message.errFullName="Vui long nhap tên đầy đủ !";
            check = true;
        }
        if(oldAccount.getEmail().equals(""))
        {
            Message.errEmail = "Vui long nhap Email !";
            check = true;
        }
        if(oldAccount.getPhone_number().equals(""))
        {
            Message.errPhone = "Vui long nhap SDT";
            check = true;
        }

        if(user.getAddress().equals(""))
        {
            Message.errAddress = "Vui long nhap dia chi!";
            check = true;
        }
        if(check == true)
        {
            req.setAttribute("errFullName",Message.errFullName);
            req.setAttribute("errEmail",Message.errEmail);
            req.setAttribute("errPhone",Message.errPhone);
            req.setAttribute("errAddress",Message.errAddress);
            req.setAttribute("user",oldAccount);
            req.setAttribute("success","");
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/checkout.jsp");
            rd.forward(req,resp);
        }
        else
        {
            UserEntity newAccount= userService.update(oldAccount);
            req.setAttribute("user",newAccount);
            req.setAttribute("success","Thay đổi thông tin thành công");
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/checkout.jsp");
            rd.forward(req,resp);

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session =req.getSession();
        UserEntity userOld = (UserEntity) session.getAttribute("user");
        if (userOld == null) {
            RequestDispatcher rd =req.getRequestDispatcher("views/web/index.jsp");
            rd.forward(req,resp);
        } else {
            UserEntity accountModel = userService.findById(userOld.getId());
            String data = HttpUtil.of(req.getReader()).getValue();
            String [] arr =data.split("\"");

            if (!accountModel.getPassWord().equals(arr[3])) {
                return;
                //sai mk
            } else {
                accountModel.setPassWord(arr[7]);
                userService.update(accountModel);
                // đổi mk thành côcng
                mapper.writeValue(resp.getOutputStream(),"Success");
            }

        }

    }
}
