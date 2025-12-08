import java.util.Map;

public interface HouseholdsInterface {
    Map<String, Household> loadHouseholds();
    void saveHouseholds(Map<String, Household> households);
    Household findHouseholdById(String id);
    Household findHouseholdByJoinCode(String joinCode);
    void addHousehold(Household household);
    void updateHousehold(Household household);
}
