package model;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    private UUID userId;
    private String name;
    private RoleType roleType;
    private Wallet wallet;
    Set<Cart> carts = new HashSet<>();

    public User(String name, RoleType roleType, Wallet wallet) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.roleType = roleType;
        this.wallet = wallet;
    }
    public User(){}

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", roleType=" + roleType +
                ", wallet=" + wallet +
                '}';
    }
}
