package be.bstorm.tf_java2023_demospringbook.api.models.dtos;

import be.bstorm.tf_java2023_demospringbook.domain.enums.UserRole;

public record UserTokenDTO(
        UserDTO user,
        String token
) {
}
