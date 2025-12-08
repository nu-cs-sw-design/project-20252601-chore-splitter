public class AuthenticationManager {
    private final UserBaseInterface userRepository;

    public AuthenticationManager(UserBaseInterface userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(String email, String password) {
        User u = userRepository.findUserByEmail(email);
        if (u != null && u.password.equals(password)) return u; // simple stub
        return null;
    }

    public User signUp(String email, String password, String name) {
        if (!validateCredentials(email, password)) return null;
        if (userRepository.findUserByEmail(email) != null) return null;
        User u = new User(email, password, name);
        userRepository.addUser(u);
        return u;
    }

    public boolean validateCredentials(String email, String password) {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }

    @SuppressWarnings("unused")
    private String hashPassword(String password) { return password; }

    @SuppressWarnings("unused")
    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        return plainPassword != null && plainPassword.equals(hashedPassword);
    }
}
