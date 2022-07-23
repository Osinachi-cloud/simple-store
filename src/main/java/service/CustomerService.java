package service;

import exceptions.CustomerNotFoundException;
import model.User;
import model.Wallet;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    void addCustomerToDataBase(User newCustomer);
    List<User> getAllCustomersFromDataBase();
    User createCustomerAccount(String name, Wallet wallet);
    User getCustomerById(UUID customerId) throws CustomerNotFoundException;
    void deleteCustomer(UUID customerId) throws CustomerNotFoundException;
}
