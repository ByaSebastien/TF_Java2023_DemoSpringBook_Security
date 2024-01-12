package be.bstorm.tf_java2023_demospringbook.api.models.forms;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record BookForm(
        @NotBlank @Size(min = 1, max = 100)
        String title,
        @Valid
        AuthorForm author
) {
    public Book toEntity(){
        return new Book(this.title,author.toEntity());
    }
}
