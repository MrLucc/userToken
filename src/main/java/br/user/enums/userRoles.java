package br.user.enums;

public enum userRoles {

    ADMIN("1"),
    USER("user");

   private String roles;

    userRoles(String role){
        this.roles = role;
    }

    public String getRoles() {
        return roles;
    }
}
