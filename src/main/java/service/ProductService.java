package service;

import exceptions.NoItemFoundException;
import exceptions.ProductNotFoundException;
import model.Product;
import model.Wallet;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product findProductByName(String productName) throws ProductNotFoundException;
    List<Product> getAllProductsInStore() throws NoItemFoundException;
    void addProductToStore(Product singleProduct);
    List<Product> searchProductByName(String productName) throws ProductNotFoundException;
}
