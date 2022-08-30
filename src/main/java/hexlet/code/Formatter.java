package hexlet.code;

import java.util.Map;
import java.util.Set;

public class Formatter {
    public static final int THREE_TIMES = 3;
    public static final int TWO_TIMES = 2;
    public static String toFormate(Map<String, Object> diffMap, String format) {
        Set<String> resultKeys = diffMap.keySet();

        if (format.equals("stylish")) {
            String resultString = "{\n";
            for (String key: resultKeys) {
                if (key.startsWith(" ")) {
                    resultString += " ".repeat(THREE_TIMES) + key + ": " + diffMap.get(key).toString() + "\n";
                } else {
                    resultString += " ".repeat(TWO_TIMES) + key + ": " + diffMap.get(key).toString() + "\n";
                }
            }
            resultString += "}";
            return resultString;
        } else {
            return "No output for such format as " + format + ". Please specify existing format for information output";
        }

    }
}
