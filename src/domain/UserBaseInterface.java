import java.util.Map;

public interface UserBaseInterface {
    Map<String, User> loadUsers();
    void saveUsers(Map<String, User> users);
    User findUserByEmail(String email);
    void addUser(User user);
    void updateUser(User user);
}
