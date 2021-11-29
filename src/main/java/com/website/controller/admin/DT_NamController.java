package com.website.controller.admin;

import com.google.gson.Gson;
import com.website.models.CartEntity;
import com.website.models.view.DT_NamView;
import com.website.models.view.DT_ThangView;
import com.website.service.CartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = {"/DT_NamController"})
public class DT_NamController extends HttpServlet {

    private CartService cartService = new CartService();
    private List<CartEntity> cartEntityList = new ArrayList<CartEntity>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        ////Lay gia trị thoi gian
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date dat = new java.sql.Date(currentDate.getTime());
        LocalDate localDate = dat.toLocalDate();
        int start_year = 0;
        int end_year = 0;

        if(request.getParameter("start") == "" && request.getParameter("end") == ""){
            start_year = 2015;
            end_year = localDate.getYear();
        } else {
            start_year = parseInt(request.getParameter("start"));
            end_year = parseInt(request.getParameter("end"));
            if (end_year < start_year){
                request.setAttribute("error_tg","Yêu cầu chọn năm kết thúc không nhỏ hơn năm bắt đầu !");
                session.setAttribute("start_year",start_year);
                session.setAttribute("end_year",end_year);
                String data_nam = null;
                session.setAttribute("data_nam",data_nam);
                request.getRequestDispatcher("views/admin/view/doanhthubanhang_nam.jsp").forward(request,response);
            }
        }

        ///Khoi tao gia tri cho tung nam
        HashMap<Integer, Integer> map_doanhthu_nam = new HashMap<Integer, Integer>();
        for (int i = start_year; i<=end_year ; i++){
            map_doanhthu_nam.put(i,0);
        }

        ///Gan doanh thu tung nam
        for (int i= start_year; i<= end_year ; i++){
            cartEntityList = cartService.findByYear(i);
            int doanhthu = 0;
            for(CartEntity cartEntity : cartEntityList){
                doanhthu += cartEntity.getTotalPrice();
            }
            map_doanhthu_nam.put(i,doanhthu);
        }

        ///Gan object tra ve jsp
        String data_nam = null;
        Gson gsonObj = new Gson();
        Map<Object,Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        for (int i= start_year; i<= end_year; i++){
            String name = "Năm" + " " + Integer.toString(i);
            map = new HashMap<Object,Object>(); map.put("label", name); map.put("y", map_doanhthu_nam.get(i)); list.add(map);
        }
        data_nam = gsonObj.toJson(list);

        session.setAttribute("data_nam",data_nam);
        session.setAttribute("start_year",start_year);
        session.setAttribute("end_year",end_year);
        request.getRequestDispatcher("views/admin/view/doanhthubanhang_nam.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        Integer start_year = (Integer) session.getAttribute("start_year");
        Integer end_year = (Integer) session.getAttribute("end_year");

        ///Khoi tao gia tri cho tung nam
        HashMap<Integer, Integer> map_doanhthu_nam = new HashMap<Integer, Integer>();
        for (int i = start_year; i<=end_year ; i++){
            map_doanhthu_nam.put(i,0);
        }

        ///Gan doanh thu tung nam
        for (int i= start_year; i<= end_year ; i++){
            cartEntityList = cartService.findByYear(i);
            int doanhthu = 0;
            for(CartEntity cartEntity : cartEntityList){
                doanhthu += cartEntity.getTotalPrice();
            }
            map_doanhthu_nam.put(i,doanhthu);
        }

        ///Gan du lieu tra ve excel
        List<DT_NamView> dt_namViews = new ArrayList<DT_NamView>();
        for (int i= start_year; i<= end_year ; i++){
            String name = /*"Năm" + " " + */Integer.toString(i);
            dt_namViews.add(new DT_NamView(name, map_doanhthu_nam.get(i)));
        }

        request.setAttribute("dt_namViews", dt_namViews);
        RequestDispatcher rd = request.getRequestDispatcher("views/admin/view/excelreport_nam.jsp");
        rd.forward(request, response);
    }
}
