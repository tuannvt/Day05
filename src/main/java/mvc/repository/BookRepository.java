package mvc.repository;

import mvc.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity,Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameAndAuthor(String name,String author);
    List<BookEntity> findByNameOrAuthor(String name,String author);
    List<BookEntity>  findByBookDetailsIsbn(String isbn);
    List<BookEntity> findByBookDetailsPriceLessThan(double price);
    List<BookEntity> findByBookDetailsPriceLessThanEqual(double price);
    List<BookEntity> findByBookDetailsPriceGreaterThanEqual(double price);
    List<BookEntity> findByNameContaining(String name);
}
