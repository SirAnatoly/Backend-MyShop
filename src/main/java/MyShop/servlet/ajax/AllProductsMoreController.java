package MyShop.servlet.ajax;

import MyShop.servlet.AbstractController;
import MyShop.util.RoutingUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/ajax/html/more/products")
public class AllProductsMoreController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
	}
}
