package ru.numbdev.mycalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
public class MyCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCalendarApplication.class, args);
    }

}
