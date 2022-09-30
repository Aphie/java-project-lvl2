package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DifferenceFormation {
    public static List<Map<String, Object>> diffFormation(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> diffList = new ArrayList<>();
        TreeSet<String> resultKeys = new TreeSet<>();

        resultKeys.addAll(data1.keySet());
        resultKeys.addAll(data2.keySet());

        for (String k: resultKeys) {

            if (!data1.containsKey(k)) {
                diffList.add(createMapForOneValue(k, data2.get(k), "added"));
            } else if (!data2.containsKey(k)) {
                diffList.add(createMapForOneValue(k, data1.get(k), "removed"));
            } else {
                if (String.valueOf(data1.get(k)).equals(String.valueOf(data2.get(k)))) {
                    diffList.add(createMapForOneValue(k, data1.get(k), "none"));
                } else {
                    diffList.add(createMapForTwoValues(k, data1.get(k), data2.get(k)));
                }
            }
        }
        return diffList;
    }

    public static Map<String, Object> createMapForTwoValues(Object key, Object oldValue, Object newValue) {
        Map<String, Object> createdMap = new HashMap<>();
        createdMap.put("type", "updated");
        createdMap.put("key", key);
        createdMap.put("oldValue", oldValue);
        createdMap.put("newValue", newValue);
        return createdMap;
    }

    public static Map<String, Object> createMapForOneValue(Object key, Object value, String action) {
        Map<String, Object> createdMap = new HashMap<>();
        createdMap.put("type", action);
        createdMap.put("key", key);
        createdMap.put("value", value);
        return createdMap;
    }

}
