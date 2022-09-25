package com.newlecture.kwonjoosung.springbootprac2.controller;

import com.newlecture.kwonjoosung.springbootprac2.dto.HelloResponseDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

@GetMapping("/hello")
public String hello() {
    return "hello";
}

@GetMapping("/hello2")
public String hello2(@Param("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello2";
}
@GetMapping("/hello3")
public HelloResponseDto hello3(@RequestParam("name") String name, @RequestParam("amount") int amount) {
    return new HelloResponseDto(name,amount);

}


}
