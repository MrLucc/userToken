package br.user.enums;

public enum UserRoles {

    ADMIN("admin"),
    USER("user");

   private String roles;

    UserRoles(String role){
        this.roles = role;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
