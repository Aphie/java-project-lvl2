package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
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
                Map<String, Object> temporaryMap =
                        toCreateTemporaryMap(diffMap.get("type"), diffMap.get("value"), null);
                resultString += objectMapper.writeValueAsString(diffMap.get("key")) + ":"
                        + objectMapper.writeValueAsString(temporaryMap) + ",\n";
            } else if (diffMap.get("type").equals("removed") || diffMap.get("type").equals("none")) {
                Map<String, Object> temporaryMap = toCreateTemporaryMap(diffMap.get("type"), null, null);
                resultString += objectMapper.writeValueAsString(diffMap.get("key")) + ":"
                        + objectMapper.writeValueAsString(temporaryMap) + ",\n";
            } else {
                Map<String, Object> temporaryMap =
                        toCreateTemporaryMap(diffMap.get("type"), diffMap.get("oldValue"), diffMap.get("newValue"));
                resultString += objectMapper.writeValueAsString(diffMap.get("key")) + ":"
                        + objectMapper.writeValueAsString(temporaryMap) + ",\n";
            }
        }

        String resultStringWithoutLastComma = resultString.substring(0, resultString.lastIndexOf(","));
        resultStringWithoutLastComma += "\n}";
        return resultStringWithoutLastComma;
    }

    public static Map<String, Object> toCreateTemporaryMap(Object type, Object value, Object newValue) {
        Map<String, Object> temporaryMap = new HashMap<>();
        if ((value == null) && (newValue == null)) {
            temporaryMap.put("action", type);
        } else if (newValue == null) {
            temporaryMap.put("action", type);
            temporaryMap.put("value", value);
        } else {
            temporaryMap.put("action", type);
            temporaryMap.put("previousValue", value);
            temporaryMap.put("newValue", newValue);
        }
        return temporaryMap;
    }
}
