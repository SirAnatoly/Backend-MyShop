package MyShop.servlet.page;

import MyShop.Constants;
import MyShop.entity.Product;
import MyShop.form.SearchForm;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;
import MyShop.util.RoutingUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search")
public class SearchController extends AbstractController {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SearchForm searchForm =  new SearchForm( req.getParameter("query"),  req.getParameterValues("category"),
				req.getParameterValues("producer"));

		List<Product> products =
				ServiceManager.getInstance(req.getServletContext())
						.getSqlDAO().listProductsBySearchForm(searchForm,0, Constants.MAX_PRODUCTS_PER_HTML_PAGE);
		req.setAttribute("products", products);
		req.getSession().setAttribute("countOfProduct", ServiceManager.getInstance(req.getServletContext())
				.getSqlDAO().countProductsBySearchForm(searchForm));
		req.setAttribute("searchForm", searchForm);
		req.getSession().setAttribute("startID",Integer.valueOf(12));
		RoutingUtils.forwardToPage("search-result.jsp", req, resp);
	}
}
