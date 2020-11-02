package MyShop.servlet.page;

import MyShop.dao.SQLDAO;
import MyShop.entity.OrderItem;
import MyShop.entity.Orders;
import MyShop.entity.Product;
import MyShop.model.OrderItems;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/messages")
public class AdminMessages extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        SQLDAO sqldao = ServiceManager.getInstance(req.getServletContext()).getSqlDAO();

        List<Orders> orders = sqldao.getOrders();

        req.setAttribute("Orders",orders);

        ArrayList itemsArrayList = new ArrayList<OrderItems>();

        for (Orders order:orders) itemsArrayList.add(new OrderItems(order,sqldao.getOrderItemsByOrder(order)));

        req.setAttribute("OrderItems",itemsArrayList);

        req.getRequestDispatcher("/WEB-INF/JSP/message.jsp").forward(req, resp);
    }
}
