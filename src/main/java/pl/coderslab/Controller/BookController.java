package pl.coderslab.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    @ResponseBody
    public
    List<Book> getList() {
        return bookService.getBooks();
    }
}
