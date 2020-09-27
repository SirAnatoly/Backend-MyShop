package MyShop.service.impl;

import MyShop.dao.SQLDAO;
import MyShop.service.OrderService;
import MyShop.service.ProductService;
import MyShop.service.SocialService;
import MyShop.util.HibernateUtil;
import org.hibernate.SessionFactory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;


public class ServiceManager {
	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute("SERVICE_MANAGER", instance);
		}
		return instance;
	}
	public ProductService getProductService() {
		return productService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public String getApplicationProperty(String key) {
		return applicationProperties.getProperty(key);
	}
	public void close() {
		
	}

	private final SQLDAO sqlDAO;
	private final SessionFactory sessionFactory;
	private final Properties applicationProperties = new Properties();
	private final ProductService productService;
	private final OrderService orderService;
	private final SocialService socialService;

	public SQLDAO getSqlDAO() { return sqlDAO; }
	public SessionFactory getSessionFactory() { return sessionFactory; }

	private ServiceManager(ServletContext context) {
		loadApplicationProperties();
		productService = new ProductServiceImpl();
		orderService = new OrderServiceImpl();
		sessionFactory= HibernateUtil.getSessionFactory();
		sqlDAO = new SQLDAO(sessionFactory.openSession());
		socialService = new FacebookSocialService(this);
	}

	public SocialService getSocialService() {
		return socialService;
	}

	private void loadApplicationProperties(){
		try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
			applicationProperties.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
