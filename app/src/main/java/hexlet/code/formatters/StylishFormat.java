package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormat {
    public static final int FOUR_TIMES = 4;
    public static final int TWO_TIMES = 2;

    public static String convertToStylishFormat(List<Map<String, Object>> diffList) {
        String resultString = "{\n";
        StringBuilder result = new StringBuilder(resultString);

        for (Map<String, Object> diffMap : diffList) {
            if (diffMap.get("type").equals("added")) {
                result.append(" ".repeat(TWO_TIMES) + "+ " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("value")) + "\n");
            } else if (diffMap.get("type").equals("removed")) {
                result.append(" ".repeat(TWO_TIMES) + "- " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("value")) + "\n");
            } else if (diffMap.get("type").equals("none")) {
                result.append(" ".repeat(FOUR_TIMES) + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("value")) + "\n");
            } else {
                result.append(" ".repeat(TWO_TIMES) + "- " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("oldValue")) + "\n");
                result.append(" ".repeat(TWO_TIMES) + "+ " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("newValue")) + "\n");
            }
        }

        result.append("}");
        return result.toString();
    }
}
