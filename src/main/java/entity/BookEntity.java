package entity;

import javax.persistence.*;

@Entity
@Table(name = "book")

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity category;
    @OneToOne(cascade = {CascadeType.ALL})
    private BookDetailEntity bookDetails;
    public BookEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public BookDetailEntity getBookDetail() {
        return bookDetails;
    }

    public void setBookDetail(BookDetailEntity bookDetail) {
        this.bookDetails = bookDetail;
    }
    @Override
    public String toString(){
        return "BookEntity {"+
                "id="+id +
                ", name="+name+'\''+
                ", author="+author+'\''+
                ", category="+category+'\''+
                ",bookDetail="+bookDetails +'}';
    }
}
