package org.blogtree.java.demo.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

@Slf4j
public class BatchInsertTest {

    private final MySQLConfig mySQLConfig = new MySQLConfig();

    @Test
    public void test() {

        String sql = "insert into user(name, age, create_time) values(?, ?, ?)";

        Random random = new Random();

        try (Connection connection = mySQLConfig.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                for (int i = 1; i <= 1000000; i++) {
                    ps.setString(1, "test" + i);
                    ps.setInt(2, random.nextInt(100));
                    ps.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
                    ps.addBatch();// 添加到batch中
                }
                // 执行batch
                int[] countArr = ps.executeBatch();
                log.info("countArr={}", countArr);
            }

        } catch (SQLException e) {
            log.error("test-SQLException,", e);
        } catch (Exception e) {
            log.error("test-Exception,", e);
        }
    }
}
