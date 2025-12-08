public class Credentials {
    private final String email;
    private final String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean validate() {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
