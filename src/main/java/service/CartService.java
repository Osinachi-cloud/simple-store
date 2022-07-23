package service;

import exceptions.CustomerNotFoundException;
import exceptions.ProductNotFoundException;
import model.Cart;

import java.util.UUID;

public interface CartService {

      Cart addToCart(UUID customerId, String productName, int quantity) throws CustomerNotFoundException, ProductNotFoundException;
      Cart findCartById(UUID customerId, UUID cartId) throws CustomerNotFoundException;
      double calculateTotalPriceInCarts(UUID customerId, UUID cartId) throws CustomerNotFoundException;

}
