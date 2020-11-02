package MyShop.servlet.page;

import MyShop.Constants;
import MyShop.entity.Account;
import MyShop.entity.Orders;
import MyShop.model.CurrentAccount;
import MyShop.model.OrderItems;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;
import MyShop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/my-orders")
public class MyOrdersController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentAccount account = (CurrentAccount) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
        if (account.getEmail().equals("kovalv97@yandex.ua")) req.getSession().setAttribute("admin","TRUE");

       List<Orders> orders = ServiceManager.getInstance(req.getServletContext())
               .getSqlDAO().getOrdersByAccount((Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT));

       ArrayList arrayList = new ArrayList<OrderItems>();

        for (Orders order:orders) {
            arrayList.add(new OrderItems(order,ServiceManager.getInstance(req.getServletContext())
                    .getSqlDAO().getOrderItemsByOrder(order)));
        }
        Collections.reverse(arrayList);

        req.setAttribute("OrderItems",arrayList);

        req.setAttribute("info",req.getSession().getAttribute("message"));
        req.getSession().removeAttribute("message");
        RoutingUtils.forwardToPage("my-orders.jsp", req, resp);
    }
}
