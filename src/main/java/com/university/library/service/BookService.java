package com.university.library.service;
 
import com.university.library.model.Book;
import com.university.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
 
@Service
public class BookService {
 
	@Autowired
	private BookRepository bookRepository;
 
	/** Retrieves all books with their author data pre-loaded. */
	public List<Book> getAllBooks() {
		return bookRepository.findAllBooksWithAuthor();
	}
 
	/** Persists a new book or applies changes to an existing record. */
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
 
	/** Locates a specific book by ID; raises an exception if not found. */
	public Book getBookById(Long id) {
		return bookRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(
				"No book found with ID: " + id));
	}
}
