package be.thomasmore.qrace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("be.thomasmore.qrace")
@EntityScan("be.thomasmore.qrace")
public class QraceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QraceApplication.class, args);
    }
}