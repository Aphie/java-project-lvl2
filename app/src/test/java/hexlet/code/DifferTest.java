package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {
    public static final String FORMAT = "stylish";

    @Test
    void differTestBaseWithFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected = Files.readString(Paths.get("src/test/resources/differTest/differTestBase_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestBaseWithoutFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected = Files.readString(Paths.get("src/test/resources/differTest/differTestBase_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestFirstFileEmpty() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestFirstFileEmpty_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestFirstFileEmpty_file2.json";

        String expected =
                Files.readString(Paths.get("src/test/resources/differTest/differTestFirstFileEmpty_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestSecondFileEmpty() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestSecondFileEmpty_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestSecondFileEmpty_file2.json";

        String expected = Files.readString(
                Paths.get("src/test/resources/differTest/differTestSecondFileEmpty_expected.txt"));
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestBothFileEmpty() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBothFileEmpty_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBothFileEmpty_file2.json";

        String expected = "{\n}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestBothFileSame() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestbothFileSame_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestbothFileSame_file2.json";

        String expected = Files.readString(
                Paths.get("src/test/resources/differTest/differTestbothFileSame_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestAllLinesDeleted() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestAllLinesDeleted_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestAllLinesDeleted_file2.json";

        String expected = Files.readString(
                Paths.get("src/test/resources/differTest/differTestAllLinesDeleted_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestAllLinesChanged() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestAllLinesChanged_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestAllLinesChanged_file2.json";

        String expected = Files.readString(
                Paths.get("src/test/resources/differTest/differTestAllLinesChanged_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }
}
