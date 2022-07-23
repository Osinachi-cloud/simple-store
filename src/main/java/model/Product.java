package model;


import enums.Category;

public class Product {
    private String productName;
    private double price;
    private Category category;
    private int quantity;

    public Product(String productName, double price, Category category, int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
    public Product(){
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String toString(){
        return "name: " + getProductName()  + " price: " +  getPrice() + " category: " + getCategory();
    }
}
