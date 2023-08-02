package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;
import com.example.demo.models.Book;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long bookId);
    Book save(Book bookDTO);
    void deleteById(Long bookId);
}
