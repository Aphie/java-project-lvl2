package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ParserTest {

    @Test
    void parserTestBaseJson() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestBaseJson.json");
        Map<String, String> expected = Map.of("host", "hexlet.io", "timeout", "50", "proxy", "123.234.53.22", "follow", "false");
        Assertions.assertEquals(expected, Parser.getData(filePath.toString(), Files.readString(filePath)));
    }

    @Test
    void parserTestBaseYml() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestBaseYml.yml");
        Map<String, String> expected = Map.of("host", "hexlet.io", "timeout", "50", "proxy", "123.234.53.22", "follow", "false");
        Assertions.assertEquals(expected, Parser.getData(filePath.toString(), Files.readString(filePath)));
    }

    @Test
    void parserTestNoFormat() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestNoFormat");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Parser.getData(filePath.toString(), Files.readString(filePath));
        });
        Assertions.assertEquals("ERROR: You entered filename without file format or tried to parse file with incorrect format", thrown.getMessage());
    }

    @Test
    void parserTestIncorrectFormat() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTestIncorrectFormat.txt");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Parser.getData(filePath.toString(), Files.readString(filePath));
        });
        Assertions.assertEquals("ERROR: You entered filename without file format or tried to parse file with incorrect format", thrown.getMessage());
    }

    @Test
    void parserTestSeveralDotsInName() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/parserTest.Several.DotsIn.Name.json");
        Map<String, String> expected = Map.of("host", "hexlet.io", "timeout", "50", "proxy", "123.234.53.22", "follow", "false");
        Assertions.assertEquals(expected, Parser.getData(filePath.toString(), Files.readString(filePath)));
    }

    @Test
    void parserTestSeveralDotsInPath() throws Exception {
        Path filePath = Paths.get("src/test/resources/parserTest/.json/.yml/parserTestSeveralDotsInPath.yml");
        Map<String, String> expected = Map.of("host", "hexlet.io", "timeout", "50", "proxy", "123.234.53.22", "follow", "false");
        Assertions.assertEquals(expected, Parser.getData(filePath.toString(), Files.readString(filePath)));
    }
}
