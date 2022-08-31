package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Set;

public class JsonFormat {

    public static final int VALUE_FOR_STRING_REPEAT = 2;
    public static final int DOUBLED_VALUE_FOR_STRING_REPEAT = 4;
    public static final int VALUE_FOR_ADDING_REPLACEMENT = 6;
    public static final int VALUE_FOR_DELETION_REPLACEMENT = 8;
    public static final int VALUE_FOR_NO_CHANGE_REPLACEMENT = 10;

    public static String convertToJsonFormat(Map<String, Object> diffMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String resultString = "{\n";
        Set<String> resultKeys = diffMap.keySet();
        for (String key: resultKeys) {
            if (key.startsWith("added")) {
                resultString += " ".repeat(VALUE_FOR_STRING_REPEAT) + "\"" + key.substring(VALUE_FOR_ADDING_REPLACEMENT)
                        + "\": {\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"action\": \"added\",\n"
                        + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"value\": "
                        + objectMapper.writeValueAsString(diffMap.get(key)) + "\n"
                        + " ".repeat(VALUE_FOR_STRING_REPEAT) + "},\n";
            } else if (key.startsWith("deleted")) {
                resultString += " ".repeat(VALUE_FOR_STRING_REPEAT) + "\""
                        + key.substring(VALUE_FOR_DELETION_REPLACEMENT)
                        + "\": {\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"action\": \"removed\"\n"
                        + " ".repeat(VALUE_FOR_STRING_REPEAT) + "},\n";
            } else if (key.startsWith("change-")) {
                resultString += " ".repeat(VALUE_FOR_STRING_REPEAT) + "\""
                        + key.substring(VALUE_FOR_DELETION_REPLACEMENT)
                        + "\": {\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"action\": \"changed\",\n"
                        + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"previousValue\": "
                        + objectMapper.writeValueAsString(diffMap.get(key)) + ",\n";
            } else if (key.startsWith("chan+")) {
                resultString += " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"currentValue\": "
                        + objectMapper.writeValueAsString(diffMap.get(key)) + "\n"
                        + " ".repeat(VALUE_FOR_STRING_REPEAT) + "},\n";
            } else if (key.startsWith("unchanged")) {
                resultString += " ".repeat(VALUE_FOR_STRING_REPEAT) + "\""
                        + key.substring(VALUE_FOR_NO_CHANGE_REPLACEMENT)
                        + "\": {\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"action\": \"none\"\n"
                        + " ".repeat(VALUE_FOR_STRING_REPEAT) + "},\n";
            }
        }
        String resultStringWithoutLastComma = resultString.substring(0, resultString.lastIndexOf(","));

        resultStringWithoutLastComma += "\n}";
        return resultStringWithoutLastComma;
    }
}
