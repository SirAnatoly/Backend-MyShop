package MyShop.filter;

import MyShop.Constants;
import MyShop.dao.SQLDAO;
import MyShop.service.ProductService;
import MyShop.service.impl.ServiceManager;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="CategoryProducerFilter")
public class CategoryProducerFilter extends AbstractFilter {

    private SQLDAO sqldao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sqldao =  ServiceManager.getInstance(filterConfig.getServletContext()).getSqlDAO();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute(Constants.CATEGORY_LIST, sqldao.listAllCategories());
        request.setAttribute(Constants.PRODUCER_LIST, sqldao.listAllProducers());
        chain.doFilter(request, response);
    }
}
