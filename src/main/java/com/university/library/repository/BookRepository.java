package com.university.library.repository;
 
import com.university.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
 
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
 
	/**
 	* Fetches every book alongside its author in one database round-trip,
 	* using a JOIN FETCH clause to avoid lazy-loading overhead.
 	*/
	@Query("SELECT b FROM Book b JOIN FETCH b.author")
	List<Book> findAllBooksWithAuthor();
}
