package be.bstorm.tf_java2023_demospringbook.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String title;

    @ManyToOne
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
}
