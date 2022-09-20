package hexlet.code.formatters;


import java.util.*;

public class PlainFormat {
    public static final int VALUE_FOR_ADDING_REPLACEMENT = 6;
    public static final int VALUE_FOR_DELETION_REPLACEMENT = 8;

    public static String convertToPlainFormat(Map<String, Object> diffMap) {
        Set<String> resultKeys = diffMap.keySet();
        List<String> resultArray = new ArrayList<>();

        for (String key: resultKeys) {
            String resultValue = calculateResultValue(diffMap.get(key));

            if (key.startsWith("added")) {
                resultArray.add("Property '" + key.substring(VALUE_FOR_ADDING_REPLACEMENT)
                        + "' was added with value: " + resultValue );
            } else if (key.startsWith("deleted")) {
                resultArray.add("Property '" + key.substring(VALUE_FOR_DELETION_REPLACEMENT) + "' was removed");
            } else if (key.startsWith("change-")) {
                resultArray.add("Property '" + key.substring(VALUE_FOR_DELETION_REPLACEMENT)
                        + "' was updated. From " + resultValue + " to ");
            } else if (key.startsWith("chan+")) {
                resultArray.add(resultValue);
            }
        }
        return String.join("\n", resultArray);
    }

    public static String calculateResultValue (Object value) {
        String resultValue = "";
        if (value.getClass() == String.class) {
            if (value.toString().equals("null")) {
                resultValue = value.toString();
            } else {
                resultValue = "'" + value.toString() + "'";
            }
        } else if ((value.getClass() == ArrayList.class)
                || (value.getClass() == LinkedHashMap.class)) {
            resultValue = "[complex value]";
        } else {
            resultValue = value.toString();
        }
        return resultValue;
    }
}
