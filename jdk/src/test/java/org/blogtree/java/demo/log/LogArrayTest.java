package org.blogtree.java.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class LogArrayTest {

    @Test
    public void testLog() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        log.info("array = {}", array);
        log.info("Arrays.toString(array) = {}", Arrays.toString(array));
        // [main] INFO org.blogtree.java.demo.log.LogArrayTest - array = [1, 2, 3, 4, 5]
        // [main] INFO org.blogtree.java.demo.log.LogArrayTest - Arrays.toString(array) = [1, 2, 3, 4, 5]
    }

    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(array);
        System.out.println(Arrays.toString(array));
        // [I@1efed156
        // [1, 2, 3, 4, 5]
    }
}
