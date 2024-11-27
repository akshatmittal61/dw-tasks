package akshatmittal61.utils;

public class Logger {
    public static String formatter(String type, Object... messages) {
        String service = SystemUtil.getCurrentDir();
        String timestamp = SystemUtil.getUtcTimestamp();
        String level = type.toUpperCase();
        String message = Logger.joinMessages(messages);
        return "[" + service + "] [" + timestamp + "] [" + level + "] " + message;
    }
    private static String joinMessages(Object... messages) {
        StringBuilder sb = new StringBuilder();
        for (Object message : messages) {
            sb.append(message).append(" ");
        }
        return sb.toString().trim();
    }
    public static void info(Object... messages) {
        System.out.println(Logger.formatter("info", messages));
    }
    public static void error(Object... messages) {
        System.out.println(Logger.formatter("error", messages));
    }
    public static void warn(Object... messages) {
        System.out.println(Logger.formatter("warn", messages));
    }
    public static void debug(Object... messages) {
        System.out.println(Logger.formatter("debug", messages));
    }
}
