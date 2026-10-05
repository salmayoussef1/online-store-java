package services;

import entites.Product;

public interface ProductManagementService {

    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);

}
