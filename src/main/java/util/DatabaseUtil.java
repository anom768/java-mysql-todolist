package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/java_mysql_todolist");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setMaxLifetime(36000);
        config.setIdleTimeout(60000);

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }

}
