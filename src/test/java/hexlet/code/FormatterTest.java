package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class FormatterTest {

    @Test
    void formatterTestBaseStylish() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");
        data.put("unchanged default", "null");
        data.put("deleted id", 45);
        data.put("change- setting3", true);
        data.put("chan+ setting3", "none");
        String format = "stylish";
        String expectedResult = "{\n"
                + "  + setting1: Some value\n"
                + "    default: null\n"
                + "  - id: 45\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        Assertions.assertEquals(expectedResult, Formatter.toConvertWithFormat(data, format));
    }

    @Test
    void formatterTestBasePlain() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");
        data.put("unchanged default", "null");
        data.put("deleted id", 45);
        data.put("change- setting3", true);
        data.put("chan+ setting3", "none");
        String format = "plain";
        String expectedResult = "\nProperty 'setting1' was added with value: 'Some value'\n"
                + "Property 'id' was removed\n"
                + "Property 'setting3' was updated. From true to 'none'\n";
        Assertions.assertEquals(expectedResult, Formatter.toConvertWithFormat(data, format));
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
        Assertions.assertEquals(expectedResult, Formatter.toConvertWithFormat(data, format));
    }
}