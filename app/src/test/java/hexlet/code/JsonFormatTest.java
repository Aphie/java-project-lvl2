package hexlet.code;

import hexlet.code.formatters.JsonFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class JsonFormatTest {

    public static final int TEST_INT_VALUE = 45;
    private Map<String, Object> dataMap = new HashMap<>();
    private List<Map<String, Object>> dataList = new ArrayList<>();

    @BeforeEach
    public final void initMap() {
        dataMap.put("key", "setting1");
    }

    @Test
    void jsonFormatTestUnchangedString() throws Exception {
        dataMap.put("type", "none");
        dataMap.put("value", "Some value");
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"none\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestAddedString() throws Exception {
        dataMap.put("type", "added");
        dataMap.put("value", "Some value");
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": \"Some value\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestDeletedString() throws Exception {
        dataMap.put("type", "removed");
        dataMap.put("value", "Some value");
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"removed\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestUpdateString() throws Exception {
        dataMap.put("type", "updated");
        dataMap.put("oldValue", "Some value 1");
        dataMap.put("newValue", "Some value 2");
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"updated\",\n"
                + "    \"previousValue\": \"Some value 1\",\n"
                + "    \"newValue\": \"Some value 2\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestOutputOfStringValue() throws Exception {
        dataMap.put("type", "added");
        dataMap.put("value", "Some value");
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": \"Some value\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestOutputOfIntValue() throws Exception {
        dataMap.put("type", "added");
        dataMap.put("value", TEST_INT_VALUE);
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": " + TEST_INT_VALUE + "\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestOutputOfBooleanValue() throws Exception {
        dataMap.put("type", "added");
        dataMap.put("value", true);
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": true\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestOutputOfArrayListIntValue() throws Exception {
        ArrayList<Integer> nestedValue =
                new ArrayList<Integer>(Arrays.asList(TEST_INT_VALUE, TEST_INT_VALUE, TEST_INT_VALUE));
        dataMap.put("type", "added");
        dataMap.put("value", nestedValue);
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": [" + TEST_INT_VALUE + "," + TEST_INT_VALUE + "," + TEST_INT_VALUE + "]\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestOutputOfArrayListCharacterValue() throws Exception {
        ArrayList<Character> nestedValue = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        dataMap.put("type", "added");
        dataMap.put("value", nestedValue);
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": [\"a\",\"b\",\"c\"]\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestOutputOfArrayListStringValue() throws Exception {
        ArrayList<String> nestedValue = new ArrayList<String>(Arrays.asList("value1", "value2"));
        dataMap.put("type", "added");
        dataMap.put("value", nestedValue);
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": [\"value1\",\"value2\"]\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }

    @Test
    void jsonFormatTestOutputOfLinkedHashMapValue() throws Exception {
        LinkedHashMap<String, String> nestedValue = new LinkedHashMap<>();
        nestedValue.put("nestedKey", "value");
        nestedValue.put("isNested", "true");
        dataMap.put("type", "added");
        dataMap.put("value", nestedValue);
        dataList.add(dataMap);

        String expectedResult = "{\n"
                + "  \"" + dataMap.get("key") + "\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": {\"nestedKey\":\"value\",\"isNested\":\"true\"}\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(dataList));
    }
}
