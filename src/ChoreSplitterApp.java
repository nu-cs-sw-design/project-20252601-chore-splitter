import java.util.*;
import java.io.*;


public class ChoreSplitterApp {

    // Global data storage - messy but functional
    public static Map<String, User> users = new HashMap<>();
    public static Map<String, Household> households = new HashMap<>();
    public static User currentUser = null;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load data from files
        loadData();

        // UC1: Start the App
        startApp();
    }


    public static void startApp() {
        System.out.println("=====================================");
        System.out.println("  Welcome to Chore Splitter!");
        System.out.println("=====================================");
        System.out.println();

        // Display authentication screen
        showAuthenticationScreen();
    }


    public static void showAuthenticationScreen() {
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Log In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1-3): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    login();
                    if (currentUser != null) {
                        showMainScreen();
                    }
                    break;
                case "2":
                    signUp();
                    if (currentUser != null) {
                        showMainScreen();
                    }
                    break;
                case "3":
                    System.out.println("Thank you for using Chore Splitter. Goodbye!");
                    saveData();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void login() {
        System.out.println("\n--- LOG IN ---");

        String email = "";
        String password = "";

        // Get credentials
        while (email.isEmpty()) {
            System.out.print("Email/Username: ");
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty. Please try again.");
            }
        }

        while (password.isEmpty()) {
            System.out.print("Password: ");
            password = scanner.nextLine().trim();
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty. Please try again.");
            }
        }

        // Validate credentials
        if (users.containsKey(email)) {
            User user = users.get(email);
            if (user.password.equals(password)) {
                currentUser = user;
                System.out.println("\nLogin successful! Welcome, " + user.name + "!");
                return;
            }
        }

        // Login failed
        System.out.println("\nLogin failed. Invalid email or password.");
        System.out.print("Would you like to try again? (y/n): ");
        String retry = scanner.nextLine().trim().toLowerCase();
        if (retry.equals("y") || retry.equals("yes")) {
            login();
        } else {
            System.out.print("Would you like to sign up instead? (y/n): ");
            String signUpChoice = scanner.nextLine().trim().toLowerCase();
            if (signUpChoice.equals("y") || signUpChoice.equals("yes")) {
                signUp();
            }
        }
    }


    public static void signUp() {
        System.out.println("\n--- SIGN UP ---");

        String email = "";
        String password = "";
        String name = "";

        // Get user details
        while (email.isEmpty()) {
            System.out.print("Email/Username: ");
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty. Please try again.");
            } else if (users.containsKey(email)) {
                System.out.println("Email already exists. Please use a different email.");
                email = "";
            }
        }

        while (password.isEmpty()) {
            System.out.print("Password: ");
            password = scanner.nextLine().trim();
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty. Please try again.");
            }
        }

        while (name.isEmpty()) {
            System.out.print("Full Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            }
        }

        // Create new user
        User newUser = new User(email, password, name);
        users.put(email, newUser);
        currentUser = newUser;

        System.out.println("\nAccount created successfully! Welcome, " + name + "!");
        saveData();
    }


    public static void showMainScreen() {
        while (currentUser != null) {
            System.out.println("\n=====================================");
            System.out.println("  MAIN SCREEN");
            System.out.println("=====================================");
            System.out.println("Logged in as: " + currentUser.name);
            System.out.println("\nOptions:");
            System.out.println("1. Create Household");
            System.out.println("2. Join Household");
            System.out.println("3. Open Household");
            System.out.println("4. Get Report (Statistics)");
            System.out.println("5. Log Out");
            System.out.print("\nEnter choice (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("\n[Feature not yet implemented]");
                    break;
                case "2":
                    System.out.println("\n[Feature not yet implemented]");
                    break;
                case "3":
                    System.out.println("\n[Feature not yet implemented]");
                    break;
                case "4":
                    System.out.println("\n[Feature not yet implemented]");
                    break;
                case "5":
                    System.out.println("Logging out...");
                    currentUser = null;
                    saveData();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void loadData() {
        try {
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdir();
            }

            // Load users
            File usersFile = new File("data/users.txt");
            if (usersFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(usersFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 3) {
                        User user = new User(parts[0], parts[1], parts[2]);
                        users.put(parts[0], user);
                    }
                }
                reader.close();
            }

            // Load households (placeholder for now)
            File householdsFile = new File("data/households.txt");
            if (householdsFile.exists()) {
                // Will implement later
            }

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    /**
     * Save data to persistent storage
     */
    public static void saveData() {
        try {
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdir();
            }

            // Save users
            File usersFile = new File("data/users.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile));
            for (User user : users.values()) {
                writer.write(user.email + "|" + user.password + "|" + user.name);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}


class User {
    String email;
    String password;
    String name;
    List<String> householdIds;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.householdIds = new ArrayList<>();
    }
}


class Household {
    String id;
    String name;
    String description;
    String joinCode;
    List<String> memberEmails;
    List<Chore> chores;

    public Household(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.joinCode = generateJoinCode();
        this.memberEmails = new ArrayList<>();
        this.chores = new ArrayList<>();
    }

    private String generateJoinCode() {
        return "HC" + (int)(Math.random() * 900000 + 100000);
    }
}


class Chore {
    String id;
    String description;
    String priority;
    String type; // recurring or one-time
    String assignedTo;
    boolean completed;
    Date dueDate;

    public Chore(String id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }
}

