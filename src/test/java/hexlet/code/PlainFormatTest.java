package hexlet.code;

import hexlet.code.formatters.PlainFormat;
import hexlet.code.formatters.StylishFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class PlainFormatTest {
    @Test
    void plainFormatTestUnchangedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("unchanged setting1", "Some value");

        String expectedResult = "\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestAddString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: 'Some value'\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestDeleteString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("deleted setting1", "Some value");

        String expectedResult = "\n"
                + "Property 'setting1' was removed\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestChangeAddedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("chan+ setting1", "Some value");

        String expectedResult = "\n'Some value'\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestChangeDeletedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("change- setting1", "Some value");

        String expectedResult = "\n"
                + "Property 'setting1' was updated. From 'Some value' to ";;
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: 'Some value'\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", 5);

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: 5\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfBooleanValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", true);

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: true\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfArrayListIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Integer> nestedValue = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        data.put("added setting1", nestedValue);

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: [complex value]\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfArrayListCharacterValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Character> nestedValue = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        data.put("added setting1", nestedValue);

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: [complex value]\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfArrayListStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<String> nestedValue = new ArrayList<String>(Arrays.asList("value1", "value2"));
        data.put("added setting1", nestedValue);

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: [complex value]\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestOutputOfLinkedHashMapValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        LinkedHashMap<String, String> nestedValue = new LinkedHashMap<>();
        nestedValue.put("nestedKey", "value");
        nestedValue.put("isNested", "true");
        data.put("added setting1", nestedValue);

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: [complex value]\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }

    @Test
    void plainFormatTestAddNull() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "null");

        String expectedResult = "\n"
                + "Property 'setting1' was added with value: null\n";
        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(data));
    }
}
