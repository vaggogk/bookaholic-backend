package com.bookaholic.service;

import com.bookaholic.model.User;import com.bookaholic.repository.BookRepository;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class BookService implements IBookService  {


    @Autowired
    private BookRepository bookRepository;



}
