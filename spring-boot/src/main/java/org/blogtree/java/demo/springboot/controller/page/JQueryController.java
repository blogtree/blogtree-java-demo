package org.blogtree.java.demo.springboot.controller.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("jQuery")
public class JQueryController {

    @RequestMapping("")
    public String jQueryPage(Model model) {
        model.addAttribute("title", "jQuery Test");
        return "jquery/jQueryPage";
    }
}
