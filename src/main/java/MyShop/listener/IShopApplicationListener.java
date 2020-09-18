package MyShop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import MyShop.service.impl.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@WebListener
public class IShopApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(IShopApplicationListener.class);
	private ServiceManager serviceManager;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			serviceManager = ServiceManager.getInstance(sce.getServletContext());
		} catch (RuntimeException e) {
			LOGGER.error("Web application 'MyShop' init failed: "+e.getMessage(), e);
			throw e;
		}
		LOGGER.info("Web application 'MyShop' initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		serviceManager.close();
		LOGGER.info("Web application 'MyShop' destroyed");
	}
}
