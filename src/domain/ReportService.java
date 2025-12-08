import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ReportService {
    private final ChoreInterface choreRepository;
    private final HouseholdsInterface householdRepository;
    private final ReportWriter reportWriter;
    private final ReportFormatter reportFormatter;

    public ReportService(ChoreInterface choreRepository,
                         HouseholdsInterface householdRepository,
                         ReportWriter reportWriter,
                         ReportFormatter formatter) {
        this.choreRepository = choreRepository;
        this.householdRepository = householdRepository;
        this.reportWriter = reportWriter;
        this.reportFormatter = formatter;
    }

    public String generateReport(String userEmail, String startDate, String endDate) {
        if (!validateDateRange(startDate, endDate)) return null;
        List<Chore> chores = queryCompletedChores(userEmail, startDate, endDate);
        Map<String, Object> stats = calculateStatistics(chores);
        String content = reportFormatter.format(chores, stats, startDate, endDate);
        String path = reportWriter.generateFilePath(startDate, endDate);
        reportWriter.writeToFile(path, content);
        return path;
    }

    public List<Chore> queryCompletedChores(String userEmail, String startDate, String endDate) {
        // Stub: rely on repository if present; otherwise return empty list
        List<Chore> all = choreRepository != null ? choreRepository.loadChores() : Collections.emptyList();
        ChoreFilter completed = new CompletedChoreFilter();
        ChoreFilter dateRange = new DateRangeChoreFilter(startDate, endDate);
        List<Chore> out = new ArrayList<>();
        for (Chore c : all) {
            if (completed.matches(c) && dateRange.matches(c)) out.add(c);
        }
        return out;
    }

    public Map<String, Object> calculateStatistics(List<Chore> chores) {
        Map<String, Object> stats = new HashMap<>();
        Map<String, Integer> byPriority = new HashMap<>();
        Map<String, Integer> byPerson = new HashMap<>();

        if (chores != null) {
            for (Chore c : chores) {
                byPriority.put(c.priority, byPriority.getOrDefault(c.priority, 0) + 1);
                byPerson.put(c.assignedTo, byPerson.getOrDefault(c.assignedTo, 0) + 1);
            }
        }
        stats.put("byPriority", byPriority);
        stats.put("byPerson", byPerson);
        stats.put("total", chores == null ? 0 : chores.size());
        return stats;
    }

    public boolean validateDateRange(String startDate, String endDate) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setLenient(false);
        try {
            Date s = df.parse(startDate);
            Date e = df.parse(endDate);
            return !s.after(e);
        } catch (ParseException ex) {
            return false;
        }
    }
}
