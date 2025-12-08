import java.util.List;
import java.util.Map;

public class CsvReportFormatter implements ReportFormatter {
    @Override
    public String format(List<Chore> chores, Map<String, Object> statistics, String startDate, String endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("household,description,priority,type,assignedTo,completed,completionDate\n");
        if (chores != null) {
            for (Chore c : chores) {
                sb.append("") // household name not present on Chore; left blank in stub
                  .append(",").append(escape(c.description))
                  .append(",").append(escape(c.priority))
                  .append(",").append(escape(c.type))
                  .append(",").append(escape(c.assignedTo))
                  .append(",").append(c.completed)
                  .append(",").append(escape(c.completionDate))
                  .append("\n");
            }
        }
        return sb.toString();
    }

    private String escape(String s) {
        if (s == null) return "";
        String v = s.replace("\"", "\"\"");
        if (v.contains(",") || v.contains("\"") || v.contains("\n")) return "\"" + v + "\"";
        return v;
        }
}
