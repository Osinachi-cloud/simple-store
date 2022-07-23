package serviceImpl;

import service.ProductService;
import exceptions.NoItemFoundException;
import exceptions.ProductNotFoundException;
import model.Product;
import model.Store;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{


    @Override
    public Product findProductByName(String productName) throws ProductNotFoundException {
        List<Product> list = new ArrayList<>();
        for(Product product : Store.getAllProductInStore()){
                if(productName.equals(product.getProductName())){
                    list.add(product);
                return product;
            }else{
               throw new ProductNotFoundException("Product" + product.getProductName() + "not found"); // throws exception if searchedName does not match available product
            }
        }
        return list.get(0);
    }

    //alternative method for search

    @Override
    public List<Product> searchProductByName(String productName) throws ProductNotFoundException{
        return Store.getAllProductInStore().stream().filter(product -> productName.equals(product.getProductName())).collect(Collectors.toList());
    }


    @Override
    public List<Product> getAllProductsInStore() throws NoItemFoundException {
        List store = Store.getAllProductInStore();
        if(store.isEmpty()){
            throw new NoItemFoundException("no item found in store");
        }
        return Store.getAllProductInStore();
    }

    @Override
    public void addProductToStore(Product singleProduct) {
       if(Store.getAllProductInStore().add(singleProduct)){
           List<Product> updatedStock = Store.getAllProductInStore();
           Store.setAllProductInStore(updatedStock);
       }
    }

}
