import service.CartService;
import service.CustomerService;
import service.ProductService;
import service.TransactionService;
import exceptions.CustomerNotFoundException;
import exceptions.NoItemFoundException;
import exceptions.ProductNotFoundException;
import enums.Category;
import model.*;
import serviceImpl.CartServiceImpl;
import serviceImpl.CustomerServiceImpl;
import serviceImpl.ProductServiceImpl;
import serviceImpl.TransactionServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoItemFoundException, ProductNotFoundException, CustomerNotFoundException {
        // create role types manager and customer
        CustomerRoleType customerRoleType = new CustomerRoleType();
        ManagerRoleType managerRoleType = new ManagerRoleType();

        // create a Wallet and assign to a customer
        Wallet wallet = new Wallet();
        wallet.setAmount(3000);


        // create manager
        User manager = new User("Uche",managerRoleType, wallet);


        // customer
        User customer = new User("osinachi",customerRoleType, wallet);
        customer.setWallet(wallet);



        // create product for store
        List<Product> listOfProduct = new ArrayList<>();
        Product  burger = new Product("burger", 50.00, Category.SNACKS, 30);
        Product  milk = new Product("burger", 50.00, Category.SNACKS, 30);
        listOfProduct.add(burger);
        listOfProduct.add(milk);

        // Let us restock our stock
        Store.restockStore(listOfProduct,manager);

        // print all products in store
        System.out.println(Store.getAllProductInStore());

        // Customer in store
        System.out.println("Starts***********Store methods*****************");
        Store.addCustomerToDataBase(customer);
        System.out.println(Store.getAllCustomersInDataBase());
        System.out.println("ends***********Store methods*****************");
        System.out.println("");





//      Test ProductImpl methods
        ProductService productService = new ProductServiceImpl();
        System.out.println("Starts***********Test ProductImpl methods*****************");
        System.out.println(productService.getAllProductsInStore());
        System.out.println(productService.findProductByName("burger"));
        System.out.println(productService.searchProductByName("burger"));
        System.out.println("Ends***********Test ProductImpl methods*****************");
        System.out.println("");





        // cart
        List<Product> listOfProduct1 = new ArrayList<>();
        Cart cart = new Cart(listOfProduct1);
        cart.getBasket().add(burger);




//      Test CustomerImpl methods
        CustomerService customerService = new CustomerServiceImpl();
        System.out.println("Starts***********Test customerImpl methods*****************");
        System.out.println(customerService.getCustomerById(customer.getUserId()));
        System.out.println(customerService.getCustomerById(customer.getUserId()));
        System.out.println("Ends***********Test CustomerImpl methods*****************");
        System.out.println("");



        //Test CartImpl methods
        System.out.println("Starts***********Test CartImpl methods*****************");
        CartService cartService = new CartServiceImpl(customerService, productService, cart);
        customer.getCarts().add(cart);
        System.out.println(cartService.findCartById(customer.getUserId(),cart.getCartId()));
        cartService.addToCart(customer.getUserId(), "burger",29);
        System.out.println(cartService.calculateTotalPriceInCarts(customer.getUserId(),cart.getCartId()));
        System.out.println("Ends***********Test CartImpl methods*****************");
        System.out.println("");


        // Test Transaction methods
        System.out.println("Starts***********Test TransactionImpl methods*****************");
        TransactionService transactionService = new TransactionServiceImpl(customerService, cartService, cart);
        System.out.println(transactionService.printTransactionInvoice(customer.getUserId(), cart.getCartId()));
        transactionService.makeTransactions(customer.getUserId(),cart.getCartId());
        System.out.println("Ends***********Test TransactionImpl methods*****************");
        System.out.println("");

        // after the transaction check how much the store now has
        System.out.println("*************** get the total revenue of the store **************");
        System.out.println(Store.getStorePurse());
        System.out.println("");




        System.out.println("********************************Class Example for stream**********************************");
        List<Product> listProduct2 = new ArrayList<>();
        Product  product2 = new Product("burger", 50.00, Category.SNACKS, 30);
        Product  product3 = new Product("milk", 30.00, Category.SNACKS, 30);
        Product  product4 = new Product("chocolate", 50.00, Category.SNACKS, 30);
        Product  product5 = new Product("chocolate", 50.00, Category.SNACKS, 30);

        listProduct2.add(product2);
        listProduct2.add(product3);
        listProduct2.add(product4);
        listProduct2.add(product5);

        listProduct2.forEach(System.out::println);
        System.out.println(listProduct2.stream().filter(product -> product.getPrice() == 50).collect(Collectors.toList()));
        listProduct2.stream().filter(product -> product.getPrice() == 50).forEach(System.out::println); // prints only product whose prices are equal to 50
        listProduct2.stream().map(product -> product.getProductName()).forEach(System.out::println); // prints all product name
        listProduct2.stream().map(product -> product.getProductName()).distinct().forEach(System.out::println); // prints all UNIQUE product name


    }
}
