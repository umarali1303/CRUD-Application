package com.restapp.crudapp.service;

import com.restapp.crudapp.dto.BookResponseDTO;
import com.restapp.crudapp.entity.BookEntity;
import com.restapp.crudapp.dto.BookRequestDTO;
import com.restapp.crudapp.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BooksRepository booksRepository;
    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {

        BookEntity bookEntity=new BookEntity();
        bookEntity.setDescription(bookRequestDTO.getDescription());
        bookEntity.setTitle(bookRequestDTO.getTitle());
        bookEntity=booksRepository.save(bookEntity);

        BookResponseDTO response=new BookResponseDTO();
        response.setDescription(bookEntity.getDescription());
        response.setTitle(bookEntity.getTitle());
        return response;

    }
}
