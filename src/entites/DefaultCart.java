package entites;

import java.util.Arrays;

public class DefaultCart implements Cart {

    private static final int DEFAULT_CART_CAPACITY = 10;
    private Product [] products;
    private int productCount;

    @Override
    public boolean isEmpty() {
        if (products == null) {
            return true;
        }
        for (Product product : products) {
            if (product != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (products == null) {
            products = new Product[DEFAULT_CART_CAPACITY];
        }
        if (productCount >= products.length) {
            products = Arrays.copyOf(products, products.length*2);
        }
        products[productCount++] = product;
    }

    @Override
    public Product[] getProducts() {
        if (products == null) {
            return new Product[0];
        }
        int nonNULlProductCount = 0;
       for (Product product : products) {
           if (product != null) {
               nonNULlProductCount++;
           }
       }
       Product[] newProducts = new Product[nonNULlProductCount];
       int index = 0;
       for (Product product : products) {
           if (product != null) {
               newProducts[index++] = product;
           }
       }
       return newProducts;
    }

    @Override
    public void clear() {
    products = new Product[DEFAULT_CART_CAPACITY];
     productCount = 0;
    }

}
