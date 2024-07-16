package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

    @Controller
    @RequestMapping("/first/*")
    @SessionAttributes("id")
    public class FirstController {

        // /first/regist 요청이 들어오면
        // void 메소드인 경우 요청 주소가 곧 view의 이름이 됨
        // return "/first/regist" 를 작성하는 것과 동일
        @GetMapping("regist")
        public void regist(){}


        /* 1. WebRequest로 Request Parameter 전달받기
        * dispatcherServlet이 Model 객체 생성
        * */
        @PostMapping("regist")
        public String registMenu(Model model, WebRequest request){

            String menuName = request.getParameter("menuName");
            int menuPrice = Integer.parseInt(request.getParameter("menuPrice"));
            int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

            String message = menuName + "has successfully registered in new Menu List - CategoryCode : " + categoryCode + " and MenuPrice : " + menuPrice;

            model.addAttribute("message", message);

            return "first/messagePrinter";
        }

        @GetMapping("modify")
        public void modity(){}

        @PostMapping("modify")
        public String modifyMenuPrice(Model model
                                    , @RequestParam /*(required=false)*/ String modifiedName
                                    , @RequestParam(defaultValue = "0") int modifiedPrice){

            System.out.println("ModifiedName = " + modifiedName);
            System.out.println("ModifiedNPrice = " + modifiedPrice);

            String message = modifiedName + "'s price has been modified to " + modifiedPrice;

            model.addAttribute("message", message);

            return "first/messagePrinter";
        }

        @PostMapping("modifyAll")
        public String modifyAllMenuPrice(Model model, @RequestParam Map<String, String> parameters){

            String modifiedName = parameters.get("modifiedName2");
            int modifiedPrice = Integer.parseInt(parameters.get("modifiedPrice2"));

            String message = "Name of the menu has been modified to " + modifiedName + " and price has been modified to " + modifiedPrice;

            model.addAttribute("message", message);

            return "first/messagePrinter";
        }

        @GetMapping("search")
        public void search(){}

        @PostMapping("search")
        public String searchMenu(MenuDTO menu){

            System.out.println(menu);

            return "first/searchResult";
        }

        @GetMapping("login")
        public void login(){}

        @PostMapping("login1")
        public String sessionTest1(HttpSession session, @RequestParam String id){

            session.setAttribute("id", id);

            return "first/loginResult";
        }

        @GetMapping("logout1")
        public String logoutTest1(HttpSession session){
//            session.removeAttribute("id"); //세션에 저장된 아이디 값 제거
//            session.setMaxInactiveInterval(600); //일정 시간이 지나면 세션 만료되도록 설정
            session.invalidate(); //세션 강제 종료

            return "first/loginResult";
        }

        @PostMapping("login2")
        public String sessionTest2(Model model, @RequestParam String id){

            model.addAttribute("id", id);

            return "first/loginResult";
        }

        @GetMapping("logout2")
        public String logoutTest2(SessionStatus status){

            status.setComplete(); //invalidate session

            return "first/loginResult";
        }

        @GetMapping("body")
        public void body(){}

        @PostMapping("body")
        public void bodyTest(@RequestBody String body
                            , @RequestHeader("content-type") String contentType
                            , @CookieValue(value = "JSESSIONID", required = false) String sessionId) throws UnsupportedEncodingException {

            System.out.println(URLDecoder.decode(body, "UTF-8"));
            System.out.println(contentType);
            System.out.println(sessionId);
        }
    }
