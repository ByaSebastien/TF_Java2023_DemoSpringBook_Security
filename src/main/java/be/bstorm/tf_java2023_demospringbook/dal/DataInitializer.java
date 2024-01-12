package be.bstorm.tf_java2023_demospringbook.dal;

import be.bstorm.tf_java2023_demospringbook.dal.repositories.AuthorRepository;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.BookRepository;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.UserRepository;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Author;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;
import be.bstorm.tf_java2023_demospringbook.domain.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author();
        author.setName("Sun tzu");
        authorRepository.save(author);
        Book book1 = new Book("L'art de la guerre",author);
        bookRepository.save(book1);
        User admin = new User();
        admin.setEmail("admin@admin.be");
        admin.setPassword(passwordEncoder.encode("Test1234="));
        admin.setRole(UserRole.ADMIN);
        userRepository.save(admin);
    }
}
