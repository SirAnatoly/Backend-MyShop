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




@WebServlet("/ajax/html/more/products")
public class AllProductsMoreController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int start_id = Integer.parseInt(String.valueOf(req.getSession().getAttribute("startID")));
		if(Integer.parseInt(String.valueOf(req.getSession().getAttribute("countOfProduct")))>start_id)
		{
			List<Product> products =
					ServiceManager.getInstance(req.getServletContext())
							.getSqlDAO().listAllProducts(start_id, Constants.MAX_PRODUCTS_PER_HTML_PAGE);
			req.getSession().setAttribute("products", products);
			req.getSession().setAttribute("startID",start_id + 12 );
			RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
		}

	}
}
