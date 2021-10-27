package org.blogtree.java.demo.idea;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class MapLoopIdeaHotKeyTest {

    /**
     * 列表初始化
     */
    public Map<Integer, String> initMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Name1");
        map.put(2, "Name2");
        map.put(3, "Name3");
        return map;
    }

    /**
     * 在 map.entrySet() 末尾，按Alt + Enter，选择 Iterate
     */
    @Test
    public void testHotKey() {
        Map<Integer, String> map = initMap();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {

        }
    }

}
