package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {
    public static final String STYLISH_FORMAT = "stylish";
    public static final String PLAIN_FORMAT = "plain";
    public static final String JSON_FORMAT = "json";

    @Test
    void differTestBaseWithFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected = Files.readString(Paths.get("src/test/resources/differTest/differTestBase_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
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
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestBothFileEmpty() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBothFileEmpty_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBothFileEmpty_file2.json";

        String expected = "{\n}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestBothFileSame() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestbothFileSame_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestbothFileSame_file2.json";

        String expected = Files.readString(
                Paths.get("src/test/resources/differTest/differTestbothFileSame_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestAllLinesDeleted() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestAllLinesDeleted_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestAllLinesDeleted_file2.json";

        String expected = Files.readString(
                Paths.get("src/test/resources/differTest/differTestAllLinesDeleted_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestAllLinesChanged() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestAllLinesChanged_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestAllLinesChanged_file2.json";

        String expected = Files.readString(
                Paths.get("src/test/resources/differTest/differTestAllLinesChanged_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestJsonFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected =
                Files.readString(Paths.get("src/test/resources/differTest/differTestJsonFormat_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, JSON_FORMAT));
    }

    @Test
    void differTestPlainFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected =
                Files.readString(Paths.get("src/test/resources/differTest/differTestPlainFormat_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, PLAIN_FORMAT));
    }

    @Test
    void differTestIncorrectFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";
        String format = "style";
        String expectedResult = "No output for such format as " + format
                + ". Please specify existing format for information output";

        try {
            Differ.generate(filePath1, filePath2, format);
        } catch (RuntimeException e) {
            Assertions.assertEquals(expectedResult, e.getMessage());

        }
    }

    @Test
    void differTestYml() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestYml_file1.yml";
        String filePath2 = "src/test/resources/differTest/differTestYml_file2.yml";

        String expected =
                Files.readString(Paths.get("src/test/resources/differTest/differTestYml_expected.txt"));

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestNoFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/differTestYml_fil";
        String filePath2 = "src/test/resources/differTest/differTestYml_file2.yml";

        String expectedResult = "ERROR: ERROR: You've entered incorrect file, filename or filename that doesn't exist";

        Assertions.assertEquals(expectedResult, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestIncorrectFileFormat() throws Exception {
        String filePath1 = "src/test/resources/differTest/incorrectFormat.gif";
        String filePath2 = "src/test/resources/differTest/differTestYml_file2.yml";

        String expectedResult = "ERROR: You've entered filename with incorrect format. "
                + "Please, enter json or yml files only";

        Assertions.assertEquals(expectedResult, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

}
