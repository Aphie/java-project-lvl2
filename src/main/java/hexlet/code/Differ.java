package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Differ {
    public static final String DEFAULT_FORMAT = "stylish";

    //сравнение двух файлов без переданного формата
    public static String generate(String filePath1, String filePath2) throws Exception {
        Path file1 = Paths.get(filePath1);
        Path file2 = Paths.get(filePath2);

        Map<String, Object> data1 = Parser.getData(filePath1, Files.readString(file1));
        Map<String, Object> data2 = Parser.getData(filePath2, Files.readString(file2));

        LinkedHashMap<String, Object> diffMap = diffFormation(data1, data2);
        String resultString = Formatter.toConvertWithFormat(diffMap, DEFAULT_FORMAT);
        return resultString;
    }

    //сравнение двух файлов с переданным форматом
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Path file1 = Paths.get(filePath1);
        Path file2 = Paths.get(filePath2);

        Map<String, Object> data1 = Parser.getData(filePath1, Files.readString(file1));
        Map<String, Object> data2 = Parser.getData(filePath2, Files.readString(file2));

        LinkedHashMap<String, Object> diffMap = diffFormation(data1, data2);

        String resultString = Formatter.toConvertWithFormat(diffMap, format);
        return resultString;
    }

    public static LinkedHashMap<String, Object> diffFormation(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, Object> diffMap = new LinkedHashMap<>();
        TreeSet<String> resultKeys = new TreeSet<>();

        Set<String> data1Keys = data1.keySet();
        Set<String> data2Keys = data2.keySet();
        resultKeys.addAll(data1Keys);
        resultKeys.addAll(data2Keys);

        for (String k: resultKeys) {

            if (!data1.containsKey(k)) {
                diffMap.put("added " + k, data2.get(k));
            } else if (!data2.containsKey(k)) {
                diffMap.put("deleted " + k, data1.get(k));
            } else {
                if (String.valueOf(data1.get(k)).equals(String.valueOf(data2.get(k)))) {
                    diffMap.put("unchanged " + k, data1.get(k));
                } else {
                    diffMap.put("change- " + k, data1.get(k));
                    diffMap.put("chan+ " + k, data2.get(k));
                }

            }
        }
        return diffMap;
    }

}
