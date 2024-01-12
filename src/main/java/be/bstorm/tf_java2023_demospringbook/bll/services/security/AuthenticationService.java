package be.bstorm.tf_java2023_demospringbook.bll.services.security;

import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;

public interface AuthenticationService {

    User register(User user);
    User login(User user);
}
