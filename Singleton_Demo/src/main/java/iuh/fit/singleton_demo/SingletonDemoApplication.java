package iuh.fit.singleton_demo;

import iuh.fit.singleton_demo.singleton.AppLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonDemoApplication {

    public static void main(String[] args) {
        AppLogger logger1 = AppLogger.getInstance();
        AppLogger logger2 = AppLogger.getInstance();

        logger1.log("First log");
        logger2.log("Second log");
        SpringApplication.run(SingletonDemoApplication.class, args);
    }

}
