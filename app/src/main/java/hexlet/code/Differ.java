package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Differ {
    public static final String DEFAULT_FORMAT = "stylish";

    //сравнение двух файлов без переданного формата
    public static String generate(String filePath1, String filePath2) throws JsonProcessingException {
        return generate(filePath1, filePath2, DEFAULT_FORMAT);
    }

    //сравнение двух файлов с переданным форматом
    public static String generate(String filePath1, String filePath2, String format) throws JsonProcessingException {
        Path file1 = Paths.get(filePath1);
        Path file2 = Paths.get(filePath2);
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        List<Map<String, Object>> diffList = new ArrayList<>();

        try {
            data1 = Parser.getData(filePath1, Files.readString(file1));
            data2 = Parser.getData(filePath2, Files.readString(file2));
            diffList = DifferenceFormation.diffFormation(data1, data2);

        } catch (NoSuchFileException e) {
            return "ERROR: You've entered incorrect filename or filename that doesn't exist";
        } catch (IOException e) {
            return "ERROR: You've entered filename with incorrect format. Please, enter json or yml files only";
        }
        return Formatter.toConvertWithFormat(diffList, format);
    }
}
