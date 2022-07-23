package model;

import java.util.List;
import java.util.UUID;

public class Cart {


    private UUID cartId;
    private List<Product> basket;
    private Double totalAmount;
    private int qtyProduct;

    public Cart(List<Product> basket) {
        this.cartId = UUID.randomUUID();
        this.basket = basket;
    }


    public UUID getCartId() {
        return cartId;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void addProductToBasket(Product newProduct) {
        basket.add(newProduct);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    public int getQtyProduct() {
        return qtyProduct;
    }

    public void setQtyProduct(int qtyProduct) {
        this.qtyProduct = qtyProduct;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", basket=" + basket +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
