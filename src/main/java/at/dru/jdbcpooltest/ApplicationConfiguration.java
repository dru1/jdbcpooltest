package at.dru.jdbcpooltest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    private static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";

    @Bean
    public DataSource dataSource() {
        loadJDBCDriver();
        // Examines both filesystem and classpath for .properties file
        HikariConfig config = new HikariConfig("/hikari.properties");
        return new HikariDataSource(config);
    }

    /**
     * For Tomcat Deployment...
     */
    private void loadJDBCDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load driver");
        }
    }
}

