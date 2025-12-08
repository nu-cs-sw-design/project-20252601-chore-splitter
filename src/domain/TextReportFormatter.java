import java.util.List;
import java.util.Map;

public class TextReportFormatter implements ReportFormatter {
    @Override
    public String format(List<Chore> chores, Map<String, Object> statistics, String startDate, String endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("CHORE COMPLETION REPORT\n");
        sb.append("Date Range: ").append(startDate).append(" to ").append(endDate).append("\n");
        sb.append("Total Chores: ").append(chores == null ? 0 : chores.size()).append("\n");
        return sb.toString();
    }
}
