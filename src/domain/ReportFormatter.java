import java.util.List;
import java.util.Map;

public interface ReportFormatter {
    String format(List<Chore> chores, Map<String, Object> statistics, String startDate, String endDate);
}
