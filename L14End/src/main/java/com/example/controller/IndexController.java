package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页
 */

@Controller
public class IndexController extends BaseController {

    @RequestMapping("/main")
    public String main(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "main";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "index";
    }

    @RequestMapping("")
    public String index1(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "index";
    }
}
