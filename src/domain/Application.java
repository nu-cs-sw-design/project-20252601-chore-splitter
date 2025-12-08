import java.util.List;
import java.util.Map;

public class Application {
    UserBaseInterface userRepository;
    HouseholdsInterface householdRepository;
    ChoreInterface choreRepository;
    AuthenticationManager authenticationManager;

    Map<String, User> users;
    Map<String, Household> households;
    User currentUser;

    public Application() { }

    public void startApp() { }
    public void loadData() { }
    public void saveData() { }

    public Household createHousehold(String name, String description, User owner) { return null; }
    public Household joinHousehold(String joinCode, User user) { return null; }
    public Household findHouseholdByJoinCode(String joinCode) { return null; }

    public String readNonEmpty(String prompt) { return ""; }
    public String readEnum(String prompt, String[] allowed) { return allowed != null && allowed.length > 0 ? allowed[0] : ""; }
    public int readIntInRange(String prompt, int min, int max) { return min; }
    public String capitalizeChoice(String v, String[] allowed) { return v; }
}
