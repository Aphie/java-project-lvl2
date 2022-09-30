package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormat {
    public static final int FOUR_TIMES = 4;
    public static final int TWO_TIMES = 2;

    public static String convertToStylishFormat(List<Map<String, Object>> diffList) {
        String resultString = "{\n";

        for (Map<String, Object> diffMap : diffList) {
            if (diffMap.get("type").equals("added")) {
                resultString += " ".repeat(TWO_TIMES) + "+ " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("value")) + "\n";
            } else if (diffMap.get("type").equals("removed")) {
                resultString += " ".repeat(TWO_TIMES) + "- " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("value")) + "\n";
            } else if (diffMap.get("type").equals("none")) {
                resultString += " ".repeat(FOUR_TIMES) + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("value")) + "\n";
            } else {
                resultString += " ".repeat(TWO_TIMES) + "- " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("oldValue")) + "\n";
                resultString += " ".repeat(TWO_TIMES) + "+ " + diffMap.get("key") + ": "
                        + String.valueOf(diffMap.get("newValue")) + "\n";
            }
        }

        resultString += "}";
        return resultString;
    }
}
