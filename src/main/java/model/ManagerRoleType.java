package model;
import enums.Role;


public class ManagerRoleType  extends RoleType{

    public ManagerRoleType() {
        super(Role.MANAGER);
    }

    @Override
    public Role getRoleType() {
        return Role.MANAGER;
    }
}








