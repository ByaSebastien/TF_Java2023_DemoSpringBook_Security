package be.bstorm.tf_java2023_demospringbook.bll.services.impl;

import be.bstorm.tf_java2023_demospringbook.bll.services.UserService;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email).orElseThrow();
    }
}
