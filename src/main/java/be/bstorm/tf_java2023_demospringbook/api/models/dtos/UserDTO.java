package be.bstorm.tf_java2023_demospringbook.api.models.dtos;

import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;
import be.bstorm.tf_java2023_demospringbook.domain.enums.UserRole;

public record UserDTO(
        Long id,
        String email,
        UserRole role
) {

    public static UserDTO fromEntity(User user){
        return new UserDTO(user.getId(), user.getEmail(), user.getRole());
    }
}
