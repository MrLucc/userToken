package br.core.adapter.dto;

import br.core.domain.UserRolesEnums;

public record RegisterResponseDTO(String email, String password, UserRolesEnums roles, String nome) {
}
