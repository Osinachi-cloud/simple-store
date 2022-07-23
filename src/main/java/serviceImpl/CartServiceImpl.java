package serviceImpl;

import service.CartService;
import service.CustomerService;
import service.ProductService;
import exceptions.CustomerNotFoundException;
import exceptions.ProductNotFoundException;
import model.Cart;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CartServiceImpl implements CartService {


    private CustomerService customerService;
    private ProductService productService;
    private Cart cart;

    public CartServiceImpl(CustomerService customerService, ProductService productService, Cart cart) {
        this.customerService = customerService;
        this.productService = productService;
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public ProductService getProductService() {
        return productService;
    }

    @Override
    public Cart addToCart(UUID customerId, String productName, int quantity) throws CustomerNotFoundException, ProductNotFoundException {
        User buyer =  getCustomerService().getCustomerById(customerId);
        Product product = getProductService().findProductByName(productName);

        Product selectedProduct = new Product();
        if(buyer.getUserId() != null && product.getQuantity() > quantity){
            selectedProduct.setProductName(product.getProductName());
            selectedProduct.setQuantity(quantity);
            selectedProduct.setPrice(product.getPrice());
            selectedProduct.setCategory(product.getCategory());

            getCart().addProductToBasket(selectedProduct);
            getCart().setTotalAmount(product.getPrice() * (double)quantity);
            getCart().setQtyProduct(quantity);

            product.setQuantity(product.getQuantity() - selectedProduct.getQuantity());
            return getCart();
        }
        buyer.getCarts().add(getCart());

        return getCart();
    }

    @Override
    public Cart findCartById(UUID customerId, UUID cartId) throws CustomerNotFoundException {
        List<Cart> myCart = new ArrayList<Cart>();
        User buyer =  getCustomerService().getCustomerById(customerId);
        if(buyer.getUserId() != null) {
            for (Cart cart : buyer.getCarts()) {
                if (cart.getCartId().equals(cartId)) {
                    myCart.add(cart);
                }
            }
        }
        return  myCart.get(0);
    }

    @Override
    public double calculateTotalPriceInCarts(UUID customerId, UUID cartId) throws CustomerNotFoundException {
        double price = 0;
        User buyer =  getCustomerService().getCustomerById(customerId);
        Cart cart = findCartById(customerId,cartId);
        if (buyer.getUserId() != null && cart != null) {
            for(Product product: cart.getBasket()){
                price = product.getPrice() * getCart().getQtyProduct();
            }
            cart.setTotalAmount(price);
            return price;

        }
        return price;
    }



}
