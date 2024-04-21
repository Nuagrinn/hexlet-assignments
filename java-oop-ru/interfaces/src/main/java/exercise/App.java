package exercise;

import java.util.List;

// BEGIN
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        Collections.sort(homes);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n && i < homes.size(); i++) {
            result.add(homes.get(i).toString());
        }

        return result;
    }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }
}
// END
