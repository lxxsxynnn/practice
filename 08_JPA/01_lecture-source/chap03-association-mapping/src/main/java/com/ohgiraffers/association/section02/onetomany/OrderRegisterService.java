package com.ohgiraffers.association.section02.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderRegisterService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderRegisterService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void registerOrder(List<OrderMenuDTO> orderInfo) {

        List<OrderMenu> orderMenus = orderInfo.stream()
                .map(orderDetail -> new OrderMenu(new OrderMenuPk(0, orderDetail.getMenuCode()), orderDetail.getOrderAmount()))
                .collect(Collectors.toUnmodifiableList());

        Order order = new Order(
                LocalDate.now(),
                LocalTime.now(),
                95000,
                orderMenus
        );
        //stream 생성 -> 연산 -> 취합

        orderRepository.save(order);
    }
}
