package iuh.fit.singleton_demo.singleton;

import java.time.LocalDateTime;

public class AppLogger {
    private static final AppLogger instance = new AppLogger();

    private AppLogger() {
    }

    public static AppLogger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println(LocalDateTime.now() + " [LOG] " + message);
    }
}
