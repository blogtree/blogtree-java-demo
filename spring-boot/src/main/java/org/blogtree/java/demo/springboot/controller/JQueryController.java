package org.blogtree.java.demo.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.java.demo.springboot.bean.jquery.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("jQuery")
public class JQueryController {

    @RequestMapping("")
    public String jQueryPage(Model model) {
        model.addAttribute("title", "jQuery Test");
        return "jquery/jQueryPage";
    }

    @PostMapping("postBean")
    public void postBean(@RequestBody PostBeanListDto bean) {
        log.info("bean={}", bean);
    }

    @PostMapping("postIntegerList")
    public void postIntegerList(@RequestBody List<Integer> list) {
        log.info("list={}", list);
    }

    @PostMapping("postBeanList")
    public void postBeanList(@RequestBody List<PostBeanListDto> list) {
        log.info("list={}", list);
    }
}
