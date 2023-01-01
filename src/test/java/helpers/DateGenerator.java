package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
    private static DateTimeFormatter dateTimeFormatter;
    private static LocalDate localDate;

    public static String getTodayData() {
        localDate = LocalDate.now();
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayDate = localDate.format(dateTimeFormatter);
        return todayDate;
    }

    public static String setFutureDate(int daysToAdd) {
        localDate = LocalDate.now().plusDays(daysToAdd);
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String futureDate = localDate.format(dateTimeFormatter);
        return futureDate;
    }
}