package com.ohgiraffers.requestmapping;

import jakarta.servlet.http.HttpServletRequest; //Servlet에 의존하게 됨 -> 이를 해소하기 위해 Model을 사용
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; //WebServlet 대신 url 매핑할 수 있게 하는 기능
import org.springframework.web.bind.annotation.RequestMethod;
//이렇게 Servlet을 사용하는 걸 감춰서 의존성을 낮추는 걸 PSA라고 함

@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist")
    public String menuRegist(Model model) {

        //Model에 값을 담을 때는 addAttribute() 메소드를 사용함
        model.addAttribute("message", "Call Menu Register Handler Method by GET Method");

        return "mappingResult";
        // templates/mappingResult.html -> Thymleaf View Resolver가 바꿔줘서 파일을 찾아서 열 수 있게 함
    }

    //Method를 명시하면 해당 메소드로 온 요청만 허용하겠다는 의미
    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String menuModify(Model model) {

        model.addAttribute("message", "Call Menu Modify Handler Method by GET Method");

        return "mappingResult";
    }

    //요청 메소드 전용 어노테이션
    /* 요청 메소드       어노테이션
    *  POST           @PostMapping
    *  GET            @GetMapping
    *  PUT            @GetMapping
    *  DELETE         @DeleteMapping
    *  PATCH          @PatchMapping
    * */

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {

        model.addAttribute("message", "Call Menu Delete Method by GET Method");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {

        model.addAttribute("message", "Call Menu Delete Method by POST Method");

        return "mappingResult";
    }
}
