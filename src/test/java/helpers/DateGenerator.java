package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
    private static DateTimeFormatter dateTimeFormatter;
    private static LocalDate localDate;

    public static String getTodayData() {
        localDate = LocalDate.now();
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(dateTimeFormatter);
    }

    public static String setFutureDate(int daysToAdd) {
        localDate = LocalDate.now().plusDays(daysToAdd);
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(dateTimeFormatter);
    }
}