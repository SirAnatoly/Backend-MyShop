package MyShop.servlet.page;

import MyShop.Constants;
import MyShop.entity.Product;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;
import MyShop.util.RoutingUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/products/*")
public class ProductsByCategoryController extends AbstractController {
	private static final int SUBSTRING_INDEX = "/products".length();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categoryUrl = req.getRequestURI().substring(SUBSTRING_INDEX);
		long countofproducts = ServiceManager.getInstance(req.getServletContext())
				.getSqlDAO().countProductsByCategory(categoryUrl);
		req.getSession().setAttribute("countOfProduct", countofproducts);
		req.getSession().setAttribute("startID", Integer.valueOf(12));
		List<Product> products = ServiceManager.getInstance(req.getServletContext())
				.getSqlDAO().listProductsByCategory(categoryUrl, 0, Constants.MAX_PRODUCTS_PER_HTML_PAGE);
		req.setAttribute("products", products);
		req.setAttribute("selectedCategoryUrl", categoryUrl);
		RoutingUtils.forwardToPage("products.jsp", req, resp);
	}
}
