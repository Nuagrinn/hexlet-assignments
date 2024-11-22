package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.LocalTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    public Daytime getDaytime() {
        LocalTime currentTime = LocalDateTime.now().toLocalTime();
        LocalTime dayStart = LocalTime.of(6, 0);
        LocalTime dayEnd = LocalTime.of(22, 0);

        if(currentTime.isAfter(dayStart) && currentTime.isBefore(dayEnd)) {
            return new Day();
        } else {
            return new Night();
        }
    }
    // END
}
