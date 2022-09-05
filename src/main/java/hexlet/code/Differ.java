package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Differ {
    public static final String DEFAULT_FORMAT = "stylish";

    //сравнение двух файлов без переданного формата
    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        LinkedHashMap<String, Object> diffMap = new LinkedHashMap<>();
        String falseResult = new String();
        Set<String> data1Keys = new HashSet<>();
        Set<String> data2Keys = new HashSet<>();
        Path file1 = Paths.get(filePath1);
        Path file2 = Paths.get(filePath2);

        if (!(Files.readString(file1)).isEmpty() && !(Files.readString(file2)).isEmpty()) {
            data1 = Parser.getData(filePath1, Files.readString(file1));
            data2 = Parser.getData(filePath2, Files.readString(file2));
        } else if ((Files.readString(file1)).isEmpty() && !(Files.readString(file2)).isEmpty()) {
            data2 = Parser.getData(filePath2, Files.readString(file2));
        } else if ((Files.readString(file2)).isEmpty() && !(Files.readString(file1)).isEmpty()) {
            data1 = Parser.getData(filePath1, Files.readString(file1));
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
        String resultString = Formatter.toConvertWithFormat(diffMap, DEFAULT_FORMAT);
        return resultString;
    }

    //сравнение двух файлов с переданным форматом
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        LinkedHashMap<String, Object> diffMap = new LinkedHashMap<>();
        String falseResult = new String();
        Set<String> data1Keys = new HashSet<>();
        Set<String> data2Keys = new HashSet<>();
        Path file1 = Paths.get(filePath1);
        Path file2 = Paths.get(filePath2);

        if (!(Files.readString(file1)).isEmpty() && !(Files.readString(file2)).isEmpty()) {
            data1 = Parser.getData(filePath1, Files.readString(file1));
            data2 = Parser.getData(filePath2, Files.readString(file2));
        } else if ((Files.readString(file1)).isEmpty() && !(Files.readString(file2)).isEmpty()) {
            data2 = Parser.getData(filePath2, Files.readString(file2));
        } else if ((Files.readString(file2)).isEmpty() && !(Files.readString(file1)).isEmpty()) {
            data1 = Parser.getData(filePath1, Files.readString(file1));
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
