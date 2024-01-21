package guru.springframework.sdjpaintro.controllers;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/findAll")
    public List<Book> findAll() throws Exception {
        return bookService.findAll();
    }

    @PostMapping("/save")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }
}
