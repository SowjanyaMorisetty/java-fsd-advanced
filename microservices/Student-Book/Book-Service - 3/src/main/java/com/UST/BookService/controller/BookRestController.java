package com.UST.BookService.controller;


import com.UST.BookService.model.Book;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

    @Autowired
    Environment environment;


    @GetMapping("/data")
    public String getBookData()
    {
        return "data of BOOK_SERVICE ,Running on port: " +environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id)
    {
        return new Book(id,"Java",1000.00);
    }


    @GetMapping("/all")
    public List<Book> getAll()
    {
        return List.of
                (
                        new Book(501,"java",2000.00),
                        new Book(502,"spring",3000.00),
                        new Book(503,"python",4000.00)
                );

    }

    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData()
    {
        return new ResponseEntity<String>(
                "Hello from BookRestController",
                HttpStatus.OK);

    }
}
