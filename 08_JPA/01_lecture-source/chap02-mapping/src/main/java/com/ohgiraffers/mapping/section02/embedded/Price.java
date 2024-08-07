package com.ohgiraffers.mapping.section02.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Price {

    @Column(name="REGULAR_PRICE")
    private int regularPrice;

    @Column(name="DISCOUNT_RATE")
    private double discountRate;

    @Column(name="SELL_PRICE")
    private int sellPrice;
}
