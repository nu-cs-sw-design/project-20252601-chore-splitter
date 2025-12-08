import java.util.*;

public class HouseholdDataSource implements HouseholdsInterface {
    private final String filePath;

    public HouseholdDataSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Map<String, Household> loadHouseholds() {
        return new HashMap<>();
    }

    @Override
    public void saveHouseholds(Map<String, Household> households) {
        
    }

    @Override
    public Household findHouseholdById(String id) {
        return null;
    }

    @Override
    public Household findHouseholdByJoinCode(String joinCode) {
        return null;
    }

    @Override
    public void addHousehold(Household household) {
        
    }

    @Override
    public void updateHousehold(Household household) {
        
    }
}
