package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="tbl_order")
public class Order {

    @Id
    @Column(name="ORDER_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderCode;


    //type을 String으로 한 이유, Date와 Time을 분리한 이유?
    //집계를 하기 위해서
    //오늘 들어온 주문에 대해서 조회를 한다면 오늘 00시 00분~23시 59분의 범위에 해당하는 값을 찾아야 함
    //String을 사용하면 일치하는 값을 조회하기 때문에 편의성을 위해 String으로 설정 + 일자와 시간을 분리함
    @Column(name="ORDER_DATE")
    private String orderDate;

    @Column(name="ORDER_TIME")
    private String orderTime;

    @Column(name="TOTAL_ORDER_PRICE")
    private int totalOrderPrice;

    @OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="ORDER_CODE", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<OrderMenu> orderMenus;

    public Order(){}

    public Order(LocalDate orderDate, LocalTime orderTime,
                 int totalOrderPrice, List<OrderMenu> orderMenus) {

        this.orderDate = orderDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.orderTime = orderTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.totalOrderPrice = totalOrderPrice;
        this.orderMenus = orderMenus;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", totalOrderPrice=" + totalOrderPrice +
                ", orderMenus=" + orderMenus +
                '}';
    }
}
