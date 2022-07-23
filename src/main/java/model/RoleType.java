package model;

import enums.Role;

public abstract class RoleType {
    private Role role = Role.CUSTOMER;

    public RoleType(Role role) {
        this.role = role;
    }
    public abstract Role getRoleType();

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleType{" +
                "role=" + role +
                '}';
    }
}


