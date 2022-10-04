package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class FormatterTest {

    public static final int TEST_INT_VALUE = 45;
    private Map<String, Object> dataMapAdded = new HashMap<>();
    private Map<String, Object> dataMapDeleted = new HashMap<>();
    private Map<String, Object> dataMapUnchanged = new HashMap<>();
    private Map<String, Object> dataMapUpdated = new HashMap<>();
    private List<Map<String, Object>> dataList = new ArrayList<>();
    private ArrayList<Integer> nestedValue =
            new ArrayList<Integer>(Arrays.asList(TEST_INT_VALUE, TEST_INT_VALUE, TEST_INT_VALUE));

    @BeforeEach
    public final void initMaps() {
        dataMapAdded.put("key", "setting1");
        dataMapAdded.put("type", "added");
        dataMapAdded.put("value", "Some value");

        dataMapUnchanged.put("key", "default");
        dataMapUnchanged.put("type", "none");
        dataMapUnchanged.put("value", null);

        dataMapDeleted.put("key", "id");
        dataMapDeleted.put("type", "removed");
        dataMapDeleted.put("value", TEST_INT_VALUE);

        dataMapUpdated.put("key", "setting3");
        dataMapUpdated.put("type", "updated");
        dataMapUpdated.put("oldValue", true);
        dataMapUpdated.put("newValue", nestedValue);

        dataList.add(dataMapAdded);
        dataList.add(dataMapUnchanged);
        dataList.add(dataMapDeleted);
        dataList.add(dataMapUpdated);
    }

    @Test
    void formatterTestBaseStylish() throws Exception {
        String format = "stylish";

        String expectedResult = "{\n"
                + "  + setting1: Some value\n"
                + "    default: null\n"
                + "  - id: 45\n"
                + "  - setting3: true\n"
                + "  + setting3: [45, 45, 45]\n"
                + "}";
        Assertions.assertEquals(expectedResult, Formatter.toConvertWithFormat(dataList, format));
    }

    @Test
    void formatterTestBasePlain() throws Exception {
        String format = "plain";
        String expectedResult = "Property 'setting1' was added with value: 'Some value'\n"
                + "Property 'id' was removed\n"
                + "Property 'setting3' was updated. From true to [complex value]";
        Assertions.assertEquals(expectedResult, Formatter.toConvertWithFormat(dataList, format));
    }

    @Test
    void formatterTestBaseJson() throws Exception {
        String format = "json";
        String expectedResult = "{\n" +
                "\"setting1\":{\"action\":\"added\",\"value\":\"Some value\"},\n" +
                "\"default\":{\"action\":\"none\"},\n" +
                "\"id\":{\"action\":\"removed\"},\n" +
                "\"setting3\":{\"newValue\":[45,45,45],\"action\":\"updated\",\"previousValue\":true}\n" +
                "}";
        Assertions.assertEquals(expectedResult, Formatter.toConvertWithFormat(dataList, format));
    }

    @Test
    void formatterTestIncorrectFormat() throws Exception {
        String format = "style";
        String expectedResult = "No output for such format as " + format
                + ". Please specify existing format for information output";
        Assertions.assertEquals(expectedResult, Formatter.toConvertWithFormat(dataList, format));
    }
}
