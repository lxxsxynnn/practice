package com.ohgiraffers.mapping.section02.embedded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRegisterService {

    private BookRepository bookRepository;

    @Autowired
    public BookRegisterService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void registerBook(BookRegistRequestDTO bookInfo) {

        Book book = new Book(
                bookInfo.getBookTitle(),
                bookInfo.getAuthor(),
                bookInfo.getPublisher(),
                bookInfo.getPublishedDate(),
                new Price(
                        bookInfo.getRegularPrice(),
                        bookInfo.getDiscountRate()
                )
        );

        bookRepository.save(book);
    }
}
