package pl.coderslab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.Beans.MockBookService;
import pl.coderslab.Controller.BookController;

@Configuration
@EnableWebMvc
@ComponentScan
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public MockBookService mockBookService(){
        return new MockBookService();
    }

    @Bean
    public BookController bookController(){
        return new BookController(mockBookService());
    }
}
