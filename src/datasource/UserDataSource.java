import java.util.*;

public class UserDataSource implements UserBaseInterface {
    private final String filePath;

    public UserDataSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Map<String, User> loadUsers() {
        return new HashMap<>();
    }

    @Override
    public void saveUsers(Map<String, User> users) {
        
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void addUser(User user) {
        
    }

    @Override
    public void updateUser(User user) {
        
    }
}
