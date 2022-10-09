package com.restapp.crudapp.controller;

import com.restapp.crudapp.dto.BookRequestDTO;
import com.restapp.crudapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody BookRequestDTO bookRequestDTO){
        var response =bookService.addBook(bookRequestDTO);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }

}
