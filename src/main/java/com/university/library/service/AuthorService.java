package com.university.library.service;
import com.university.library.model.Author;
import com.university.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
 
@Service
public class AuthorService {
 
	@Autowired
	private AuthorRepository authorRepository;
 
	/** Returns all author records ordered by their insertion sequence. */
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}
 
	/** Persists a new author or updates an existing one (upsert behaviour). */
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
 
	/** Fetches an author by its surrogate key; throws if absent. */
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(
				"No author found with ID: " + id));
	}
}
