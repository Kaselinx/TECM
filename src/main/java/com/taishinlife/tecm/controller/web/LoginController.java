package com.taishinlife.tecm.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/hello")
    public String hello(Model model) {
    	model.addAttribute("hello", "Hello World!!!"); // （變數名稱，變數值
        return "hello"; // 要導入的html
    } 
    
	@GetMapping("/addMemberPage")
    public String addMemberPage(){
        return "addMemberPage";
    }
}
