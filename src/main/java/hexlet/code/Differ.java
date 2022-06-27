package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(Path filePath1, Path filePath2) throws Exception {
        Map<String, String> data1 = new HashMap<>();
        Map<String, String> data2 = new HashMap<>();
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

        String resultString = "{\n";

        for (String k: resultKeys) {
            if (!data1.containsKey(k)) {
                resultString += "  + " + k + ": " + data2.get(k) + "\n";
            } else if (!data2.containsKey(k)) {
                resultString += "  - " + k + ": " + data1.get(k) + "\n";
            } else if (data1.get(k).equals(data2.get(k))) {
                resultString += "    " + k + ": " + data1.get(k) + "\n";
            } else {
                resultString += "  - " + k + ": " + data1.get(k) + "\n";
                resultString += "  + " + k + ": " + data2.get(k) + "\n";
            }
        }

        return resultString + "}";
    }

}
