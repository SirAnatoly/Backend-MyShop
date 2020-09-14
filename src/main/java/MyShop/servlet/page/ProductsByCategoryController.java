package MyShop.servlet.page;

import MyShop.servlet.AbstractController;
import MyShop.util.RoutingUtils;

import java.io.IOException;

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
		RoutingUtils.forwardToPage("products.jsp", req, resp);
	}
}
