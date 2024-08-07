package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//!라이프사이클이 같을 경우를 제외하고는
//한 패키지에는 한 엔티티만 생성할 것!

//부득이하게 두 개 이상의 엔티티를 만들 경우
//하나를 Root Entity로 설정해줘야 함
@Entity
@Table(name="tbl_order_menu")
public class OrderMenu {

    @EmbeddedId
    private OrderMenuPk orderMenuPk;

    @Column(name="ORDER_AMOUNT")
    private int orderAmount;

    public OrderMenu() {}

    public OrderMenu(OrderMenuPk orderMenuPk, int orderAmount) {
        this.orderMenuPk = orderMenuPk;
        this.orderAmount = orderAmount;
    }

    public OrderMenuPk getOrderMenuPk() {
        return orderMenuPk;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderMenuPk=" + orderMenuPk +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
