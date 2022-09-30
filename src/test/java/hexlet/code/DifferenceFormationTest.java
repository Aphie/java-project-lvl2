package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferenceFormationTest {

    Map<String, Object> data1Map = new HashMap<>();
    Map<String, Object> data2Map = new HashMap<>();
    Map<String, Object> dataMapExpected = new HashMap<>();
    List<Map<String, Object>> dataList = new ArrayList<>();

    @Test
    void diffFormationAddedTest() {
        data2Map.put("setting", "value");
        dataMapExpected.put("key", "setting");
        dataMapExpected.put("type", "added");
        dataMapExpected.put("value", "value");
        dataList.add(dataMapExpected);

        Assertions.assertEquals(dataList, DifferenceFormation.diffFormation(data1Map, data2Map));
    }

    @Test
    void diffFormationDeletedTest() {
        data1Map.put("setting", "value");
        dataMapExpected.put("key", "setting");
        dataMapExpected.put("type", "removed");
        dataMapExpected.put("value", "value");
        dataList.add(dataMapExpected);

        Assertions.assertEquals(dataList, DifferenceFormation.diffFormation(data1Map, data2Map));
    }

    @Test
    void diffFormationUnchangedTest() {
        data1Map.put("setting", "value");
        data2Map.put("setting", "value");
        dataMapExpected.put("key", "setting");
        dataMapExpected.put("type", "none");
        dataMapExpected.put("value", "value");
        dataList.add(dataMapExpected);

        Assertions.assertEquals(dataList, DifferenceFormation.diffFormation(data1Map, data2Map));
    }

    @Test
    void diffFormationUpdatedTest() {
        data1Map.put("setting", "value 1");
        data2Map.put("setting", "value 2");
        dataMapExpected.put("key", "setting");
        dataMapExpected.put("type", "updated");
        dataMapExpected.put("oldValue", "value 1");
        dataMapExpected.put("newValue", "value 2");
        dataList.add(dataMapExpected);

        Assertions.assertEquals(dataList, DifferenceFormation.diffFormation(data1Map, data2Map));
    }

    @Test
    void diffFormationNoDiffTest() {
        Assertions.assertEquals(dataList, DifferenceFormation.diffFormation(data1Map, data2Map));
    }
}
