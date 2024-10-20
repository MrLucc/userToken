package br.core.domain;

public enum UserRolesEnums {

    ADMIN("admin"),
    USER("user");

   private String roles;

    UserRolesEnums(String role){
        this.roles = role;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
