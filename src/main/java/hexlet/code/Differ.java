package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Differ {
    public static String generate(Path filePath1, Path filePath2, String format) throws Exception {
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        LinkedHashMap<String, Object> diffMap = new LinkedHashMap<>();
        String falseResult = new String();
        Set<String> data1Keys = new HashSet<>();
        Set<String> data2Keys = new HashSet<>();

        if (!(Files.readString(filePath1)).isEmpty() && !(Files.readString(filePath2)).isEmpty()) {
            data1 = Parser.getData(filePath1.toString(), Files.readString(filePath1));
            data2 = Parser.getData(filePath2.toString(), Files.readString(filePath2));
        } else if ((Files.readString(filePath1)).isEmpty() && !(Files.readString(filePath2)).isEmpty()) {
            data2 = Parser.getData(filePath2.toString(), Files.readString(filePath2));
        } else if ((Files.readString(filePath2)).isEmpty() && !(Files.readString(filePath1)).isEmpty()) {
            data1 = Parser.getData(filePath1.toString(), Files.readString(filePath1));
        } else {
            return falseResult;
        }

        TreeSet<String> resultKeys = new TreeSet<>();

        data1Keys = data1.keySet();
        data2Keys = data2.keySet();
        resultKeys.addAll(data1Keys);
        resultKeys.addAll(data2Keys);

        for (String k: resultKeys) {

            if (!data1.containsKey(k)) {
                if (null == data2.get(k)) {
                    data2.put(k, "null");
                }
                diffMap.put("added " + k, data2.get(k));
            } else if (!data2.containsKey(k)) {
                if (null == data1.get(k)) {
                    data1.put(k, "null");
                }
                diffMap.put("deleted " + k, data1.get(k));
            } else {
                if (null == data2.get(k)) {
                    data2.put(k, "null");
                }
                if (null == data1.get(k)) {
                    data1.put(k, "null");
                }
                if (data1.get(k).equals(data2.get(k))) {
                    diffMap.put("unchanged " + k, data1.get(k));
                } else {
                    diffMap.put("change- " + k, data1.get(k));
                    diffMap.put("chan+ " + k, data2.get(k));
                }

            }
        }
        String resultString = Formatter.toConvertWithFormat(diffMap, format);
        return resultString;
    }

}
