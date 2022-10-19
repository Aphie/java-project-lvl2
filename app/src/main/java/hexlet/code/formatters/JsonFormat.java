package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormat {

    public static String convertToJsonFormat(List<Map<String, Object>> diffList) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(diffList);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }

    }
}
