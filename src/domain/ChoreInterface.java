import java.util.List;

public interface ChoreInterface {
    List<Chore> loadChores();
    void saveChores(List<Chore> chores);
    Chore findChoreById(String id);
    void addChore(Chore chore);
    void updateChore(Chore chore);
    void deleteChore(String choreId);
}
