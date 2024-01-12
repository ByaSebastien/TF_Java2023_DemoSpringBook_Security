package be.bstorm.tf_java2023_demospringbook.dal.repositories;

import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.email like :email")
    public Optional<User> findUserByEmail(String email);
}
