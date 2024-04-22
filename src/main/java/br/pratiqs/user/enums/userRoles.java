package br.pratiqs.user.enums;

public enum userRoles {

    ADMIN("admin"),
    USER("user");

   private String role;

    userRoles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
