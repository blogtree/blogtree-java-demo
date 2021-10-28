package org.blogtree.java.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * Java中打印数组
 */
@Slf4j
public class LogArrayTest {

    /**
     * log.info 打印数组
     * 注意：打印二维数组时，需要调用 Arrays.deepToString(array2)
     */
    @Test
    public void testLog() {
        // 一维数组
        int[] array = new int[]{1, 2, 3, 4, 5};
        log.info("array = {}", array);
        log.info("Arrays.toString(array) = {}", Arrays.toString(array));
        // [main] INFO org.blogtree.java.demo.log.LogArrayTest - array = [1, 2, 3, 4, 5]
        // [main] INFO org.blogtree.java.demo.log.LogArrayTest - Arrays.toString(array) = [1, 2, 3, 4, 5]

        // 二维数组
        int[][] array2 = new int[][]{{1, 1, 1}, {2, 2}, {3}};
        log.info("array2 = {}", array2);
        log.info("Arrays.toString(array2) = {}", Arrays.toString(array2));
        log.info("Arrays.deepToString(array2) = {}", Arrays.deepToString(array2));
        // [main] INFO org.blogtree.java.demo.log.LogArrayTest - array2 = [1, 1, 1]
        // [main] INFO org.blogtree.java.demo.log.LogArrayTest - Arrays.toString(array2) = [[I@9660f4e, [I@5a8806ef, [I@6c49835d]
        // [main] INFO org.blogtree.java.demo.log.LogArrayTest - Arrays.deepToString(array2) = [[1, 1, 1], [2, 2], [3]]
    }

    /**
     * System.out.println 打印数组
     * 注意：打印一维数组时，需要调用 Arrays.toString(array1)
     * 注意：打印二维数组时，需要调用 Arrays.deepToString(array2)
     */
    @Test
    public void testSystemOutPrintln() {
        // 一维数组
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(array);
        System.out.println(Arrays.toString(array));
        // [I@1efed156
        // [1, 2, 3, 4, 5]

        // 二维数组
        int[][] array2 = new int[][]{{1, 1, 1}, {2, 2}, {3}};
        System.out.println(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.deepToString(array2));
        // [[I@6737fd8f
        // [[I@72b6cbcc, [I@a7e666, [I@68bbe345]
        // [[1, 1, 1], [2, 2], [3]]
    }
}
