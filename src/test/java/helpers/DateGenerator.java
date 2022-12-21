package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {

    public static String getTodayData() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }

    public static String setFutureDate(int daysToAdd){
        LocalDate dateObj = LocalDate.now().plusDays(daysToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }
}
