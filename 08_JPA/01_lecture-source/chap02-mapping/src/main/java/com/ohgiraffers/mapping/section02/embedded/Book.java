package com.ohgiraffers.mapping.section02.embeded;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @Column(name="BOOK_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookNo;

    @Column(name="BOOK_TITLE")
    private String bookTitle;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="PUBLISHER")
    private String publisher;

    @Column(name="PUBLISHED_DATE")
    private String publishedDate;

    //아래 세 개는 의미상 가격으로 묶을 수 있음
    //가격 영역에 음수가 들어가지 않게 Custom Price Type 설정
    //    @Column(name="REGULAR_PRICE")
    //    private int regularPrice;
    //
    //    @Column(name="DISCOUNT_RATE")
    //    private double discountRate;
    //
    //    @Column(name="SELL_PRICE")
    //    private int sellPrice;

    @Embedded
    private Price price;
}
