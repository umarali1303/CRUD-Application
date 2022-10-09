package com.restapp.crudapp.service;

import com.restapp.crudapp.dto.BookResponseDTO;
import com.restapp.crudapp.entity.BookEntity;
import com.restapp.crudapp.dto.BookRequestDTO;
import com.restapp.crudapp.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public BookResponseDTO getBookById(Long id) {
        var optionalResponse =booksRepository.findById(id);
        if(optionalResponse.isPresent()){
            var responseEntity=optionalResponse.get();
            BookResponseDTO response=new BookResponseDTO();
            response.setDescription(responseEntity.getDescription());
            response.setTitle(responseEntity.getTitle());
            return response;
        }
        return  null;
    }

    public List<BookResponseDTO> getAllBook() {
        var responseEntityList=booksRepository.findAll();
        List<BookResponseDTO> response=new ArrayList<>();
        for(BookEntity book: responseEntityList){
            BookResponseDTO dto=new BookResponseDTO();
            dto.setDescription(book.getDescription());
            dto.setTitle(book.getTitle());
            response.add(dto);
        }
        return response;
    }

    public void deleteBookById(Long id) {
        booksRepository.deleteById(id);
    }

    public BookResponseDTO updateBooks(Long id, BookRequestDTO bookRequestDTO) {
        var optionalResponse=booksRepository.findById(id);
        if(optionalResponse.isPresent()){
            BookEntity existingEntity=optionalResponse.get();
            existingEntity.setDescription(bookRequestDTO.getDescription());
            existingEntity.setTitle(bookRequestDTO.getTitle());

            existingEntity=booksRepository.save(existingEntity);

            BookResponseDTO response=new BookResponseDTO();
            response.setDescription(existingEntity.getDescription());
            response.setTitle(existingEntity.getTitle());
            return response;
        }
        return null;
    }

    public BookResponseDTO partialUpdate(Long id, String description) {
        var existingEntity=booksRepository.getOne(id);
        existingEntity.setDescription(description);
        existingEntity=booksRepository.save(existingEntity);
        BookResponseDTO response=new BookResponseDTO();
        response.setDescription(existingEntity.getDescription());
        response.setTitle(existingEntity.getTitle());
        return response;
    }
}
