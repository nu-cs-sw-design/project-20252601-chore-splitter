import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    private final String reportsDirectory;

    public ReportWriter(String reportsDirectory) {
        this.reportsDirectory = reportsDirectory;
    }

    public void writeToFile(String filePath, String content) {
        try {
            File f = new File(filePath);
            File parent = f.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            try (FileWriter w = new FileWriter(f)) {
                if (content != null) w.write(content);
            }
        } catch (IOException e) {
            
        }
    }

    public String generateFilePath(String startDate, String endDate) {
        String name = "ChoreReport_stub_" + System.currentTimeMillis() + ".txt";
        File dir = new File(reportsDirectory == null ? "reports" : reportsDirectory);
        return new File(dir, name).getPath();
    }
}
