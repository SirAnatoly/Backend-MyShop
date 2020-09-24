package MyShop.filter;

import MyShop.Constants;
import MyShop.model.ShoppingCart;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName="AutoRestoreShoppingCartFilter")

public class AutoRestoreShoppingCartFilter extends AbstractFilter {



	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		if(req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART)==null) {
			req.getSession().setAttribute(Constants.CURRENT_SHOPPING_CART, new ShoppingCart());
		}
		chain.doFilter(req, resp);
	}



	

}
