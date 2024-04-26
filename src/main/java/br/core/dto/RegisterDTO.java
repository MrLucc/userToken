package br.core.dto;

import br.user.enums.UserRoles;

public record RegisterDTO(String email, String password, UserRoles roles) {
}
