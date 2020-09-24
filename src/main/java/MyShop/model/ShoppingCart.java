package MyShop.model;

import MyShop.Constants;
import MyShop.entity.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart implements Serializable {

	private ProductsCount productArr[];
	private int iterator;
	private BigDecimal price;
	private int countOfProducts;


	public ShoppingCart() {
		this.productArr =  new ProductsCount[Constants.MAX_PRODUCTS_PER_SHOPPING_CART];
		this.iterator = 0;
		this.price = new BigDecimal(0.0).setScale(2, RoundingMode.DOWN);;
		this.countOfProducts = 0;
	}

	public void addProduct(Product product,int count){

		 if(iterator<20){
		 	productArr[iterator] = new ProductsCount(product,count);
		 }
		iterator++;
		 countOfProducts += count;
		price =price.add(new BigDecimal(product.getPrice()* count));
	}

	public void removeProduct(int IdProduct){
		for (int i = 0; i <productArr.length ; i++) {
			if (productArr[i]!=null && productArr[i].getProduct().getId()==IdProduct) {
				countOfProducts -= productArr[i].getCount();
				price =price.subtract(new BigDecimal(productArr[i].getCount() * productArr[i].getProduct().getPrice()));
				productArr[i] = null;
			}
		}
	}

	public double getTotalCost(){
		return new BigDecimal(price.doubleValue()).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}

	public int getTotalCount(){
	return countOfProducts;
	}

	public ArrayList<ProductsCount> getProducts(){
		ArrayList<ProductsCount> productsCounts = new ArrayList<>();
		for (int i = 0; i<20 ; i++) {
			if (productArr[i] != null) productsCounts.add(productArr[i]);
		}
		return productsCounts;
	}
}
