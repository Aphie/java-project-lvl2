package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifferTest {
    public static final String FORMAT = "stylish";

    //yml добавить!
    @Test
    void differTestBase() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTest/differTestBase_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTest/differTestBase_file2.json");

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestFirstFileEmpty() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTest/differTestFirstFileEmpty_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTest/differTestFirstFileEmpty_file2.json");

        String expected = "{\n"
                + "  + id: null\n"
                + "  + key2: value2\n"
                + "  + numbers1: [1, 2, 3, 4]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  + setting1: Another value\n"
                + "  + setting2: 300\n"
                + "  + setting3: none\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestSecondFileEmpty() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTest/differTestSecondFileEmpty_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTest/differTestSecondFileEmpty_file2.json");

        String expected = "{\n"
                + "  - chars1: [a, b, c]\n"
                + "  - default: null\n"
                + "  - id: 45\n"
                + "  - key1: value1\n"
                + "  - numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  - setting1: Some value\n"
                + "  - setting2: 200\n"
                + "  - setting3: true\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestBothFileEmpty() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTest/differTestBothFileEmpty_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTest/differTestBothFileEmpty_file2.json");

        String expected = new String();
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestBothFileSame() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTest/differTestbothFileSame_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTest/differTestbothFileSame_file2.json");

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "    chars2: [d, e, f]\n"
                + "    checked: false\n"
                + "    default: null\n"
                + "    id: 45\n"
                + "    key1: value1\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "    numbers2: [2, 3, 4, 5]\n"
                + "    numbers3: [3, 4, 5]\n"
                + "    setting1: Some value\n"
                + "    setting2: 200\n"
                + "    setting3: true\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestAllLinesDeleted() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTest/differTestAllLinesDeleted_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTest/differTestAllLinesDeleted_file2.json");

        String expected = "{\n"
                + "  - chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  - checked: false\n"
                + "  - default: null\n"
                + "  - id: 45\n"
                + "  - key1: value1\n"
                + "  - numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  - setting2: 200\n"
                + "  - setting3: true\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }

    @Test
    void differTestAllLinesChanged() throws Exception {
        Path filePath1 = Paths.get("src/test/resources/differTest/differTestAllLinesChanged_file1.json");
        Path filePath2 = Paths.get("src/test/resources/differTest/differTestAllLinesChanged_file2.json");

        String expected = "{\n"
                + "  - chars1: [aa, bb, cc]\n"
                + "  + chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key1: value2\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        Assertions.assertEquals(expected, Differ.generate(filePath1, filePath2, FORMAT));
    }
}
