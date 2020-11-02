package MyShop.servlet.page;

import MyShop.Constants;
import MyShop.dao.SQLDAO;
import MyShop.entity.Account;
import MyShop.entity.Orders;
import MyShop.entity.Product;
import MyShop.model.CurrentAccount;
import MyShop.model.OrderItems;
import MyShop.model.ProductsCount;
import MyShop.model.ShoppingCart;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/makeOrder")
public class MakeOrder extends AbstractController {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SQLDAO dao = ServiceManager.getInstance(req.getServletContext()).getSqlDAO();

        Account account = (Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);

        ServiceManager.getInstance(req.getServletContext()).getSqlDAO().makeOrder(account);

        dao.setSession(ServiceManager.getInstance(req.getServletContext()).getSessionFactory().openSession());

        dao = ServiceManager.getInstance(req.getServletContext()).getSqlDAO();

        long lastOrder = dao.getLastOrder(account);

        Orders thisOrder = dao.getOrderById(lastOrder);


        ShoppingCart thisCart = (ShoppingCart) req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);

        for (ProductsCount product :
                thisCart.getProducts()) {
            dao.makeItemOrders(product.getProduct(), thisOrder, product.getCount());
        }

        ServiceManager.getInstance(req.getServletContext()).getSessionFactory().openSession();

        OrderItems orderItems = new OrderItems(thisOrder, dao.getOrderItemsByOrder(thisOrder));

        ServiceManager.getInstance(req.getServletContext()).getNotificationService().sendNotification("MyShop", "Mr " + account.getName() + "  buy something.  <br>  ( " + account.getEmail() + " ) ", orderItems, ServiceManager.getInstance(req.getServletContext()).getApplicationProperty("email.notificationEmail"));

        ServiceManager.getInstance(req.getServletContext()).getNotificationService().sendNotification("MyShop", "Thanks for the buying!", orderItems, account.getEmail());

        req.getSession().removeAttribute(Constants.CURRENT_SHOPPING_CART);

        req.getSession().setAttribute("message", "<div class=\"alert alert-success\" role=\"alert\">Thank you for the order!!!</div>");

        resp.sendRedirect("/my-orders");
    }
}
