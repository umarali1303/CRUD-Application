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
    @GetMapping("/get/{id}")
    public ResponseEntity getBookById(@PathVariable Long id){
        var response=bookService.getBookById(id);
        if(response==null) return new ResponseEntity("Book Not found with the Id "+id,HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/all")
    public ResponseEntity getAllBook(){
        var response=bookService.getAllBook();
        return ResponseEntity.ok(response);
    }


}
