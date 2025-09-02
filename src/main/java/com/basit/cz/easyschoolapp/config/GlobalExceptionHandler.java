package com.basit.cz.easyschoolapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception ex, Model model) {
         ModelAndView mav = new ModelAndView();
         mav.addObject("exception", ex);
         mav.setViewName("error");
         return mav;
    }
}
