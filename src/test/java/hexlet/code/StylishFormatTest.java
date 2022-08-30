package hexlet.code;

import hexlet.code.formatters.StylishFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class StylishFormatTest {
    @Test
    void stylishFormatTestUnchangedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("unchanged setting1", "Some value");

        String expectedResult = "{\n"
                + "    setting1: Some value\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestAddedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("added setting1", "Some value");

        String expectedResult = "{\n"
                + "  + setting1: Some value\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestDeletedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("deleted setting1", "Some value");

        String expectedResult = "{\n"
                + "  - setting1: Some value\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestChangedAddedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("chan+ setting1", "Some value");

        String expectedResult = "{\n"
                + "  + setting1: Some value\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestChangedDeletedString() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("change- setting1", "Some value");

        String expectedResult = "{\n"
                + "  - setting1: Some value\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestOutputOfStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("unchanged setting1", "Some value");

        String expectedResult = "{\n"
                + "    setting1: Some value\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestOutputOfIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("unchanged setting1", 5);

        String expectedResult = "{\n"
                + "    setting1: 5\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestOutputOfBooleanValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("unchanged setting1", true);

        String expectedResult = "{\n"
                + "    setting1: true\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestOutputOfArrayListIntValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Integer> nestedValue = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        data.put("unchanged setting1", nestedValue);

        String expectedResult = "{\n"
                + "    setting1: [1, 2, 3]\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestOutputOfArrayListCharacterValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<Character> nestedValue = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        data.put("unchanged setting1", nestedValue);

        String expectedResult = "{\n"
                + "    setting1: [a, b, c]\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestOutputOfArrayListStringValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        ArrayList<String> nestedValue = new ArrayList<String>(Arrays.asList("value1", "value2"));
        data.put("unchanged setting1", nestedValue);

        String expectedResult = "{\n"
                + "    setting1: [value1, value2]\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }

    @Test
    void stylishFormatTestOutputOfLinkedHashMapValue() throws Exception {
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        LinkedHashMap<String, String> nestedValue = new LinkedHashMap<>();
        nestedValue.put("nestedKey", "value");
        nestedValue.put("isNested", "true");
        data.put("unchanged setting1", nestedValue);

        String expectedResult = "{\n"
                + "    setting1: {nestedKey=value, isNested=true}\n"
                + "}";
        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(data));
    }
}
