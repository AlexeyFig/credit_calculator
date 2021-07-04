package com.credit_calculator.credit_calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

        @GetMapping("/")
        public String main(Model model) {

            return "main-page";
        }

}
