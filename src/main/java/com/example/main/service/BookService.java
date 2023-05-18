package com.example.main.service;

import com.example.main.entity.BookEntity;
import com.example.main.model.BookRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    //Book Creation Implementation
    ResponseEntity<Object> create (BookRequestModel bookModel);
    ResponseEntity<Object> update (String bookID, BookRequestModel updatedBookModel);
    void delete (String bookID);
    //    ResponseEntity<Object> findById (String bookID);
    List<BookEntity> getAllBooks ();

    BookEntity getBookByID(String bookID);

    List<BookEntity> getBookByAuthorNameAndBookName(String authorName, String bookName);

    List<BookEntity> getBookByAuthorName(String authorName);
}
