package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormat {

    public static final int VALUE_FOR_STRING_REPEAT = 2;
    public static final int DOUBLED_VALUE_FOR_STRING_REPEAT = 4;

    public static String convertToJsonFormat(List<Map<String, Object>> diffList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String resultString = "{\n";

        for (Map<String, Object> diffMap : diffList) {
            if (diffMap.get("type").equals("added")) {
                resultString += " ".repeat(VALUE_FOR_STRING_REPEAT) + "\"" + diffMap.get("key")
                        + "\": {\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"action\": \""
                        + diffMap.get("type") + "\",\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"value\": "
                        + objectMapper.writeValueAsString(diffMap.get("value")) + "\n"
                        + " ".repeat(VALUE_FOR_STRING_REPEAT) + "},\n";
            } else if (diffMap.get("type").equals("removed") || diffMap.get("type").equals("none")) {
                resultString += " ".repeat(VALUE_FOR_STRING_REPEAT) + "\"" + diffMap.get("key")
                        + "\": {\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"action\": \""
                        + diffMap.get("type") + "\"\n" + " ".repeat(VALUE_FOR_STRING_REPEAT) + "},\n";
            } else {
                resultString += " ".repeat(VALUE_FOR_STRING_REPEAT) + "\"" + diffMap.get("key")
                        + "\": {\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"action\": \""
                        + diffMap.get("type") + "\",\n" + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT)
                        + "\"previousValue\": " + objectMapper.writeValueAsString(diffMap.get("oldValue")) + ",\n"
                        + " ".repeat(DOUBLED_VALUE_FOR_STRING_REPEAT) + "\"newValue\": "
                        + objectMapper.writeValueAsString(diffMap.get("newValue")) + "\n"
                        + " ".repeat(VALUE_FOR_STRING_REPEAT) + "},\n";
            }
        }

        String resultStringWithoutLastComma = resultString.substring(0, resultString.lastIndexOf(","));
        resultStringWithoutLastComma += "\n}";
        return resultStringWithoutLastComma;
    }
}
