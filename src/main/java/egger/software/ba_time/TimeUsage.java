package egger.software.ba_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeUsage {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        Instant later = now.plus(10, ChronoUnit.SECONDS);
        System.out.println(later);

        Duration duration = Duration.between(now, later);
        System.out.println(duration);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Canada/Mountain"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.getDayOfWeek());
        System.out.println(zonedDateTime.getOffset());
        System.out.println(zonedDateTime.toInstant());
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("HH:mm")));

        LocalDateTime localDateTime = LocalDateTime.now();
        //No zone info (for birthdays etc)
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfWeek());
        //System.out.println(localDateTime.getOffset());
        //System.out.println(localDateTime.toInstant());

        localDateTime = LocalDateTime.parse("2015-06-20_20:45" , DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm"));
        System.out.println(localDateTime);

        localDateTime = LocalDateTime.of(2015, Month.APRIL, 30, 12, 25);
        System.out.println(localDateTime);
    }
}
