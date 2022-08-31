package hexlet.code;

import hexlet.code.formatters.PlainFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class PlainFormatTest {
    public static final int TEST_INT_VALUE = 45;

    @Test
    void plainFormatTestUnchangedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("unchanged setting1", "Some value");

        String expectedResult = "";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestAddString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");

        String expectedResult = "Property 'setting1' was added with value: 'Some value'";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestDeleteString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("deleted setting1", "Some value");

        String expectedResult = "Property 'setting1' was removed";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestChangeAddedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("chan+ setting1", "Some value");

        String expectedResult = "'Some value'";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestChangeDeletedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("change- setting1", "Some value");

        String expectedResult = "Property 'setting1' was updated. From 'Some value' to ";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");

        String expectedResult = "Property 'setting1' was added with value: 'Some value'";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", TEST_INT_VALUE);

        String expectedResult = "Property 'setting1' was added with value: " + TEST_INT_VALUE;
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfBooleanValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", true);

        String expectedResult = "Property 'setting1' was added with value: true";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfArrayListIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Integer> nestedValue =
                new ArrayList<Integer>(Arrays.asList(TEST_INT_VALUE, TEST_INT_VALUE, TEST_INT_VALUE));
        data.put("added setting1", nestedValue);

        String expectedResult = "Property 'setting1' was added with value: [complex value]";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfArrayListCharacterValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Character> nestedValue = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        data.put("added setting1", nestedValue);

        String expectedResult = "Property 'setting1' was added with value: [complex value]";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfArrayListStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<String> nestedValue = new ArrayList<String>(Arrays.asList("value1", "value2"));
        data.put("added setting1", nestedValue);

        String expectedResult = "Property 'setting1' was added with value: [complex value]";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfLinkedHashMapValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        LinkedHashMap<String, String> nestedValue = new LinkedHashMap<>();
        nestedValue.put("nestedKey", "value");
        nestedValue.put("isNested", "true");
        data.put("added setting1", nestedValue);

        String expectedResult = "Property 'setting1' was added with value: [complex value]";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestAddNull() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "null");

        String expectedResult = "Property 'setting1' was added with value: null";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }
}
