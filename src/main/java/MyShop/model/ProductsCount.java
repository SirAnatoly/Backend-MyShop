package MyShop.model;

import MyShop.entity.Product;

public class ProductsCount {

    private Product product;

    private int count;

    public ProductsCount(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
