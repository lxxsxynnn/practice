package com.ohgiraffers.association.section01.manytoone;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_menu")
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="CATEGORY_CODE")
    private Category categoryCode; //category의 categoryCode와 연관관계를 가질 수 있게 유형을 Category로 바꿈
    private String orderableStatus;

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public Category getCategory() {
        return categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
