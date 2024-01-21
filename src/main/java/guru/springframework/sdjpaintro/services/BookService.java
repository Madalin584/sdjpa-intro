package guru.springframework.sdjpaintro.services;

import guru.springframework.sdjpaintro.aspect.AuditService;
import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @AuditService
    public List<Book> findAll() throws Exception {

        List<Book> result = bookRepository.findAll();

//        if(!result.isEmpty()) {
//            throw new Exception("Test");
//        }

        return result;
    }

    @AuditService
    public Book save(Book book) {
        Book book1 = bookRepository.save(book);

        return book1;
    }
}
