package MyShop.servlet.ajax;

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




@WebServlet("/ajax/html/more/products/*")
public class ProductsByCategoryMoreController extends AbstractController {
	private static final int SUBSTRING_INDEX = "/ajax/html/more/products".length();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String categoryUrl = req.getRequestURI().substring(SUBSTRING_INDEX);

		int start_id = Integer.parseInt(String.valueOf(req.getSession().getAttribute("startID")));

		int countof_products = Integer.parseInt(String.valueOf(req.getSession()
				.getAttribute("countOfProduct")));

		if (start_id < countof_products) {
				List<Product> products = ServiceManager.getInstance(req.getServletContext())
						.getSqlDAO().listProductsByCategory(categoryUrl, start_id, Constants.MAX_PRODUCTS_PER_HTML_PAGE);

				req.setAttribute("products", products);

				req.getSession().setAttribute("startID", start_id + 12);

				req.getSession().setAttribute("countOfProduct", countof_products - 12);

				RoutingUtils.forwardToFragment("product-list.jsp", req, resp);

		}
	}
}
