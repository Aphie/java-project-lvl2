//package hexlet.code;
//
//import hexlet.code.formatters.PlainFormat;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//
//public class PlainFormatTest {
//
//    public static final int TEST_INT_VALUE = 45;
//    private Map<String, Object> dataMap = new HashMap<>();
//    private List<Map<String, Object>> dataList = new ArrayList<>();
//
//    @BeforeEach
//    public final void initMap() {
//        dataMap.put("key", "setting1");
//    }
//
//    @Test
//    void plainFormatTestUnchangedString() {
//        dataMap.put("type", "none");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestAddString() {
//        dataMap.put("type", "added");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: 'Some value'";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestDeleteString() {
//        dataMap.put("type", "removed");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was removed";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestUpdateString() {
//        dataMap.put("type", "updated");
//        dataMap.put("oldValue", "Some value 1");
//        dataMap.put("newValue", "Some value 2");
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key")
//                + "' was updated. From 'Some value 1' to 'Some value 2'";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//
//    @Test
//    void plainFormatTestOutputOfStringValue() {
//        dataMap.put("type", "added");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: 'Some value'";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestOutputOfIntValue() {
//        dataMap.put("type", "added");
//        dataMap.put("value", TEST_INT_VALUE);
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: " + TEST_INT_VALUE;
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestOutputOfBooleanValue() {
//        dataMap.put("type", "added");
//        dataMap.put("value", true);
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: true";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestOutputOfArrayListIntValue() {
//        ArrayList<Integer> nestedValue =
//                new ArrayList<Integer>(Arrays.asList(TEST_INT_VALUE, TEST_INT_VALUE, TEST_INT_VALUE));
//        dataMap.put("type", "added");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: [complex value]";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestOutputOfArrayListCharacterValue() {
//        ArrayList<Character> nestedValue = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
//        dataMap.put("type", "added");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: [complex value]";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestOutputOfArrayListStringValue() {
//        ArrayList<String> nestedValue = new ArrayList<String>(Arrays.asList("value1", "value2"));
//        dataMap.put("type", "added");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: [complex value]";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestOutputOfLinkedHashMapValue() {
//        LinkedHashMap<String, String> nestedValue = new LinkedHashMap<>();
//        nestedValue.put("nestedKey", "value");
//        nestedValue.put("isNested", "true");
//        dataMap.put("type", "added");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: [complex value]";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//
//    @Test
//    void plainFormatTestAddNull() {
//        dataMap.put("type", "added");
//        dataMap.put("value", null);
//        dataList.add(dataMap);
//
//        String expectedResult = "Property '" + dataMap.get("key") + "' was added with value: null";
//        Assertions.assertEquals(expectedResult, PlainFormat.convertToPlainFormat(dataList));
//    }
//}
