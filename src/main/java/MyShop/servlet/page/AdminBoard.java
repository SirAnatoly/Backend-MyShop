package MyShop.servlet.page;

import MyShop.Constants;
import MyShop.dao.SQLDAO;
import MyShop.entity.Account;
import MyShop.entity.Orders;
import MyShop.entity.Product;
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
import java.util.List;

@WebServlet("/admin")
public class AdminBoard extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CurrentAccount account = (CurrentAccount) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);

        if (account ==null || !account.getEmail().equals("kovalv97@yandex.ua")) {
            resp.sendRedirect("/accessError");
        }else {
            SQLDAO sqldao = ServiceManager.getInstance(req.getServletContext())
                    .getSqlDAO();

            List<Product> products = sqldao.getListAllProducts();

            req.setAttribute("Products", products);

            long countOfProducts = sqldao.countOfProducts();

            req.setAttribute("CountOfProducts", countOfProducts);

            long countOfAccounts = sqldao.countOfUsers();

            req.setAttribute("CountOfAccounts", countOfAccounts);


            req.getRequestDispatcher("/WEB-INF/JSP/admin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SQLDAO sqldao =ServiceManager.getInstance(req.getServletContext())
                .getSqlDAO();

      long productId = Long.parseLong(req.getParameter("product"));

      sqldao.removeProduct(productId);

      req.setAttribute("success" , "TRUE");

      doGet(req,resp);

    }
}
