package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {
    public static final String DEFAULT_FORMAT = "stylish";

    //сравнение двух файлов без переданного формата
    public static String generate(String filePath1, String filePath2)
            throws IOException {
        return generate(filePath1, filePath2, DEFAULT_FORMAT);
    }

    //сравнение двух файлов с переданным форматом
    public static String generate(String filePath1, String filePath2, String format)
            throws IOException {
        Path file1 = checkAndConvertPaths(filePath1);
        Path file2 = checkAndConvertPaths(filePath2);
        Map<String, Object> data1 = Parser.getData(parseFormat(filePath1), Files.readString(file1));
        Map<String, Object> data2 = Parser.getData(parseFormat(filePath2), Files.readString(file2));
        List<Map<String, Object>> diffList = DifferenceFormation.diffFormation(data1, data2);

        return Formatter.toConvertWithFormat(diffList, format);
    }

    public static String parseFormat(String filepath) {
        String format = filepath.substring(filepath.lastIndexOf('/') + 1);
        int dotIndex = format.lastIndexOf('.');
        return format.substring(dotIndex  + 1);
    }

    public static Path checkAndConvertPaths(String filepath) {
        Path file = Paths.get(filepath);
        if (!file.isAbsolute()) {
            file.toAbsolutePath();
        }
        return file;
    }

}
