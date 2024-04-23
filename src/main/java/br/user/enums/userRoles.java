package br.user.enums;

public enum userRoles {

    ADMIN("admin"),
    USER("user");

   private String roles;

    userRoles(String role){
        this.roles = role;
    }

    public String getRoles() {
        return roles;
    }
}
