package be.bstorm.tf_java2023_demospringbook.api.models.forms;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AuthorForm(

        @NotBlank(message = "Le nom est requis") @Size(min = 1,max = 100,message = "Taille entre 1 et 100")
        String name
) {
    public Author toEntity(){
        return new Author(this.name);
    }
}
