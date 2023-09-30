package second;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {
    public static void goToNextCourse(HashMap<String, Double> studMap) {
        for(Iterator<Map.Entry<String, Double>> it = studMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Double> entry = it.next();
            if(entry.getValue() < 3) {
                it.remove();
            } else {
                System.out.println(entry.getKey() + " переведён на следующий курс (куда уж дальше) ");
            }
        }

        //Или
        /*studMap.entrySet().removeIf(e -> e.getValue()<3);
        studMap.forEach((key, value) -> System.out.println(
                key + " переведён на следующий курс (куда уж дальше) "));*/
        System.out.println("====================");
    }

    public static void analysis (String input) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            if (!freqMap.containsKey(ch)) {
                freqMap.put(ch, 1);
            }
            else {
                freqMap.put(ch, freqMap.get(ch) + 1);
            }
        }
        Map<Character, Integer> sortedMap = sortMapByKey(freqMap);
        printEntrySet(sortedMap);
        sortedMap = sortMapByValueReverseOrder(freqMap);
        printEntrySet(sortedMap);

    }

    public static <V> Map<Character, V> sortMapByKey(Map<Character, V> inputMap) {
        return inputMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
    public static <T> Map<T, Integer> sortMapByValueReverseOrder(Map<T, Integer> inputMap) {
        return inputMap.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static <T,V> void printEntrySet(Map<T, V> map) {
        for (Map.Entry<T, V> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("=======================");
    }
}
