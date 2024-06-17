package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class App {
    public static void save(Path path, Car car) {
        String carJson;
        try {
            carJson = car.serialize();
            Files.write(path,carJson.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path path) {
        Car car = null;
        try {
            car = Car.unserialize(Files.readString(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return car;
    }

}
