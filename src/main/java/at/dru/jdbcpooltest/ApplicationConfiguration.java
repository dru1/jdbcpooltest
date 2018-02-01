package at.dru.jdbcpooltest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public DataSource dataSource() {
        // Examines both filesystem and classpath for .properties file
        HikariConfig config = new HikariConfig("/hikari.properties");
        return new HikariDataSource(config);
    }
}

