package ch.blelo.jpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpapiApplication.class, args);
    }
}
