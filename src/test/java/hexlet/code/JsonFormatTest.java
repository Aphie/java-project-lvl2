package hexlet.code;

import hexlet.code.formatters.JsonFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class JsonFormatTest {

    public static final int TEST_INT_VALUE = 45;

    @Test
    void jsonFormatTestUnchangedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("unchanged setting1", "Some value");

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"none\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestAddedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": \"Some value\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestDeletedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("deleted setting1", "Some value");

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"removed\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestChangeDeletedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("change- setting1", "Some value");

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"changed\",\n"
                + "    \"previousValue\": \"Some value\"\n"
                + "}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestChangeAddedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("chan+ setting1", "Some value");

        String expectedResult = "{\n"
                + "    \"currentValue\": \"Some value\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestOutputOfStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": \"Some value\"\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestOutputOfIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", TEST_INT_VALUE);

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": " + TEST_INT_VALUE + "\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestOutputOfBooleanValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", true);

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": true\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestOutputOfArrayListIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Integer> nestedValue =
                new ArrayList<Integer>(Arrays.asList(TEST_INT_VALUE, TEST_INT_VALUE, TEST_INT_VALUE));
        data.put("added setting1", nestedValue);

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": [" + TEST_INT_VALUE + "," + TEST_INT_VALUE + "," + TEST_INT_VALUE + "]\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestOutputOfArrayListCharacterValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Character> nestedValue = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        data.put("added setting1", nestedValue);

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": [\"a\",\"b\",\"c\"]\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestOutputOfArrayListStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<String> nestedValue = new ArrayList<String>(Arrays.asList("value1", "value2"));
        data.put("added setting1", nestedValue);

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": [\"value1\",\"value2\"]\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }

    @Test
    void jsonFormatTestOutputOfLinkedHashMapValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        LinkedHashMap<String, String> nestedValue = new LinkedHashMap<>();
        nestedValue.put("nestedKey", "value");
        nestedValue.put("isNested", "true");
        data.put("added setting1", nestedValue);

        String expectedResult = "{\n"
                + "  \"setting1\": {\n"
                + "    \"action\": \"added\",\n"
                + "    \"value\": {\"nestedKey\":\"value\",\"isNested\":\"true\"}\n"
                + "  }\n}";
        Assertions.assertEquals(expectedResult, JsonFormat.convertToJsonFormat(data));
    }
}
