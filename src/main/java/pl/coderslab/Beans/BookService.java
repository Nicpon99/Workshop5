package pl.coderslab.Beans;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBook(int id);
}
