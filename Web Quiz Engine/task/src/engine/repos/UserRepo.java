package engine.repos;

import org.springframework.stereotype.Component;
import engine.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRepo {
    final private Map<String, User> users = new ConcurrentHashMap<>();

    public User findUserByUsername(String username) {
        return users.get(username);
    }

    public void save(User user) {
        users.put(user.getEmail(), user);
    }
}
