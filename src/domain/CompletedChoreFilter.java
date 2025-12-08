public class CompletedChoreFilter implements ChoreFilter {
    @Override
    public boolean matches(Chore chore) {
        return chore != null && chore.completed;
    }
}
