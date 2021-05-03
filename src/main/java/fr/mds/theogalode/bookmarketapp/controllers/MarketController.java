package fr.mds.theogalode.bookmarketapp.controllers;

import fr.mds.theogalode.bookmarketapp.models.Book;
import fr.mds.theogalode.bookmarketapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/market")
public class MarketController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    @PreAuthorize("hasRole('USER')")
    public String getAllBooks() {
        return "null";
    }

    @PostMapping("/books/buy")
    @PreAuthorize("hasRole('USER') and hasRole('CUSTOMER')")
    //public String buyBook() {
        return "null";
    }

    @PostMapping("/books/add")
    @PreAuthorize("hasRole('USER') and hasRole('CUSTOMER')")
    public Book buyBook() {
        try {
            Book book = bookRepository
                    .save(new Book(book.getName(), book.getDescription(), false));
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "null";
    }
}
