package serviceImpl;

import model.Store;
import service.CartService;
import service.CustomerService;
import service.TransactionService;
import exceptions.CustomerNotFoundException;
import model.Cart;
import model.Product;
import model.User;

import java.util.UUID;

public class TransactionServiceImpl implements TransactionService {

    private CustomerService customerService;
    private CartService cartService;
    private Cart cart;


    public TransactionServiceImpl(CustomerService customerService, CartService cartService, Cart cart) {
        this.customerService = customerService;
        this.cartService = cartService;
        this.cart = cart;
    }


    public CustomerService getCustomerService() {
        return customerService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public Cart getCart() {
        return cart;
    }


    @Override
    public String printTransactionInvoice(UUID customerId, UUID cartId) throws CustomerNotFoundException {
        String test = "";
        User buyer =  getCustomerService().getCustomerById(customerId);
        Cart cart = getCartService().findCartById(customerId,cartId);
        if (cart.getBasket().size() > 0 && buyer.getUserId() != null) {
            for(Product product: cart.getBasket()){
                System.out.println("Product name: " + product.getProductName() + "price: " + product.getPrice() + "qty: " + getCart().getQtyProduct());
            }
            System.out.println(getCartService().calculateTotalPriceInCarts(customerId,cartId));
            test = "transaction successful";
        }else {
            test = "transaction failed";
        }
        return test;
    }


    @Override
    public void makeTransactions(UUID customerId, UUID cartId) throws CustomerNotFoundException {
        User buyer =  getCustomerService().getCustomerById(customerId);
        Cart cart = getCartService().findCartById(customerId,cartId);
        double walletBalance = 0;
        if(cart.getBasket().size() > 0 && buyer.getUserId() != null && buyer.getWallet().getAmount() > getCartService().calculateTotalPriceInCarts(customerId, cartId)){
            Store.setStorePurse(getCartService().calculateTotalPriceInCarts(customerId, cartId));
            System.out.println(buyer.getWallet().getAmount());
            walletBalance = buyer.getWallet().getAmount() - getCartService().calculateTotalPriceInCarts(customerId, cartId);
            buyer.getWallet().setAmount(walletBalance);
            System.out.println("wallet balance is " + walletBalance);
        }
        else{
            System.out.println("Insufficient wallet balance");

        }
    }
}
