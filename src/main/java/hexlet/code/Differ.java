package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

public class Differ {
    public static String generate (Path filePath1, Path filePath2) throws Exception {
        Map<String, String> data1 = getData(Files.readString(filePath1));
        Map<String, String> data2 = getData(Files.readString(filePath2));

        TreeSet<String> resultKeys = new TreeSet<>();

        Set<String> data1Keys = data1.keySet();
        Set<String> data2Keys = data2.keySet();
        resultKeys.addAll(data1Keys);
        resultKeys.addAll(data2Keys);

        String resultString = "{\n";

        for (String k: resultKeys) {
            if (!data1.containsKey(k)) {
                resultString += "  + " + k + ": " + data2.get(k) + "\n";
            } else if (!data2.containsKey(k)) {
                resultString += "  - " + k + ": " + data1.get(k) + "\n";
            } else if (data1.get(k).equals(data2.get(k))) {
                resultString += "    " +k + ": " + data1.get(k) + "\n";
            } else {
                resultString += "  - " + k + ": " + data1.get(k) + "\n";
                resultString += "  + " + k + ": " + data2.get(k) + "\n";
            }
        }

        return resultString + "}";
    }

    public static Map<String,String> getData(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        MapType type = objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, String.class);
        return objectMapper.readValue(content, type);
    }
}
