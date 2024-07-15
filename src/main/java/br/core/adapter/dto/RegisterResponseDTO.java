package br.core.adapter.dto;

import br.core.domain.UserRoles;

public record RegisterResponseDTO(String email, String password, UserRoles roles, String nome) {
}
