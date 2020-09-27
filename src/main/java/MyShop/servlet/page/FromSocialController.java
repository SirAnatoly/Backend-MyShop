package MyShop.servlet.page;

import MyShop.listener.IShopApplicationListener;
import MyShop.model.CurrentAccount;
import MyShop.model.SocialAccount;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;
import MyShop.util.RoutingUtils;
import MyShop.util.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/from-social")
public class FromSocialController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IShopApplicationListener.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");

        if (code != null) {
            SocialAccount socialAccount = getSocialService().getSocialAccount(code);

            if (socialAccount==null)
                RoutingUtils.forwardToPage("error.jsp", req, resp);

            CurrentAccount currentAccount = ServiceManager.getInstance(req.getServletContext())
                    .getSqlDAO().authenticate(socialAccount);
            SessionUtils.setCurrentAccount(req, currentAccount);
            RoutingUtils.redirect("/my-orders", req, resp);
        } else {
            LOGGER.error("Parameter code not found");
            RoutingUtils.redirect("/sign-in", req, resp);

        }

    }

}
