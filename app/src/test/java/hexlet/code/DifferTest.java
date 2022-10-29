package hexlet.code;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DifferTest {
    public static final String STYLISH_FORMAT = "stylish";
    public static final String PLAIN_FORMAT = "plain";
    public static final String JSON_FORMAT = "json";

    public static String toReadFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

    @Test
    void differTestBaseWithFormat() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected = toReadFile("src/test/resources/differTest/differTestBase_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestBaseWithoutFormat() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected = toReadFile("src/test/resources/differTest/differTestBase_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestFirstFileEmpty() {
        String filePath1 = "src/test/resources/differTest/differTestFirstFileEmpty_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestFirstFileEmpty_file2.json";

        try {
            Differ.generate(filePath1, filePath2, STYLISH_FORMAT);
        } catch (IOException e) {
            Assertions.assertEquals(MismatchedInputException.class, e.getClass());
        }
    }

    @Test
    void differTestSecondFileEmpty() {
        String filePath1 = "src/test/resources/differTest/differTestSecondFileEmpty_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestSecondFileEmpty_file2.json";

        try {
            Differ.generate(filePath1, filePath2, STYLISH_FORMAT);
        } catch (IOException e) {
            Assertions.assertEquals(MismatchedInputException.class, e.getClass());
        }
    }

    @Test
    void differTestBothFileEmpty() {
        String filePath1 = "src/test/resources/differTest/differTestBothFileEmpty_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBothFileEmpty_file2.json";

        try {
            Differ.generate(filePath1, filePath2, STYLISH_FORMAT);
        } catch (IOException e) {
            Assertions.assertEquals(MismatchedInputException.class, e.getClass());
        }
    }

    @Test
    void differTestBothFileSame() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestbothFileSame_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestbothFileSame_file2.json";

        String expected = toReadFile("src/test/resources/differTest/differTestbothFileSame_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestAllLinesDeleted() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestAllLinesDeleted_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestAllLinesDeleted_file2.json";

        String expected = toReadFile("src/test/resources/differTest/differTestAllLinesDeleted_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestAllLinesChanged() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestAllLinesChanged_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestAllLinesChanged_file2.json";

        String expected = toReadFile("src/test/resources/differTest/differTestAllLinesChanged_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    void differTestJsonFormat() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected = toReadFile("src/test/resources/differTest/differTestJsonFormat_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, JSON_FORMAT));
    }

    @Test
    void differTestPlainFormat() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestBase_file1.json";
        String filePath2 = "src/test/resources/differTest/differTestBase_file2.json";

        String expected =
                toReadFile("src/test/resources/differTest/differTestPlainFormat_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, PLAIN_FORMAT));
    }

    @Test
    void differTestIncorrectFormat() throws IOException {
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
    void differTestYml() throws IOException {
        String filePath1 = "src/test/resources/differTest/differTestYml_file1.yml";
        String filePath2 = "src/test/resources/differTest/differTestYml_file2.yml";

        String expected = toReadFile("src/test/resources/differTest/differTestYml_expected.txt");

        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, STYLISH_FORMAT));
    }

    @Test
    void differTestNoFormat() {
        String filePath1 = "src/test/resources/differTest/differTestYml_fil";
        String filePath2 = "src/test/resources/differTest/differTestYml_file2.yml";

        try {
            Differ.generate(filePath1, filePath2, STYLISH_FORMAT);
        } catch (IOException e) {
            Assertions.assertEquals(NoSuchFileException.class, e.getClass());
        }
    }

    @Test
    void differTestIncorrectFileFormat() {
        String filePath1 = "src/test/resources/differTest/incorrectFormat.gif";
        String filePath2 = "src/test/resources/differTest/differTestYml_file2.yml";

        try {
            Differ.generate(filePath1, filePath2, STYLISH_FORMAT);
        } catch (IOException e) {
            Assertions.assertEquals(MalformedInputException.class, e.getClass());
        }
    }

}
