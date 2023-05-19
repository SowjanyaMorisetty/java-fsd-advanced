package com.UST.StudentServicefeign.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/student")
public class BookController {

    @Autowired
    private BookRestConsumer consumer;

    @GetMapping("/data")
    public String getStduentInfo()
    {
        System.out.println(consumer.getClass().getName());

        return "Accessing from STUDENT_SERVICE ==>"+consumer.getBookData();

    }


    @GetMapping("/allBooks")
    public String getBooksInfo()
    {
        return "Accessing from STUDENT_SERVICE ==>"+consumer.getAllBooks();
    }


    @GetMapping("/getOneBook/{id}")
    public String getOneBookForStd(@PathVariable Integer id)
    {
        return "Accessing from STUDENT_SERVICE ==>"+consumer.getBookById(id);

    }

    @GetMapping("/entityData")
    public String printEntityData()
    {
        ResponseEntity<String> resp=consumer.getEntityData();
        return "Accessing from STUDENT_SERVICE ==>"+resp.getBody()+",status is:"+resp.getStatusCode();

    }


}
