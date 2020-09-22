package MyShop.dao;

import MyShop.entity.Category;
import MyShop.entity.Producer;
import MyShop.entity.Product;
import MyShop.form.SearchForm;
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
        q.setMaxResults(limit);
        List results = q.list();
        return results;

    }

    public long countOfProducts (){
        Query q = session.createQuery("FROM Product ");
      return q.getResultList().size();
    }

    public List<Product> listProductsByCategory(String categoryUrl, int fromId, int limit) {

        Query q = session.createQuery("FROM Product WHERE category.url = '" +categoryUrl +"'");
        q.setFirstResult(fromId);
        q.setMaxResults(limit);
        List results = q.list();
        return results;

    }

    public List<Category> listAllCategories() {

        Query q = session.createQuery("FROM Category ");
        List results = q.list();
        return results;
    }

    public List<Producer> listAllProducers() {
        Query q = session.createQuery("FROM Producer ");
        List results = q.list();
        return results;
    }

    public int countProductsByCategory(String categoryUrl) {
        Query q = session.createQuery("FROM Product WHERE category.url = '" +categoryUrl +"'");
        return q.getResultList().size();
    }

    public List<Product> listProductsBySearchForm(SearchForm searchForm, int start, int limit) {

        StringBuilder sb = new StringBuilder("FROM Product WHERE ");
        boolean needAnd = false;

        if (searchForm.getQuery().length()>=1){
            sb.append("name like '" + searchForm.getQuery() + "%' ");
            needAnd = true;
        }

        if (searchForm.getCategories() != null) {

            if (needAnd) sb.append(" and ("); else sb.append("(");

            for (Integer i : searchForm.getCategories()) {
                sb.append(" category.id= " + i.intValue() + " or ");
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") ");
        }
        if (searchForm.getProducers() != null) {
            if (searchForm.getCategories()!=null) sb.append(" and ("); else sb.append("(");

            for (Integer i : searchForm.getProducers()) {
                sb.append("producer.id= " + i.intValue() + " or ");
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        }
        System.out.println(sb.toString());

        Query q = session.createQuery(sb.toString());
        q.setFirstResult(start);
        q.setMaxResults(limit);
        List results = q.list();
        return results;
    }

    public int countProductsBySearchForm(SearchForm searchForm) {

        StringBuilder sb = new StringBuilder("FROM Product WHERE ");

        boolean needAnd = false;

        if (searchForm.getQuery().length()>=1){
            sb.append("name like '" + searchForm.getQuery() + "%' ");
            needAnd = true;
        }

        if (searchForm.getCategories() != null) {

            if (needAnd) sb.append(" and ("); else sb.append("(");

            for (Integer i : searchForm.getCategories()) {
                sb.append(" category.id= " + i.intValue() + " or ");
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") ");
        }
        if (searchForm.getProducers() != null) {
            if (searchForm.getCategories()!=null) sb.append(" and ("); else sb.append("(");

            for (Integer i : searchForm.getProducers()) {
                sb.append("producer.id= " + i.intValue() + " or ");
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        }

        Query q = session.createQuery(sb.toString());

        return q.getResultList().size();
    }


}
