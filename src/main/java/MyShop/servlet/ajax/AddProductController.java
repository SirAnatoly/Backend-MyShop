package MyShop.servlet.ajax;

import MyShop.Constants;
import MyShop.model.ShoppingCart;
import MyShop.service.impl.ServiceManager;
import MyShop.servlet.AbstractController;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax/json/product/add")
public class AddProductController extends AbstractController {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShoppingCart shoppingCart = (ShoppingCart)req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);


              int IdProduct = Integer.parseInt(req.getParameter("idProduct"));
              int count =  Integer.parseInt(req.getParameter("count"));

              shoppingCart.addProduct(ServiceManager.getInstance(req.getServletContext())
                      .getSqlDAO().productById(IdProduct),count);

        JSONObject r = new JSONObject();

        r.put("totalCount", shoppingCart.getTotalCount());

        r.put("totalCost", shoppingCart.getTotalCost());


        resp.setContentType("application/json");

        resp.getWriter().println(r.toString());

        resp.getWriter().close();

    }
}
