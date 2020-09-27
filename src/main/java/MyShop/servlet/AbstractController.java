package MyShop.servlet;

import MyShop.service.OrderService;
import MyShop.service.ProductService;
import MyShop.service.SocialService;
import MyShop.service.impl.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public abstract class AbstractController extends HttpServlet {


	private ProductService productService;
	private OrderService orderService;
	private SocialService socialService;

	@Override
	public final void init() throws ServletException {
		productService = ServiceManager.getInstance(getServletContext()).getProductService();
		orderService = ServiceManager.getInstance(getServletContext()).getOrderService();
		socialService = ServiceManager.getInstance(getServletContext()).getSocialService();
	}

	public final ProductService getProductService() {
		return productService;
	}

	public final OrderService getOrderService() {
		return orderService;
	}

	public SocialService getSocialService() {
		return socialService;
	}
}
