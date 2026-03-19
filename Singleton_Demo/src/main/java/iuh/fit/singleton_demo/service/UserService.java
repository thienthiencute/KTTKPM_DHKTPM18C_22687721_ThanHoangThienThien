package iuh.fit.singleton_demo.service;

import org.springframework.stereotype.Service;
import iuh.fit.singleton_demo.singleton.AppLogger;

@Service
public class UserService {
    public String createUser(String name) {
        AppLogger.getInstance().log("Creating user: " + name);
        return "User created: " + name;
    }
}
