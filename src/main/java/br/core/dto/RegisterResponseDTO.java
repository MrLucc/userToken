package br.core.dto;

import br.user.enums.UserRoles;

public record RegisterResponseDTO(String email, String password, UserRoles roles, String nome) {
}
