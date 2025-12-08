public class HouseholdDashboard {
    private Household household;
    private User currentUser;

    public HouseholdDashboard(Household household, User user) {
        this.household = household;
        this.currentUser = user;
    }

    public void displayMembers() { }
    public void displayChores() { }
    public void displayActiveChores() { }
    public void displayCompletedChores() { }
    public void addChore() { }
    public void markChoreComplete(String choreId) { }
    public void removeChore(String choreId) { }
}
