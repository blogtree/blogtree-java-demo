package org.blogtree.java.demo.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ListLoopTest {

    /**
     * 列表初始化
     */
    public List<Integer> listInit() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }

    /**
     * 方式1：普通for循环遍历（有列表索引）
     * <p>
     * 优点：遍历过程中，有索引，可方便定位、取值和赋值。
     * 缺点：如果只是遍历取值，不如增强for循环简洁。
     * 修改：支持
     * 删除：支持（但需要从后往前遍历，才能删除干净）
     */
    @Test
    public void listLoop1() {
        // 遍历
        List<Integer> list = listInit();
        for (int i = 0; i < list.size(); i++) {
            log.info("listLoop1, i={}, item={}", i, list.get(i));
            // 此处修改，生效
            list.set(i, list.get(i) + 10);
        }

        // 验证修改
        for (int i = 0; i < list.size(); i++) {
            log.warn("listLoop1-modify, i={}, item={}", i, list.get(i));
        }

        // 遍历并删除
        // 注意：此处删除，需要从最后一位 往前删除
        for (int i = list.size() - 1; i >= 0; i--) {
            log.info("listLoop1-del, i={}, item={}", i, list.get(i));
            list.remove(i);
        }
        log.info("listLoop-del, list.size={}", list.size());
    }

    /**
     * 方式2：增强for循环遍历（没有列表索引）
     * <p>
     * 优点：代码简洁
     * 缺点：遍历过程中，没有索引
     * 修改：不支持
     * 删除：不支持
     */
    @Test
    public void listLoop2() {
        // 遍历
        List<Integer> list = listInit();
        for (Integer item : list) {
            log.info("listLoop2, item={}", item);
            // 此处修改，不会生效
            item += 10;
        }

        // 验证修改
        for (Integer item : list) {
            log.info("listLoop2-modify, item={}", item);
        }

        // 验证删除
        try {
            for (Integer item : list) {
                list.remove(item);
            }
        } catch (Exception e) {
            log.error("listLoop2-del", e);
        }
        log.info("listLoop2-del, list.size={}", list.size());
    }

    /**
     * 方式3：迭代器遍历
     * <p>
     * 优点：正序遍历过程中，可以删除元素
     * 缺点：遍历过程中，没有索引、不能修改（删除需要调用 iterator.remove()）
     * 修改：不支持
     * 删除：支持（需要调用 iterator.remove()，不能使用 list.remove(item)）
     */
    @Test
    public void listLoop3() {
        // 遍历
        List<Integer> list = listInit();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            log.info("listLoop3, item={}", item);
            // 此处修改，不会生效
            item += 10;
        }

        // 验证修改
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            log.info("listLoop3-modify, item={}", item);
        }

        // 遍历并删除
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            log.info("listLoop3-del, item={}", item);
            // 此处删除必须使用 iterator.remove()
            iterator.remove();
        }
        log.info("listLoop3-del, list.size={}", list.size());
    }

    /**
     * 方式4：forEach遍历
     * <p>
     * 优点：代码简洁
     * 缺点：遍历过程中，没有索引
     * 修改：不支持
     * 删除：不支持
     */
    @Test
    public void listLoop4() {
        // 遍历
        List<Integer> list = listInit();
        list.forEach(item -> {
            log.info("listLoop4, item={}", item);
            // 此处修改，不会生效
            item += 10;
        });

        // 验证修改
        list.forEach(item -> {
            log.info("listLoop4, item={}", item);
        });

        // 验证删除
        try {
            list.forEach(item -> {
                list.remove(item);
            });
        } catch (Exception e) {
            log.error("listLoop4-del", e);
        }
        log.info("listLoop4-del, list.size={}", list.size());
    }
}
