package be.thomasmore.qrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class QraceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QraceApplication.class, args);
    }
}
