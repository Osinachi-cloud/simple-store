package model;

import enums.Role;

public class CustomerRoleType extends RoleType {


    public CustomerRoleType() {
        super(Role.CUSTOMER);
    }

    @Override
    public Role getRoleType() {
        return Role.CUSTOMER;
    }
}
