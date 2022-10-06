package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class PlainFormat {

    public static String convertToPlainFormat(List<Map<String, Object>> diffList) {
        List<String> results = new ArrayList<>();

        for (Map<String, Object> diffMap : diffList) {
            if (diffMap.get("type").equals("added")) {
                results.add("Property '" + diffMap.get("key") + "' was added with value: "
                        + calculateResultValue(diffMap.get("value")));
            } else if (diffMap.get("type").equals("removed")) {
                results.add("Property '" + diffMap.get("key") + "' was removed");
            } else if (diffMap.get("type").equals("updated")) {
                results.add("Property '" + diffMap.get("key") + "' was updated. From "
                        + calculateResultValue(diffMap.get("oldValue")) + " to "
                        + calculateResultValue(diffMap.get("newValue")));
            }
        }

        return String.join("\n", results);
    }

    public static String calculateResultValue(Object value) {
        String resultValue = "";
        if (String.valueOf(value).equals("null")) {
            resultValue = "null";
        } else if (value.getClass() == String.class) {
            resultValue = "'" + value.toString() + "'";
        } else if ((value.getClass() == ArrayList.class)
                || (value.getClass() == LinkedHashMap.class)) {
            resultValue = "[complex value]";
        } else {
            resultValue = value.toString();
        }
        return resultValue;
    }
}
