package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

public class AppTest {

    @Test
    void appTestAbsolutePathBothFiles() throws Exception {
        String filePath1 = "C:\\Users\\s.andreyuk\\IdeaProjects\\app\\src\\test\\resources"
                + "\\appTest\\appTestAbsolutePathBothFiles_file1.json";
        String filePath2 = "C:\\Users\\s.andreyuk\\IdeaProjects\\app\\src\\test\\resources"
                + "\\appTest\\appTestAbsolutePathBothFiles_file2.json";

        String[] args = {filePath1, filePath2};
        int expected = 0;
        int exitCode = new CommandLine(new App()).execute(args);
        Assertions.assertEquals(expected, exitCode);
    }

    @Test
    void appTestRelativePathBothFiles() throws Exception {
        String filePath1 = "src/test/resources/appTest/appTestRelativePathBothFiles_file1.json";
        String filePath2 = "src/test/resources/appTest/appTestRelativePathBothFiles_file1.json";

        String[] args = {filePath1, filePath2};
        int expected = 0;
        int exitCode = new CommandLine(new App()).execute(args);
        Assertions.assertEquals(expected, exitCode);
    }
}
