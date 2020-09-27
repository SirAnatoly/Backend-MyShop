package MyShop.servlet.page;

import MyShop.servlet.AbstractController;
import MyShop.util.RoutingUtils;
import MyShop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInController extends AbstractController {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (SessionUtils.isCurrentAccountCreated(req)) {
            RoutingUtils.redirect("/my-orders", req, resp);
        } else {
            RoutingUtils.forwardToPage("/products.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (SessionUtils.isCurrentAccountCreated(req)) {
            RoutingUtils.redirect("/my-orders", req, resp);
        } else {
            RoutingUtils.redirect(getSocialService().getAuthorizeUrl(), req, resp);

        }
    }

}
