package za.ac.textspectacles.util;

public class ValidationUtil {

    public static boolean isValidAgentId(String agentId) {
        return agentId != null && agentId.matches("\\d{3}");
    }

    public static boolean isValidClassification(String classification) {
        return "Low".equals(classification) || "High".equals(classification) || "Critical".equals(classification);
    }

    public static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
