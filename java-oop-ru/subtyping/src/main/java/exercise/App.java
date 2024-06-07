package exercise;

import java.util.Map;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalMap = storage.toMap();
        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            storage.unset(entry.getKey());
        }
        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
// END
