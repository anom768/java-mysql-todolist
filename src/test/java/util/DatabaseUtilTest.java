package util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtilTest {
    
    @Test
    void testConnection() throws SQLException {
        HikariDataSource hikariDataSource = DatabaseUtil.getDataSource();
        Connection connection = hikariDataSource.getConnection();

        connection.close();
        hikariDataSource.close();
    }

}
