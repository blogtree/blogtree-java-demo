package org.blogtree.java.demo.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class MySQLConfig {

    /**
     * 数据库连接
     */
    private final String JDBC_URL = "jdbc:mysql://127.0.0.1:3006/test_db?rewriteBatchedStatement=true";

    /**
     * 数据库用户名
     */
    private final String JDBC_USER = "test_user";

    /**
     * 数据库密码
     */
    private final String JDBC_PASSWORD = "test_123456";

    /**
     * 获取数据库连接
     * <p>
     * 注意：使用后，需要主动释放
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            return connection;
        } catch (Exception e) {
            log.error("getConnection", e);
            return null;
        }
    }
}
