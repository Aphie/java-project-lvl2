package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getData(String format, String content)
            throws JsonProcessingException {

        Map<String, Object> parsedData = new HashMap<>();

        if (format.equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            MapType type = objectMapper.getTypeFactory()
                    .constructMapType(HashMap.class, String.class, Object.class);
            parsedData = objectMapper.readValue(content, type);
        } else if (format.equals("yml")) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            parsedData = mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        }
        return parsedData;
    }
}
