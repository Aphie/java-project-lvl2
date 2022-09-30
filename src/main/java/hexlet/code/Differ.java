package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {
    public static final String DEFAULT_FORMAT = "stylish";

    //сравнение двух файлов без переданного формата
    public static String generate(String filePath1, String filePath2) throws Exception {
        Path file1 = Paths.get(filePath1);
        Path file2 = Paths.get(filePath2);

        Map<String, Object> data1 = Parser.getData(filePath1, Files.readString(file1));
        Map<String, Object> data2 = Parser.getData(filePath2, Files.readString(file2));

        List<Map<String, Object>> diffList = DifferenceFormation.diffFormation(data1, data2);
        String resultString = Formatter.toConvertWithFormat(diffList, DEFAULT_FORMAT);
        return resultString;
    }

    //сравнение двух файлов с переданным форматом
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Path file1 = Paths.get(filePath1);
        Path file2 = Paths.get(filePath2);

        Map<String, Object> data1 = Parser.getData(filePath1, Files.readString(file1));
        Map<String, Object> data2 = Parser.getData(filePath2, Files.readString(file2));

        List<Map<String, Object>> diffList = DifferenceFormation.diffFormation(data1, data2);

        String resultString = Formatter.toConvertWithFormat(diffList, format);
        return resultString;
    }

}
