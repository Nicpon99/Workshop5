package pl.coderslab.Controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.Beans.Book;
import pl.coderslab.Beans.BookService;
import pl.coderslab.Beans.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController() {
    }

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public
    List<Book> getList() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBook(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("")
    public void editBook(@RequestBody Book book){
        bookService.editBook(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }

}
