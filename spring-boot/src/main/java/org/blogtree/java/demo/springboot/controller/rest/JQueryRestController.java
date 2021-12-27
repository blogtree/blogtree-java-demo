package org.blogtree.java.demo.springboot.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.java.demo.springboot.bean.jquery.PostBeanListDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("jQuery")
public class JQueryRestController {

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
