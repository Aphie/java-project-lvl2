package hexlet.code.formatters;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PlainFormat {
    public static final int VALUE_FOR_ADDING_REPLACEMENT = 6;
    public static final int VALUE_FOR_DELETION_REPLACEMENT = 8;

    public static String convertToPlainFormat(Map<String, Object> diffMap) {
        Set<String> resultKeys = diffMap.keySet();

        String resultString = "\n";

        for (String key: resultKeys) {
            String resultValue = "";
            if ((diffMap.get(key)).getClass() == String.class) {
                if (diffMap.get(key).toString().equals("null")) {
                    resultValue = diffMap.get(key).toString();
                } else {
                    resultValue = "'" + diffMap.get(key).toString() + "'";
                }
            } else if (((diffMap.get(key)).getClass() == ArrayList.class)
                    || ((diffMap.get(key)).getClass() == LinkedHashMap.class)) {
                resultValue = "[complex value]";
            } else {
                resultValue = diffMap.get(key).toString();
            }

            if (key.startsWith("added")) {
                resultString += "Property '" + key.substring(VALUE_FOR_ADDING_REPLACEMENT)
                        + "' was added with value: " + resultValue + "\n";
            } else if (key.startsWith("deleted")) {
                resultString += "Property '" + key.substring(VALUE_FOR_DELETION_REPLACEMENT) + "' was removed\n";
            } else if (key.startsWith("change-")) {
                resultString += "Property '" + key.substring(VALUE_FOR_DELETION_REPLACEMENT)
                        + "' was updated. From " + resultValue + " to ";
            } else if (key.startsWith("chan+")) {
                resultString += resultValue + "\n";
            }
        }
        return resultString;
    }
}
