//package hexlet.code;
//
//import hexlet.code.formatters.StylishFormat;
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
//public class StylishFormatTest {
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
//    void stylishFormatTestUnchangedString() {
//        dataMap.put("type", "none");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": Some value\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestAddedString() {
//        dataMap.put("type", "added");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "  + " + dataMap.get("key") + ": Some value\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestDeletedString() {
//        dataMap.put("type", "removed");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "  - " + dataMap.get("key") + ": Some value\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestUpdatedString() {
//        dataMap.put("type", "updated");
//        dataMap.put("oldValue", "Some value 1");
//        dataMap.put("newValue", "Some value 2");
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "  - " + dataMap.get("key") + ": Some value 1\n"
//                + "  + " + dataMap.get("key") + ": Some value 2\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//
//    @Test
//    void stylishFormatTestOutputOfStringValue() throws Exception {
//        dataMap.put("type", "none");
//        dataMap.put("value", "Some value");
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": Some value\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestOutputOfIntValue() {
//        dataMap.put("type", "none");
//        dataMap.put("value", TEST_INT_VALUE);
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": " + TEST_INT_VALUE + "\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestOutputOfBooleanValue() {
//        dataMap.put("type", "none");
//        dataMap.put("value", true);
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": true\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestOutputOfArrayListIntValue() {
//        ArrayList<Integer> nestedValue =
//                new ArrayList<Integer>(Arrays.asList(TEST_INT_VALUE, TEST_INT_VALUE, TEST_INT_VALUE));
//        dataMap.put("type", "none");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": [" + TEST_INT_VALUE + ", "
//                + TEST_INT_VALUE + ", " + TEST_INT_VALUE + "]\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestOutputOfArrayListCharacterValue() {
//        ArrayList<Character> nestedValue = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
//        dataMap.put("type", "none");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": [a, b, c]\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestOutputOfArrayListStringValue() {
//        ArrayList<String> nestedValue = new ArrayList<String>(Arrays.asList("value1", "value2"));
//        dataMap.put("type", "none");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": [value1, value2]\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//
//    @Test
//    void stylishFormatTestOutputOfLinkedHashMapValue() {
//        LinkedHashMap<String, String> nestedValue = new LinkedHashMap<>();
//        nestedValue.put("nestedKey", "value");
//        nestedValue.put("isNested", "true");
//        dataMap.put("type", "none");
//        dataMap.put("value", nestedValue);
//        dataList.add(dataMap);
//
//        String expectedResult = "{\n"
//                + "    " + dataMap.get("key") + ": {nestedKey=value, isNested=true}\n"
//                + "}";
//        Assertions.assertEquals(expectedResult, StylishFormat.convertToStylishFormat(dataList));
//    }
//}
