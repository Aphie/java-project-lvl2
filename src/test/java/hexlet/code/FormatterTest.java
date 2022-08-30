package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class FormatterTest {

    @Test
    void formatterTestBaseStylish() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("+ setting1", "Some value");
        data.put(" default", "null");
        data.put("- id", "45");
        String format = "stylish";
        String expectedResult = "{\n"
                + "  + setting1: Some value\n"
                + "    default: null\n"
                + "  - id: 45\n"
                + "}";
        Assertions.assertEquals(expectedResult, Formatter.toFormate(data, format));
    }

    @Test
    void formatterTestIncorrectFormat() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("+ setting1", "Some value");
        data.put(" default", "null");
        data.put("- id", "45");
        String format = "style";
        String expectedResult = "No output for such format as " + format
                + ". Please specify existing format for information output";
        Assertions.assertEquals(expectedResult, Formatter.toFormate(data, format));
    }
}
