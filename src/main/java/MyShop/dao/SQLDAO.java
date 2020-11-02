package MyShop.dao;

import MyShop.entity.*;
import MyShop.form.SearchForm;
import MyShop.model.CurrentAccount;
import MyShop.model.SocialAccount;
import MyShop.service.impl.ServiceManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.Order;
import java.math.BigDecimal;
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

    public List<Product> getListAllProducts() {

        Query q = session.createQuery("FROM Product ");
        List results = q.list();
        return results;
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

    public Product productById(int id){
        Query q = session.createQuery("FROM Product WHERE id = "+id);
        return (Product) q.getSingleResult();

    }

    public Account authenticate(SocialAccount socialAccount) {
        Account account;
        Query q = session.createQuery("FROM Account WHERE email like " + "'" + socialAccount.getEmail() + "'");
        if (q.list().size()!=0)
        account = (Account) q.getSingleResult();
        else {
            session.beginTransaction();
            session.save(new Account(socialAccount.getName(), socialAccount.getEmail()));
            session.getTransaction().commit();
            Query qw = session.createQuery("FROM Account WHERE email like " + "'" + socialAccount.getEmail() + "'");
            account = (Account) qw.getSingleResult();
        }
        return account;
    }

    public void makeOrder(Account account){
        session.beginTransaction();
        session.save(new Orders(account));
        session.getTransaction().commit();
        session.close();

    }

    public List<Orders> getOrdersByAccount(Account account){

        Query q = session.createQuery("FROM Orders where account.id = " + account.getId());
         return q.list();
    }

    public long lastOrdByAccount(Account account){
        Query qw = session.createQuery("FROM Orders WHERE account.id = "+ account.getId()+" order by account.id  ");
        Orders  order = (Orders) qw.getSingleResult();
        return order.getId();
    }

    public void makeItemOrders(Product product, Orders order, int count){
        session.beginTransaction();
        session.save(new OrderItem(product,order,count));
        session.getTransaction().commit();
    }
    public List<OrderItem> getOrderItemsByOrder(Orders order){
        Query q = session.createQuery("FROM OrderItem where order.id = " + order.getId());
        return q.list();
    }
    public long getLastOrder(CurrentAccount account){
        String hql = "SELECT MAX(id) FROM Orders WHERE account.id ="+account.getId();
        Query query = session.createQuery(hql);
        Integer integer = (Integer) query.getSingleResult();
        return integer;
    }
    public Orders getOrderById(long id){
        Query q = session.createQuery("FROM Orders WHERE id =" +id);
        return (Orders)q.getSingleResult();
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public long countOfProducts (){
        Query q = session.createQuery("FROM Product ");
        return q.getResultList().size();
    }

    public long countOfUsers(){
        Query q = session.createQuery("FROM Account ");
        return q.getResultList().size();

    }
    public List<Orders> getOrders(){

        Query q = session.createQuery("FROM Orders ");
        return q.list();
    }

    public void createProduct(Product product){
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }
    public void removeProduct(long id){
        session.beginTransaction();
        String hql = "DELETE FROM Product WHERE id = " + id;
        Query query = session.createQuery(hql);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public Category categoryById(int id){
        Query q = session.createQuery("FROM Category WHERE id = "+id);
        return (Category) q.getSingleResult();

    }
    public Producer producerById(int id){
        Query q = session.createQuery("FROM Producer WHERE id = "+id);
        return (Producer) q.getSingleResult();

    }

}
