package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;

public class StylishFormat {
    public static final int FOUR_TIMES = 4;
    public static final int TWO_TIMES = 2;
    public static final int VALUE_FOR_ADDING_REPLACEMENT = 6;
    public static final int VALUE_FOR_DELETION_REPLACEMENT = 8;
    public static final int VALUE_FOR_NO_CHANGES_REPLACEMENT = 10;

    public static String convertToStylishFormat(Map<String, Object> diffMap) {
        Set<String> resultKeys = diffMap.keySet();
        String resultString = "{\n";
        for (String key: resultKeys) {
            if (key.startsWith("added") || key.startsWith("chan+")) {
                resultString += " ".repeat(TWO_TIMES) + "+ " + key.substring(VALUE_FOR_ADDING_REPLACEMENT)
                        + ": " + String.valueOf(diffMap.get(key)) + "\n";
            } else if (key.startsWith("deleted") || key.startsWith("change-")) {
                resultString += " ".repeat(TWO_TIMES) + "- " + key.substring(VALUE_FOR_DELETION_REPLACEMENT)
                        + ": " + String.valueOf(diffMap.get(key)) + "\n";
            } else if (key.startsWith("unchanged")) {
                resultString += " ".repeat(FOUR_TIMES) + key.substring(VALUE_FOR_NO_CHANGES_REPLACEMENT)
                        + ": " + String.valueOf(diffMap.get(key)) + "\n";
            }
        }
        resultString += "}";
        return resultString;
    }
}
