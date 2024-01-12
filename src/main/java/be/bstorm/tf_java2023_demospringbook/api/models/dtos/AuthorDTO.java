package be.bstorm.tf_java2023_demospringbook.api.models.dtos;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Author;

public record AuthorDTO(
        Long id,
        String name
) {
    public static AuthorDTO fromEntity(Author author){
        return new AuthorDTO(author.getId(), author.getName());
    }
}
