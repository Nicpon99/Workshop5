package pl.coderslab.Beans;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements BookService{
    private List<Book> books;

    private static Long nextId = 4L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy,	Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getBook(int id){
        int index = -1;
        boolean check = false;
        for (Book book : books) {
            if (book.getId() == id){
                index = books.indexOf(book);
                check = true;
                break;
            }
        }
        if (check){
            return books.get(index);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The book with this ID doesn't exist in the database");
        }
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void editBook(Book book) {
        boolean check = true;
        for (Book b : books) {
            if (book.getId() == b.getId()){
                int index = books.indexOf(b);
                books.remove(index);
                books.add(index, book);
                check = false;
                break;
            }
        }
        if (check){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The book with this ID doesn't exist in the database");
        }
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
