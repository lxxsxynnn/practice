package com.ohgiraffers.menu.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //서블릿의 역할
        //1. 요청 받은 값 확인 및 검증
        //2. 비즈니스 로직 처리 (Application Service 쪽의 메소드 호출)
        //3. 응답 페이지 생성 후 응답(jsp forward)

        //1
        String menuName = req.getParameter("menuName");
        int amount = Integer.parseInt(req.getParameter("amount"));

        //2
        int orderPrice = 0;
        switch (menuName) {
            case "햄버거" : orderPrice = 6000 * amount; break;
            case "짜장면" : orderPrice = 7000 * amount; break;
            case "짬뽕" : orderPrice = 8000 * amount; break;
            case "순댓국" : orderPrice = 9000 * amount; break;
        }

        //3
        req.setAttribute("orderPrice", orderPrice);
        req.setAttribute("menuName", menuName);
        req.setAttribute("amount", amount);

        //서블릿 컨테이너 내부에서는 /root가 적용된 상태
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(req, resp);

    }
}
