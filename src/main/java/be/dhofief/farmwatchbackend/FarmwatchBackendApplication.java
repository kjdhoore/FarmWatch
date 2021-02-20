package be.dhofief.farmwatchbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "be.dhofief")
@EnableJpaRepositories
public class FarmwatchBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmwatchBackendApplication.class, args);
    }

}
