package yte.intern.springdata.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yte.intern.springdata.entities.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    List<Book> findByAgeGreaterThanEqual(Long age, Sort sort);

    List<Book> findByPublishDateAfter(LocalDate publishDate, Pageable pageRequest);

    List<Book> findByTitleContains(String title);

    List<Book> findByAuthorAndAgeGreaterThan(String author, Long age);

    long countByAuthor(String author);

    boolean existsByAuthor(String author);

    @Query("select b from Book b where b.title = :title")
    Book findByTitleQuery(String title);

    @Query("select b from Book b where b.age >= :age")
    List<Book> findByAgeGreaterThanEqualQuery(Long age, Sort sort);

    @Query("select b from Book b where b.publishDate > :publishDate")
    List<Book> findByPublishDateAfterQuery(LocalDate publishDate, Pageable pageRequest);

    @Query("select b from Book b where b.title like %:title%")
    List<Book> findByTitleLikeQuery(String title);

    @Query("select b from Book b where b.author = :author and b.age > :age")
    List<Book> findByAuthorAndAgeGreaterThanQuery(String author, Long age);

    @Query("select count(b) from Book b where b.author = :author")
    long countByAuthorQuery(String author);

}
