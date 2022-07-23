package model;

public class Wallet {
    private double amount = 0;
    private User walletOwner;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "amount=" + amount +
                ", walletOwner=" + walletOwner +
                '}';
    }
}
