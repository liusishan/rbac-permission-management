package com.king.ssmstudent.controller;

import com.king.ssmstudent.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/classes")
public class ClassesContrller {
    @Autowired
    private ClassesService classesService;
    //查询报表的方法
    @RequestMapping("/index")
    public String index(Model model){
        //查询的报表
        classesService.queryClassesChart();
        model.addAttribute("chartList",classesService.queryClassesChart());
        return "classes/chart";
    }

}
