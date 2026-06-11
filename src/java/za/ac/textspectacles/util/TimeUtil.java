package za.ac.textspectacles.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtil {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Timestamp ts) {
        if (ts == null) return "";
        return FORMAT.format(ts);
    }
}
