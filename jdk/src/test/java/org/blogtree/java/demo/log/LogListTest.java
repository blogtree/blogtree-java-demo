package org.blogtree.java.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Java中打印列表
 */
@Slf4j
public class LogListTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        log.info("list = {}", list);
        // [main] INFO org.blogtree.java.demo.log.LogListTest - list = [1, 2, 3, 4, 5]
    }
}
