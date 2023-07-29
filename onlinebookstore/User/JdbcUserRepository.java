import java.util.HashMap;
import java.util.Map;

public class JdbcUserRepository implements UserRepository {
    private final Map<String, User> usersMap = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public User save(User user) {
        if (user.getUserId() == null) {
            user.setUserId(nextId);
            nextId++;
        }
        usersMap.put(user.getUsername(), user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return usersMap.get(username);
    }

    @Override
    public User findByEmail(String email) {
        return usersMap.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
