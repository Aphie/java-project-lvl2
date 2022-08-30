package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParserTest {

    @Test
    void parserTestBaseJson() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestBaseJson.json");
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("proxy", "123.234.53.22");
        expectedMap.put("default", "null");
        expectedMap.put("chars1", "[a, b, c]");
        expectedMap.put("host", "hexlet.io");
        expectedMap.put("numbers1", "[1, 2, 3, 4]");
        expectedMap.put("obj1", "{nestedKey=value, isNested=true}");
        expectedMap.put("follow", "false");
        expectedMap.put("timeout", "50");

        boolean expected = true;

        Map<String, Object> actualMap = Parser.getData(filePath.toString(), Files.readString(filePath));
        Assertions.assertEquals(expected, expectedMap.keySet().equals(actualMap.keySet()));

        for (String key: expectedMap.keySet()) {
            if (actualMap.get(key) == null) {
                actualMap.put("default", "null");
            }
            Assertions.assertEquals(expectedMap.get(key).toString(), actualMap.get(key).toString());
        }
    }

    @Test
    void parserTestBaseYml() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestBaseYml.yml");
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("proxy", "123.234.53.22");
        expectedMap.put("default", "null");
        expectedMap.put("chars1", "[a, b, c]");
        expectedMap.put("host", "hexlet.io");
        expectedMap.put("numbers1", "[1, 2, 3, 4]");
        expectedMap.put("obj1", "{nestedKey=value, isNested=true}");
        expectedMap.put("follow", "false");
        expectedMap.put("timeout", "50");
        boolean expected = true;

        Map<String, Object> actualMap = Parser.getData(filePath.toString(), Files.readString(filePath));
        Assertions.assertEquals(expected, expectedMap.keySet().equals(actualMap.keySet()));

        for (String key: expectedMap.keySet()) {
            if (actualMap.get(key) == null) {
                actualMap.put("default", "null");
            }
            Assertions.assertEquals(expectedMap.get(key).toString(), actualMap.get(key).toString());
        }
    }

    @Test
    void parserTestNoFormat() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestNoFormat");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Parser.getData(filePath.toString(), Files.readString(filePath));
        });
        Assertions.assertEquals("ERROR: You entered filename without file format or tried to parse file with"
                + " incorrect format", thrown.getMessage());
    }

    @Test
    void parserTestIncorrectFormat() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestIncorrectFormat.txt");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Parser.getData(filePath.toString(), Files.readString(filePath));
        });
        Assertions.assertEquals("ERROR: You entered filename without file format or tried to parse file with"
                + " incorrect format", thrown.getMessage());
    }

    @Test
    void parserTestSeveralDotsInName() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTest.Several.DotsIn.Name.json");
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("host", "hexlet.io");
        boolean expected = true;

        Map<String, Object> actualMap = Parser.getData(filePath.toString(), Files.readString(filePath));
        Assertions.assertEquals(expected, expectedMap.keySet().equals(actualMap.keySet()));

        for (String key: expectedMap.keySet()) {
            if (actualMap.get(key) == null) {
                actualMap.put("default", "null");
            }
            Assertions.assertEquals(expectedMap.get(key).toString(), actualMap.get(key).toString());
        }
    }

    @Test
    void parserTestSeveralDotsInPath() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/.json/.yml/parserTestSeveralDotsInPath.yml");
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("host", "hexlet.io");
        boolean expected = true;

        Map<String, Object> actualMap = Parser.getData(filePath.toString(), Files.readString(filePath));
        Assertions.assertEquals(expected, expectedMap.keySet().equals(actualMap.keySet()));

        for (String key: expectedMap.keySet()) {
            if (actualMap.get(key) == null) {
                actualMap.put("default", "null");
            }
            Assertions.assertEquals(expectedMap.get(key).toString(), actualMap.get(key).toString());
        }
    }
}
