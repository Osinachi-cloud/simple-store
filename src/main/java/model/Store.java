package model;

import service.CustomerService;
import service.ProductService;
import serviceImpl.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static List<Product> allProductInStore;
    private static double storePurse;

    public static double getStorePurse() {
        return storePurse;
    }

    public static void setStorePurse(double newTransactionAmount) {
        double newAmount = storePurse + newTransactionAmount;
        storePurse = newAmount;
    }

    public static List<Product> getAllProductInStore(){
        return allProductInStore;
    }
    private static List<User> allCustomersInDataBase = new ArrayList<>();


    public static void setAllProductInStore(List<Product> allProductInStore) {
        Store.allProductInStore = allProductInStore;
    }

    public static List<User> getAllCustomersInDataBase() {
        return allCustomersInDataBase;
    }

    public static void addCustomerToDataBase(User newCustomer){
        CustomerRoleType customerRoleType = new CustomerRoleType();
        if(newCustomer.getRoleType().getRole().equals(customerRoleType.getRoleType()))
            getAllCustomersInDataBase().add(newCustomer);
    }

    public static void restockStore(List<Product> allProductInStore, User user) {
        ManagerRoleType managerRoleType = new ManagerRoleType();
        if(user.getRoleType().getRole().equals(managerRoleType.getRoleType())) {
            Store.allProductInStore = allProductInStore;
        }else{
            System.out.println("you are not  authorized to update the store");
        }
    }
}
