package ch.blelo.kanjiguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KanjiguideApplication {
    public static void main(String[] args) {
        SpringApplication.run(KanjiguideApplication.class, args);
    }
}
