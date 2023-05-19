package com.UST.BookService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.DOMImplementation;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private Integer bookId;
    private String bookName;
    private Double bookCost;

}


