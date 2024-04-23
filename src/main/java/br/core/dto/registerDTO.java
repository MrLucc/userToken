package br.core.dto;

import br.user.enums.userRoles;

public record registerDTO(String email, String password, userRoles Role) {
}
