package serviceImpl;

import service.CustomerService;
import exceptions.CustomerNotFoundException;
import model.CustomerRoleType;
import model.Store;
import model.User;
import model.Wallet;

import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {



    @Override
    public void addCustomerToDataBase(User newCustomer){
        Store.addCustomerToDataBase(newCustomer);
    }

    @Override
    public List<User> getAllCustomersFromDataBase() {
        return Store.getAllCustomersInDataBase();
    }

    @Override
    public User createCustomerAccount(String name, Wallet wallet) {
        User newCustomer = new User(name, new CustomerRoleType(), wallet);
        addCustomerToDataBase(newCustomer);
        return newCustomer;
    }


    @Override
    public User getCustomerById(UUID customerId) throws CustomerNotFoundException {
        for(User customer: Store.getAllCustomersInDataBase()){
            if(customer.getUserId() == customerId){
                return customer;
            }
            else{
                throw new CustomerNotFoundException("customer with id " + customerId + " does not exist");
            }
        }
        System.out.println("testing 3");
        return null;
    }


    @Override
    public void deleteCustomer(UUID customerId) throws CustomerNotFoundException {
        for (User customer : Store.getAllCustomersInDataBase()) {
            if(customer.getUserId()==customerId){
                Store.getAllCustomersInDataBase().remove(customer);
                System.out.println("customer has been deleted successfully");
            }
            else {
                throw new CustomerNotFoundException("customer with id" + customerId + " does not exist");
            }
        }
    }
}
