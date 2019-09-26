package example.controller;

import example.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by CQU-CST-WuErli on 2017/3/2 at 15:12.
 * Description :
 * Copyright (c) 2017 CQU_CST_WuErli. All rights reserved.
 */

@Controller
@RequestMapping("/home")
public class IndexController {

    @Resource
    private IndexService indexService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index" ;
    }

    @GetMapping("/sayHello")
    public String sayHello(String message) {
        return indexService.sayHello(message);
    }

    @GetMapping("/sum")
    public int sum(int a, int b) {
        return indexService.sum(a, b);
    }

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String test() {
        return indexService.test();
    }
}
