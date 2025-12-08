public class ChoreForm {
    private String description;
    private String priority;
    private String type;
    private String assignmentType;

    public ChoreForm() { }

    public void promptDetails() { }
    public boolean validateInput() { return true; }
    public Chore submit() { return null; }
    public String selectPriority() { return priority; }
    public String selectType() { return type; }
    public String selectAssignment() { return assignmentType; }
}
