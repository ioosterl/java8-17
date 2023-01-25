package mypackage;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class CollectionsFactoryMethods {


    public static void main(String[] args) {
        List<String> myList = List.of("hello", "world");

        Set<Integer> mySet = Set.of(1,2,3,4);

        //Up to 10 key-value pairs
        Map<String,String> stringMap = Map.of("Key", "value", "other key", "some value");
        Map<String,Long> longMap = Map.of("Key", 5L, "other key", 6L);

        //More than 10 key-value pairs
        Map<String, Integer> integerMap = Map.ofEntries(entry("key1", 1),
                entry("key2", 2));

    }
}
