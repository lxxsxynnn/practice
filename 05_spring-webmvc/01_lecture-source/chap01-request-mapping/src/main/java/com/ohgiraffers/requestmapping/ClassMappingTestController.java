package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*") //Class에 url 요청할 때는 RequestMapping을 사용
public class ClassMappingTestController {

    // /order/regist로 매핑한 것과 동일
    @GetMapping("/regist")
    public String registOrder(Model model) {

        model.addAttribute("message", "Call Regist Order Handler Method by GET Method");
        return "mappingResult";
    }

    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.GET)
    public String modifyAndDelete(Model model) {

        model.addAttribute("message", "Call Modify and Delete Order Handler Method by GET Method");

        return "mappingResult";
    }

    // /order/detail/3 에서 3과 같이 주소에 값을 같이 전달하는 걸 PathVariable이라고 함
    // @PathVariable("") 안의 이름과 url 매핑 내 {} 안의 값이 같아야 함
    @GetMapping("/detail/{orderNo}")
    public String detail(Model model, @PathVariable("orderNo") int orderNo) {

        model.addAttribute("message", "Call Show Order Details Handler Method of OrderNo. " +orderNo);

        return "mappingResult";
    }

    @RequestMapping
    public String otherRequest(Model model) {

        model.addAttribute("message", "It's also a order request, but other function isn't ready yet");

        return "mappingResult";
    }
}
