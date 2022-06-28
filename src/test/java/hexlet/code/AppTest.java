package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {

    @Test
    void appTestAbsolutePathBothFiles() throws Exception {
        Path filePath1 = Paths.get("C:\\Users\\s.andreyuk\\IdeaProjects\\app\\src\\test\\resources\\appTest\\appTestAbsolutePathBothFiles_file1.json");
        Path filePath2 = Paths.get("C:\\Users\\s.andreyuk\\IdeaProjects\\app\\src\\test\\resources\\appTest\\appTestAbsolutePathBothFiles_file2.json");

        String[] args = {filePath1.toString(), filePath2.toString()};
        int expected = 0;
        int exitCode = new CommandLine(new App()).execute(args);
        Assertions.assertEquals(expected, exitCode);
    }

    @Test
    void appTestRelativePathBothFiles() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/appTest/appTestRelativePathBothFiles_file1.json");
        Path filePath2 = Paths.get("src/test/resources/appTest/appTestRelativePathBothFiles_file1.json");

        String[] args = {filePath1.toString(), filePath2.toString()};
        int expected = 0;
        int exitCode = new CommandLine(new App()).execute(args);
        Assertions.assertEquals(expected, exitCode);
    }
}
