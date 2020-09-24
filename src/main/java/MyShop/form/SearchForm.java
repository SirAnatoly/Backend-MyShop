package MyShop.form;

import java.util.ArrayList;
import java.util.List;

public class SearchForm {
    private String query;
    private List<Integer> categories;
    private List<Integer> producers;
    private boolean isEmpty;

    public SearchForm(String query, String[] categories, String[] producers) {
        super();
        this.query = query;
        this.categories = convert(categories);
        this.producers = convert(producers);
        if(query.length()==0 && categories==null && producers==null) isEmpty=true; else isEmpty=false;
    }
    private List<Integer> convert(String[] args) {
        if(args == null) {
            return null;
        } else {
            List<Integer> res = new ArrayList<>();
            for(String arg : args) {
                res.add(Integer.parseInt(arg));
            }
            return res;
        }
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }
    public List<Integer> getProducers() {
        return producers;
    }
    public void setProducers(List<Integer> producers) {
        this.producers = producers;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
