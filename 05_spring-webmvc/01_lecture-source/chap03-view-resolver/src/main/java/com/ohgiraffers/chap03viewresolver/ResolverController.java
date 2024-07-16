package com.ohgiraffers.chap03viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {

        model.addAttribute("forwardMessage", "Returned View Name as String");

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(){

        return "redirect:/"; //리다이렉트 방식으로 보내게 됨
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectAttr(RedirectAttributes rttr){

        rttr.addFlashAttribute("flashMessage1", "Redirection Using Redirect attr");

        return "redirect:/";
    }


    //Model + View (Model은 단독으로 사용 가능하지만 View는 불가)
    @GetMapping("modelandview")
    public ModelAndView modelAndViewReturning(ModelAndView mnv) {
        mnv.addObject("forwardMessage", "Returned Modal and View by Using ModelAndView");
        mnv.setViewName("result");

        return mnv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mnv){

        mnv.setViewName("redirect:/");

        return mnv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirectAttr(ModelAndView mnv, RedirectAttributes rttr){

        rttr.addFlashAttribute("flashMessage2", "Redirect attr Using ModelAndView");
        mnv.setViewName("redirect:/");

        return mnv;
    }
}
