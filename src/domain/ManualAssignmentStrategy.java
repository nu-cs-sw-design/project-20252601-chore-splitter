import java.util.List;

public class ManualAssignmentStrategy implements ChoresAssignmentTemplate {
    private final String selectedUserEmail;

    public ManualAssignmentStrategy(String userEmail) {
        this.selectedUserEmail = userEmail;
    }

    @Override
    public String assign(Chore chore, List<User> members) {
        return selectedUserEmail;
    }
}
