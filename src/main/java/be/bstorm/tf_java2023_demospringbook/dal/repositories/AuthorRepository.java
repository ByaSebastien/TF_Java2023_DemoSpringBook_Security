package be.bstorm.tf_java2023_demospringbook.dal.repositories;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

//    @Query("select a from Author a where a.name like :name")
    Optional<Author> findAuthorByName(String name);
}
