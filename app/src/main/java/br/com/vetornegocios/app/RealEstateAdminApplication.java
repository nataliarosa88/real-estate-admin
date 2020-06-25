package br.com.vetornegocios.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RealEstateAdminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RealEstateAdminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RealEstateAdminApplication.class);
    }
}
