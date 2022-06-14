package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifferTest {

    @Test
    void differTestBase() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTestBase_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTestBase_file2.json");

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestFirstFileEmpty() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTestFirstFileEmpty_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTestFirstFileEmpty_file2.json");

        String expected = "{\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestSecondFileEmpty() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTestSecondFileEmpty_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTestSecondFileEmpty_file2.json");

        String expected = "{\n"
                + "  - host: hexlet.io\n"
                + "  - timeout: 50\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestBothFileEmpty() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTestBothFileEmpty_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTestBothFileEmpty_file2.json");

        String expected = new String();
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestBothFileSame() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTestbothFileSame_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTestbothFileSame_file2.json");

        String expected = "{\n"
                + "    follow: false\n"
                + "    host: hexlet.io\n"
                + "    proxy: 123.234.53.22\n"
                + "    timeout: 50\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestAllLinesDeleted() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTestAllLinesDeleted_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTestAllLinesDeleted_file2.json");

        String expected = "{\n"
                + "  - follow: false\n"
                + "  - host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + verbose: true\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestAllLinesChanged() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTestAllLinesChanged_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTestAllLinesChanged_file2.json");

        String expected = "{\n"
                + "  - follow: false\n"
                + "  + follow: true\n"
                + "  - host: hexlet.io\n"
                + "  + host: hexlet\n"
                + "  - proxy: 123.234.53.22\n"
                + "  + proxy: 123.234.53.20\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }
}
