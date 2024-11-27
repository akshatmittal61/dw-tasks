package akshatmittal61.utils;

import java.time.OffsetDateTime;

public class SystemUtil {
    public static String getUtcTimestamp() {
        return OffsetDateTime.now().toString();
    }
    public static String getCurrentDir() {
        String currentDirPath = System.getProperty("user.dir");
        String[] parts = currentDirPath.split("/");
        return parts[parts.length - 1];
    }
}
