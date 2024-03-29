package com.curso.libraryapi.service.impl;

import com.curso.libraryapi.api.model.entity.Book;
import com.curso.libraryapi.api.model.repository.BookRepository;
import com.curso.libraryapi.exception.BusinessException;
import com.curso.libraryapi.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        if (repository.existsByIsbn(book.getIsbn())){
            throw new BusinessException("Isbn já cadastrado");
        }
        return repository.save(book);
    }
}
