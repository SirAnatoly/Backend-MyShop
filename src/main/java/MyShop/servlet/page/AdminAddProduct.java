package MyShop.servlet.page;

import MyShop.dao.SQLDAO;
import MyShop.entity.Category;
import MyShop.entity.Product;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addProduct")
public class AdminAddProduct extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SQLDAO sqldao = ServiceManager.getInstance(req.getServletContext())
                .getSqlDAO();
        List categoryList = sqldao.listAllCategories();
        req.setAttribute("Categories", categoryList);

        List producerList = sqldao.listAllProducers();
        req.setAttribute("Producers", producerList);

        req.getRequestDispatcher("/WEB-INF/JSP/addProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SQLDAO sqldao = ServiceManager.getInstance(req.getServletContext())
                .getSqlDAO();

        Product product = new Product(
                req.getParameter("name"),
                req.getParameter("desc"),
                req.getParameter("url"),
                Double.parseDouble(req.getParameter("price")),
                sqldao.categoryById(Integer.parseInt(req.getParameter("category"))),
                sqldao.producerById(Integer.parseInt(req.getParameter("producer"))));


        sqldao.createProduct(product);

        req.setAttribute("success" , "TRUE");

        doGet(req,resp);

    }

}
