package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Launcher {

    public static void launch(String filepath1, String filepath2, String format) throws Exception {
        String resultDiff = "";

        filepath1 = checkAndConvertPaths(filepath1);
        filepath2 = checkAndConvertPaths(filepath2);

        if (format == null) {
            resultDiff = Differ.generate(filepath1, filepath2);
        } else {
            resultDiff = Differ.generate(filepath1, filepath2, format);
        }
        System.out.println(resultDiff);

    }

    public static String checkAndConvertPaths(String filepath) {
        Path file = Paths.get(filepath);
        if (!file.isAbsolute()) {
            filepath = file.toAbsolutePath().toString();
        }
        return filepath;
    }
}
