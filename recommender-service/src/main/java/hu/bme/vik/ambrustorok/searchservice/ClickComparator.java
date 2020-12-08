package hu.bme.vik.ambrustorok.searchservice;

import java.util.Comparator;
import java.util.Map;
import java.util.UUID;

public class ClickComparator implements Comparator<Map.Entry<UUID, Map<String, Integer>>> {
    @Override
    public int compare(Map.Entry<UUID, Map<String, Integer>> first, Map.Entry<UUID, Map<String, Integer>> second) {
        return Integer.compare(first.getValue().values().stream().reduce(0, Integer::sum), second.getValue().values().stream().reduce(0, Integer::sum));
    }

}
