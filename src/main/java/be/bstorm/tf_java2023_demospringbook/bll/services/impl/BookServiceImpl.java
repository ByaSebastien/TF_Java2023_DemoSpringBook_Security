package be.bstorm.tf_java2023_demospringbook.bll.services.impl;

import be.bstorm.tf_java2023_demospringbook.bll.services.BookService;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.AuthorRepository;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.BookRepository;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Author;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book insert(Book book) {
        Author author = authorRepository.findAuthorByName(book.getAuthor().getName()).orElse(null);

        if(author == null){
            author = authorRepository.save(book.getAuthor());
        }
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow();
        existingBook.setTitle(book.getTitle());
        return bookRepository.save(existingBook);
    }

    @Override
    public void delete(Long id) {
        Book existingBook = bookRepository.findById(id).orElseThrow();
        bookRepository.deleteById(id);
    }
}
