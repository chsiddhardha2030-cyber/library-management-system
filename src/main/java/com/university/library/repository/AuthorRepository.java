package com.university.library.repository;
 
import com.university.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
 
	/**
	* Checks whether an author record with the specified email already exists.
	* Derived automatically by Spring Data JPA from the method name.
	*/
	boolean existsByEmail(String email);
}
