package mvc.main;

import mvc.configuration.JPAConfig;
import mvc.entity.BookDetailEntity;
import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static ApplicationContext context =new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository");

    public static void main(String[] args) {
        createNewBookEntityNewCategory();
        createNewBookEntry();
        findByAuthor("Roger");
//        findByNameAndAuthor("Linux","Roger");
//        findByNameOrAuthor("Linux","Roger");
//        findByBookDetailsIsbn("ISIBF12345");
//        findByBookDetailsPriceLessThan(65.0);     // < x
//        findByBookDetailsPriceLessThanEqual(55.0);// <= x
//        findByBookDetailsPriceGreaterThanEqual(75);// >= x
//        findByNameContaining("Ja");
    }
    public static void createNewBookEntry(){
        CategoryEntity categoryEntity=new CategoryEntity();
        categoryEntity.setId(1);
        BookEntity bookEntity=createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }
    public  static void createNewBookEntityNewCategory(){
        CategoryEntity categoryEntity=createNewCategory();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity=createNewBook();
        bookRepository.save(bookEntity);
    }
    private static CategoryEntity createNewCategory(){
        CategoryEntity categoryEntity=new CategoryEntity();
        categoryEntity.setName("IT");
        categoryEntity.setDescription("IT book");
        return categoryEntity;
    }
    private static BookEntity createNewBook(){
        BookDetailEntity bookDetailEntity=new BookDetailEntity();
        bookDetailEntity.setIsbn("ISIBF12345");
        bookDetailEntity.setNumberOfPage(23);
        bookDetailEntity.setPrice(65.0);
        bookDetailEntity.setPublishDate(LocalDate.now());

        BookEntity bookEntity=new BookEntity();
        bookEntity.setName("Java A-Z");
        bookEntity.setAuthor("Roger");
        bookEntity.setBookDetail(bookDetailEntity);
        bookDetailEntity.setBook(bookEntity);

        return bookEntity;
    }
    public static void findByAuthor(String author){
        List<BookEntity> bookEntityList=bookRepository.findByAuthor(author);
        if (bookEntityList !=null){
            System.out.println("\nFind "+bookEntityList.size() +"book wich author = "+author);
            for (BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameAndAuthor(String name,String author){
        List<BookEntity> bookEntityList=bookRepository.findByNameAndAuthor(name,author);
        if (bookEntityList!=null){
            System.out.println("\nFind "+bookEntityList.size()+" book wich name "+name+" and author "+author);
            for (BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameOrAuthor(String name,String author){
        List<BookEntity> bookEntityList=bookRepository.findByNameOrAuthor(name,author);
        if (bookEntityList!=null){
            System.out.println("\nFind "+bookEntityList.size()+" book wich name "+name+" and author "+author);
            for (BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByBookDetailsIsbn(String isbn){
        List<BookEntity>  bookEntity=bookRepository.findByBookDetailsIsbn(isbn);
        if (bookEntity!=null){
            System.out.println("\nFind  book wich isbn= "+isbn);
                System.out.println(bookEntity.toString());
        }
    }
    public static void findByBookDetailsPriceLessThan(double price){
        List<BookEntity>  bookEntity=bookRepository.findByBookDetailsPriceLessThan(price);
        if (bookEntity!=null){
            System.out.println("\nFind  book wich isbn= "+bookEntity.size());
            System.out.println(bookEntity.toString());
        }
    }
    public static void findByBookDetailsPriceLessThanEqual(double price){
        List<BookEntity>  bookEntity=bookRepository.findByBookDetailsPriceLessThanEqual(price);
        if (bookEntity!=null){
            System.out.println("\nFind  book wich isbn= "+bookEntity.size());
            System.out.println(bookEntity.toString());
        }
    }
    public static void findByBookDetailsPriceGreaterThanEqual(double price){
        List<BookEntity>  bookEntity=bookRepository.findByBookDetailsPriceGreaterThanEqual(price);
        if (bookEntity!=null){
            System.out.println("\nFind  book wich isbn= "+bookEntity.size());
            System.out.println(bookEntity.toString());
        }
    }
    public static void findByNameContaining(String name){
        List<BookEntity>  bookEntity=bookRepository.findByNameContaining(name);
        if (bookEntity!=null){
            System.out.println("\nFind  book wich isbn= "+bookEntity.size());
            System.out.println(bookEntity.toString());
        }
    }
}

