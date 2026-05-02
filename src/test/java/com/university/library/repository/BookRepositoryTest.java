package com.university.library.repository;

import com.university.library.model.Author;
import com.university.library.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindAllBooksWithAuthor() {
        // Arrange
        Author author = new Author();
        author.setName("J.K. Rowling");
        author.setEmail("jk@test.com");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Harry Potter");
        book.setPrice(20.0);
        book.setPublishedDate(LocalDate.of(1997, 6, 26));
        book.setAuthor(author);
        bookRepository.save(book);

        // Act
        List<Book> results = bookRepository.findAllBooksWithAuthor();

        // Assert
        assertFalse(results.isEmpty());
        assertNotNull(results.get(0).getAuthor());
        assertEquals("J.K. Rowling", results.get(0).getAuthor().getName());
    }
}
