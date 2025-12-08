import java.util.List;
import java.util.Random;

public class RandomAssignmentStrategy implements ChoresAssignmentTemplate {
    private final Random rnd = new Random();

    @Override
    public String assign(Chore chore, List<User> members) {
        if (members == null || members.isEmpty()) return null;
        int i = rnd.nextInt(members.size());
        return members.get(i) != null ? members.get(i).email : null;
    }
}
