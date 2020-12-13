package org.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 基本的 index 页面
     */
    @RequestMapping("index")
    public String index0() {
        // 不使用 ResponseBody 注解时，默认返回字符串是逻辑视图名
        return "index0";
    }

    /**
     * 演示 PathVariable 使用
     */
    @RequestMapping("index/{num}")
    public String index(@PathVariable("num") String num) {
        // 不使用 ResponseBody 注解时，默认返回字符串是逻辑视图名
        return "index" + num;
    }

}
