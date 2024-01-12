package be.bstorm.tf_java2023_demospringbook.api.models.forms;

import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;

public record LoginForm(
        String email,
        String password
) {
    public User toEntity(){
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
