package be.bstorm.tf_java2023_demospringbook.dal.repositories;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
