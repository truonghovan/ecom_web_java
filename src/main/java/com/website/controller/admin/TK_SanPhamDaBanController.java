package com.website.controller.admin;

import com.website.models.ProductEntity;
import com.website.models.Product_Cart_Entity;
import com.website.service.CartItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@WebServlet(urlPatterns = {"/TK_SanPhamDaBanController"})
public class TK_SanPhamDaBanController extends HttpServlet {

    private CartItemService cartItemService = new CartItemService();
    private List<Product_Cart_Entity> productCartEntityList = new ArrayList<Product_Cart_Entity>();

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

        ///Khoi tao gia tri ban dau
        HashMap<ProductEntity, Integer> map = new HashMap<>();
        int year = 0;
        int month = 0;

        if(request.getParameter("type") == "")
        {
            request.getRequestDispatcher("views/admin/view/tk_sanphamdaban.jsp").forward(request,response);
        }
        else if (request.getParameter("type").equals("nam"))
        {
            if(request.getParameter("nam").equals("0"))
            {
                year = localDate.getYear();
            }
            else
                {
                year = Integer.parseInt(request.getParameter("nam"));
            }

            ///Tim danh sach san pham ban duoc theo nam
            productCartEntityList  = cartItemService.find_cart_pro(year);

            ///Gan so luong san pham va gia tri ban duoc ban duoc tung nam
            for(int i=0; i<productCartEntityList.size(); i++){
                Product_Cart_Entity item = productCartEntityList.get(i);
                if(map.containsKey(item.getProductEntity())){
                    map.put(item.getProductEntity(), map.get(item.getProductEntity()) + item.getQuantity() * item.getProductEntity().getPrice() );
                } else {
                    map.put(item.getProductEntity(), item.getQuantity() * item.getProductEntity().getPrice());
                }
            }

            // Khởi tạo ra một Set entries
            Set<Map.Entry<ProductEntity, Integer>> entries = map.entrySet();

            // Tạo custom So sánh
            Comparator<Map.Entry<ProductEntity, Integer>> comparator = new Comparator<Map.Entry<ProductEntity, Integer>>() {
                @Override
                public int compare(Map.Entry<ProductEntity, Integer> e1, Map.Entry<ProductEntity, Integer> e2) {
                    Integer v1 = e1.getValue();
                    Integer v2 = e2.getValue();
                    return v1.compareTo(v2);
                }
            };

            // Convert Set thành List
            List<Map.Entry<ProductEntity, Integer>> list_pro = new ArrayList<>(entries);

            // Sắp xếp List tang dan
            Collections.sort(list_pro, comparator);

            try{
                if(request.getParameter("sort").equals("giamdan")){
                    Collections.reverse(list_pro);
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                session.setAttribute("data_year",list_pro);
                session.setAttribute("tk_year",year);
                request.getRequestDispatcher("views/admin/view/tk_sanphamdaban_nam.jsp").forward(request,response);
            }
        }
        else if(request.getParameter("type").equals("thang")){
            if(request.getParameter("thang").equals("0") && request.getParameter("nam").equals("0"))
            {
                month = localDate.getMonthValue();
                year = localDate.getYear();
            } else {
                year = Integer.parseInt(request.getParameter("nam"));
                month = Integer.parseInt(request.getParameter("thang"));
            }

            ///Tim danh sach san pham ban duoc theo nam va thang
            productCartEntityList  = cartItemService.find_cart_pro_month_year(year,month);

            ///Gan so luong san pham va gia tri ban duoc ban duoc tung thang
            for(int i=0; i<productCartEntityList.size(); i++){
                Product_Cart_Entity item = productCartEntityList.get(i);
                if(map.containsKey(item.getProductEntity())){
                    map.put(item.getProductEntity(), map.get(item.getProductEntity()) + item.getQuantity() * item.getProductEntity().getPrice() );
                } else {
                    map.put(item.getProductEntity(), item.getQuantity() * item.getProductEntity().getPrice());
                }
            }
            // Khởi tạo ra một Set entries
            Set<Map.Entry<ProductEntity, Integer>> entries = map.entrySet();

            // Tạo custom So sánh
            Comparator<Map.Entry<ProductEntity, Integer>> comparator = new Comparator<Map.Entry<ProductEntity, Integer>>() {
                @Override
                public int compare(Map.Entry<ProductEntity, Integer> e1, Map.Entry<ProductEntity, Integer> e2) {
                    Integer v1 = e1.getValue();
                    Integer v2 = e2.getValue();
                    return v1.compareTo(v2);
                }
            };

            // Convert Set thành List
            List<Map.Entry<ProductEntity, Integer>> list_pro = new ArrayList<>(entries);

            // Sắp xếp List tang dan
            Collections.sort(list_pro, comparator);

            try{
                if(request.getParameter("sort").equals("giamdan")){
                    Collections.reverse(list_pro);
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                session.setAttribute("data_month",list_pro);
                session.setAttribute("tk_year2",year);
                session.setAttribute("tk_motnh",month);
                request.getRequestDispatcher("views/admin/view/tk_sanphamdaban_thang.jsp").forward(request,response);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(request.getParameter("action").equals("excel_thang")){
            RequestDispatcher rd = request.getRequestDispatcher("views/admin/view/excel_sanphamthang.jsp");
            rd.forward(request, response);
        }
        else if(request.getParameter("action").equals("excel_nam")){
            RequestDispatcher rd = request.getRequestDispatcher("views/admin/view/excel_sanphamthang.jsp");
            rd.forward(request, response);
        }

    }
}
