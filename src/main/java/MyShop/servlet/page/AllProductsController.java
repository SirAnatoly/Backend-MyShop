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

@WebServlet("/products")
public class AllProductsController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long countofproducts =  ServiceManager.getInstance(req.getServletContext())
				.getSqlDAO().countOfProducts();

		req.getSession().setAttribute("countOfProduct",countofproducts);

		List<Product> products =
				ServiceManager.getInstance(req.getServletContext())
						.getSqlDAO().listAllProducts(0,Constants.MAX_PRODUCTS_PER_HTML_PAGE);
		req.setAttribute("products", products);

		req.getSession().setAttribute("startID",Integer.valueOf(13));
		RoutingUtils.forwardToPage("products.jsp", req, resp);
	}
}
