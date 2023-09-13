package repository;

import entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity,Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameAndAuthor(String name,String author);
    List<BookEntity> findByNameOrAuthor(String name,String author);
    BookEntity findByBookDetailsIsbn(String isbn);
//    List<BookEntity> findByBookDetailsPriceLessThan(int price);
//    List<BookEntity> findByBookDetailsPriceLessThanEqual(int price);
//    List<BookEntity> findByBookDetailsPriceGreaterThanEqual(int price);
//    List<BookEntity> findByNameContaining(String name);
}
