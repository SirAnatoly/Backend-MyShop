package MyShop.dao;

import MyShop.entity.Category;
import MyShop.entity.Producer;
import MyShop.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SQLDAO {

    private Session session ;

    public SQLDAO(Session session) {
        this.session = session;
    }

    public List<Product> listAllProducts(int fromId, int limit) {

        Query q = session.createQuery("FROM Product ");
        q.setFirstResult(fromId);
        q.setMaxResults(12);

        List results = q.list();

        return results;
    }

    public long countOfProducts (){
        Query q = session.createQuery("FROM Product ");
      return q.getResultList().size();

    }

    public List<Product> listProductsByCategory(String categoryUrl, int page, int limit) {
        // TODO Auto-generated method stub
        return null;
    }


    public List<Category> listAllCategories() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<Producer> listAllProducers() {
        // TODO Auto-generated method stub
        return null;
    }


}
