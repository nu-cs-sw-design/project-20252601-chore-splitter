import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRangeChoreFilter implements ChoreFilter {
    private final String startDate;
    private final String endDate;
    private final SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public DateRangeChoreFilter(String startDate, String endDate) {
        df.setLenient(false);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean matches(Chore chore) {
        if (chore == null || chore.completionDate == null) return false;
        try {
            Date s = df.parse(startDate);
            Date e = df.parse(endDate);
            Date c = df.parse(chore.completionDate);
            return !c.before(s) && !c.after(e);
        } catch (ParseException ex) {
            return false;
        }
    }
}
