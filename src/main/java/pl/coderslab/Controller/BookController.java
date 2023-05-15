package pl.coderslab.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.App.Book;
import pl.coderslab.App.MockBookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private MockBookService mockBookService;

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }




}
