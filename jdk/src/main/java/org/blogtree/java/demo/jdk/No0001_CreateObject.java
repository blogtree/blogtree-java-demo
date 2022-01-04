package org.blogtree.java.demo.jdk;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.java.demo.jdk.bean.UserVo;

import java.io.*;

@Slf4j
public class No0001_CreateObject {

    public static void main(String[] args) {
        // 方式1：通过 new
        UserVo user1 = new UserVo();
        user1.setId(1);
        user1.setName("name_1");
        log.info("user1={}", user1);

        // 方法2：通过 反射
        try {
            UserVo user2 = UserVo.class.newInstance();
            user2.setId(2);
            user2.setName("name_2");
            log.info("user2={}", user2);
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("user2-create-error", e);
        }

        // 方法3：通过 clone()
        UserVo user3 = user1.clone();
        log.info("user3={}", user3);
        user3.setId(3);
        user3.setName("name_3");
        log.info("user1={}", user1);
        log.info("user3={}", user3);


        // 方法4：通过 反序列化
        // file地址
        String filePath = "jdk/src/file/No0001_CreateObject/UserVo.txt";
        // 将数据写入file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(new UserVo(4, "name_4"));
        } catch (Exception e) {
            log.error("user4-create-error-outputStream", e);
        }
        // 从file读取数据
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            UserVo user4 = (UserVo) inputStream.readObject();
            log.info("user4={}", user4);
        } catch (IOException | ClassNotFoundException e) {
            log.error("user4-create-error-inputStream", e);
        }
    }
}
