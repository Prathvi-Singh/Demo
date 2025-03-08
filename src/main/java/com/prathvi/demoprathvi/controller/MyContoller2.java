//package com.prathvi.demoprathvi.controller;
//import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//
//
//@Controller
//public class MyContoller2{
//
//    @GetMapping("/index")
//    public String index(Model model){
//
//        System.out.println("Inside about index");
//        model.addAttribute("name" ,"Prathvi Singh");
//        String [] a= {"ashu","arzoo","ashi","hamu bhaiya","check bhaiya"};
//        int [] b={1,2,3,4,5};
//      //  model.addAttribute("names" , Arrays.toString(a));
//        model.addAttribute("names" , a);
//        model.addAttribute("gender","M");
//        model.addAttribute("myList", b);
//        return "index";
//
//    }
//}
