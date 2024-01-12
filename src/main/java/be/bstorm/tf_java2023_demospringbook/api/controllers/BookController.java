package be.bstorm.tf_java2023_demospringbook.api.controllers;

import be.bstorm.tf_java2023_demospringbook.api.models.dtos.BookDTO;
import be.bstorm.tf_java2023_demospringbook.api.models.forms.BookForm;
import be.bstorm.tf_java2023_demospringbook.bll.services.BookService;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll(){
        List<BookDTO> books = bookService.getAll().stream()
                .map(BookDTO::fromEntity)
                .collect(Collectors.toList());

//        List<Book> result = bookService.getAll();
//        List<BookDTO> dtos = new ArrayList<>();
//        for (Book b : result){
//            dtos.add(BookDTO.fromEntity(b));
//        }

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable Long id){

        BookDTO book = BookDTO.fromEntity(bookService.getById(id));
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(
            @Valid @RequestBody BookForm form
            ){
        BookDTO dto = BookDTO.fromEntity(bookService.insert(form.toEntity()));
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody BookForm form
    ){
        BookDTO dto = BookDTO.fromEntity(bookService.update(id,form.toEntity()));
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){
        bookService.delete(id);
        return ResponseEntity.status(200).build();
    }
}
