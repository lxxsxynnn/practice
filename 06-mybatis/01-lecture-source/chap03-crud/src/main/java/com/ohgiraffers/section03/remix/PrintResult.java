package com.ohgiraffers.section03.remix;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<com.ohgiraffers.section03.remix.MenuDTO> menuList) {

        menuList.forEach(System.out::println);

    }

    public void printErrorMessage(String msg) {
        String erroerMessage = "";
        switch (msg) {
            case "findAll": erroerMessage = "Unable to find MenuList"; break;
            case "findOne": erroerMessage = "Unable to find Menu"; break;
            case "insert": erroerMessage = "Unable to insert Menu"; break;
            case "update": erroerMessage = "Unable to update Menu"; break;
            case "delete": erroerMessage = "Unable to delete Menu"; break;
        }

        System.out.println(erroerMessage);
    }

    public void printMenu(MenuDTO menu) {

        System.out.println(menu);
    }

    public void printSuccessMessage(String msg) {

        String successMessage = "";
        switch (msg) {
            case "insert": successMessage = "New Menu has been Successfully Registerd"; break;
            case "update": successMessage = "The Menu has been Successfully Updated"; break;
            case "delete": successMessage = "The Menu has been Successfully Deleted"; break;
        }
    }
}
