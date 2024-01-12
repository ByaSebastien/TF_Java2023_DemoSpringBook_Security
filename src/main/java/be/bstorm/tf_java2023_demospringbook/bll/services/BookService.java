package be.bstorm.tf_java2023_demospringbook.bll.services;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book getById(Long id);
    Book insert(Book book);
    Book update(Long id,Book book);
    void delete(Long id);
}
