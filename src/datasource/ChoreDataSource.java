import java.util.*;

public class ChoreDataSource implements ChoreInterface {
    private final String filePath;

    public ChoreDataSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Chore> loadChores() {
        return new ArrayList<>();
    }

    @Override
    public void saveChores(List<Chore> chores) {
        
    }

    @Override
    public Chore findChoreById(String id) {
        return null;
    }

    @Override
    public void addChore(Chore chore) {
        
    }

    @Override
    public void updateChore(Chore chore) {
        
    }

    @Override
    public void deleteChore(String choreId) {
        
    }
}
