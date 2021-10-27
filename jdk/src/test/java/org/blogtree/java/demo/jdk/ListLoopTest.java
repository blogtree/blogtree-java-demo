package org.blogtree.java.demo.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ListLoopTest {


    public List<Integer> listInit() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }

    @Test
    public void listLoop1() {
        List<Integer> list = listInit();
        for (int i = 0; i < list.size(); i++) {
            log.info("listLoop1, i={}, item={}", i, list.get(i));
        }
    }

    @Test
    public void listLoopByDel1() {
        List<Integer> list = listInit();
        // 此处删除，需要从最后一位 往前删除
        for (int i = list.size() - 1; i >= 0; i--) {
            log.info("listLoopByDel1, i={}, item={}", i, list.get(i));
            list.remove(i);
        }
        log.info("listLoopByDel1, list.size={}", list.size());
    }

    @Test
    public void listLoop2() {
        List<Integer> list = listInit();
        for (Integer item : list) {
            log.info("listLoop2, item={}", item);
        }
    }

    @Test
    public void listLoop3() {
        List<Integer> list = listInit();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            log.info("listLoop3, item={}", item);
        }
    }

    @Test
    public void listLoopByDel3() {
        List<Integer> list = listInit();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            log.info("listLoopByDel3, item={}", item);
            // 此处删除必须使用 iterator.remove()
            iterator.remove();
        }
        log.info("listLoopByDel3, list.size={}", list.size());
    }

}
