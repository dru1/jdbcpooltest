package at.dru.jdbcpooltest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * to generate web.xml and configuration for the servlet container
 */
public class SpringBootWicketInitializer extends SpringBootServletInitializer {

    @Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
        return application.sources(WicketWebApplication.class);
    }

}
