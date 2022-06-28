package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, String> getData(String filepath, String content) throws Exception {
        String format = filepath.substring(filepath.lastIndexOf('/') + 1);
        int dotIndex = format.lastIndexOf('.');
        Map<String, String> parsedData = new HashMap<>();
        if ((format.substring(dotIndex  + 1)).equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            MapType type = objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, String.class);
            parsedData = objectMapper.readValue(content, type);
        } else if ((format.substring(dotIndex  + 1)).equals("yml")) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            parsedData = mapper.readValue(content, new TypeReference<Map<String, String>>() { });
        } else {
            throw new Exception("ERROR: You entered filename without file format or tried to parse file with "
                    + "incorrect format");
        }
        return parsedData;
    }

}
