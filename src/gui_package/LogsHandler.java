package gui_package;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogsHandler {
    private static final List<String> logs = new ArrayList<>();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Add log entry
    public static void addLog(String action) {
        String timestamp = sdf.format(new Date());
        logs.add(timestamp + " - " + action);
    }

    // Get logs
    public static List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    // Clear logs
    public static void clearLogs() {
        logs.clear();
    }
}
