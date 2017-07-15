package microtan65.pizza;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.embedded.RedisServer;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }
}