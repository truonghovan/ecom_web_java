package com.website.controller.admin;

import com.google.gson.Gson;
import com.website.models.CartEntity;
import com.website.models.UserEntity;
import com.website.models.view.DT_ThangView;
import com.website.service.CartService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = {"/DT_ThangController"})
public class DT_ThangController extends HttpServlet {

    private CartService cartService = new CartService();
    private List<CartEntity> cartEntityList = new ArrayList<CartEntity>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int year = 0;

        ////Khoi tao gia tri theo thang va nam
        int value_t1 = 0;
        int value_t2 = 0;
        int value_t3 = 0;
        int value_t4 = 0;
        int value_t5 = 0;
        int value_t6 = 0;
        int value_t7 = 0;
        int value_t8 = 0;
        int value_t9 = 0;
        int value_t10 = 0;
        int value_t11 = 0;
        int value_t12 = 0;

        ////Lay gia trị thoi gian
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date dat = new java.sql.Date(currentDate.getTime());
        LocalDate localDate = dat.toLocalDate();

        if(request.getParameter("n") == ""){
            year = localDate.getYear();
            ///Danh sach don hang da nhan theo nam va tinh gia tri tung thang
            cartEntityList = cartService.findByYear(year);

        } else {
            year = parseInt(request.getParameter("n"));
            ///Danh sach don hang da nhan theo nam va tinh gia tri tung thang
            cartEntityList = cartService.findByYear(year);
        }

        ///Danh sach don hang da nhan theo nam va tinh gia tri tung thang
        /*List<CartEntity> cartEntityList = cartService.findByYear(localDate.getYear());*/
        for(CartEntity cartEntity : cartEntityList){
            localDate = cartEntity.getBuyDate().toLocalDate();
            switch (localDate.getMonthValue()){
                case 1:
                    value_t1 += cartEntity.getTotalPrice();
                    break;
                case 2:
                    value_t2 += cartEntity.getTotalPrice();
                    break;
                case 3:
                    value_t3 += cartEntity.getTotalPrice();
                    break;
                case 4:
                    value_t4 += cartEntity.getTotalPrice();
                    break;
                case 5:
                    value_t5 += cartEntity.getTotalPrice();
                    break;
                case 6:
                    value_t6 += cartEntity.getTotalPrice();
                    break;
                case 7:
                    value_t7 += cartEntity.getTotalPrice();
                    break;
                case 8:
                    value_t8 += cartEntity.getTotalPrice();
                    break;
                case 9:
                    value_t9 += cartEntity.getTotalPrice();
                    break;
                case 10:
                    value_t10 += cartEntity.getTotalPrice();
                    break;
                case 11:
                    value_t11 += cartEntity.getTotalPrice();
                    break;
                case 12:
                    value_t12 += cartEntity.getTotalPrice();
                    break;
            }
        }

        ////Dat du lieu
        String dataPoints = null;
        Gson gsonObj = new Gson();
        Map<Object,Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        map = new HashMap<Object,Object>(); map.put("label", "T1"); map.put("y", value_t1); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T2"); map.put("y", value_t2); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T3"); map.put("y", value_t3); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T4"); map.put("y", value_t4); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T5"); map.put("y", value_t5); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T6"); map.put("y", value_t6); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T7"); map.put("y", value_t7); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T8"); map.put("y", value_t8); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T9"); map.put("y", value_t9); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T10"); map.put("y", value_t10); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T11"); map.put("y", value_t11); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "T12"); map.put("y", value_t12); list.add(map);
        dataPoints = gsonObj.toJson(list);

        ///Gan du lieu va tra ve
        session.setAttribute("dataPoints",dataPoints);
        session.setAttribute("year",year);
/*        request.setAttribute("year",year);*/
        request.getRequestDispatcher("views/admin/view/doanhthubanhang.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Integer year = (Integer) session.getAttribute("year");
        cartEntityList = cartService.findByYear(year);


        ///Gan list khoi tao gia tri tung thang
        HashMap<Integer, Integer> map_doanhthu = new HashMap<Integer, Integer>();
        for (int i=1; i<13; i++){
            map_doanhthu.put(i,0);
        }


        for(CartEntity cartEntity : cartEntityList){
            LocalDate localDate = cartEntity.getBuyDate().toLocalDate();
            map_doanhthu.put(localDate.getMonthValue(), map_doanhthu.get(localDate.getMonthValue()) + cartEntity.getTotalPrice());
        }


        ///Gan du lieu tra ve excel
        List<DT_ThangView> dt_thangViews = new ArrayList<DT_ThangView>();
        String name = "";
        for(int i=1; i<13 ; i++){
            name = /*"Tháng " + " " + */Integer.toString(i);
            dt_thangViews.add(new DT_ThangView(name,map_doanhthu.get(i)));
        }
        request.setAttribute("dt_thangViews", dt_thangViews);
        RequestDispatcher rd = request.getRequestDispatcher("views/admin/view/excelreport.jsp");
        rd.forward(request, response);
    }
}
