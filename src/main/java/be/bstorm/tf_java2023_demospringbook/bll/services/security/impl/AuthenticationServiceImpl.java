package be.bstorm.tf_java2023_demospringbook.bll.services.security.impl;

import be.bstorm.tf_java2023_demospringbook.bll.services.security.AuthenticationService;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.UserRepository;
import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;
import be.bstorm.tf_java2023_demospringbook.domain.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email is already taken");
        }
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        User existingUser = userRepository.findUserByEmail(user.getEmail()).orElseThrow();
        if(!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        return existingUser;
    }
}
