package BOJ.SPROUT;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class BOJ_10699_오늘_날짜 {

    public static void main(String[] args) {
        System.out.print(LocalDate.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ISO_DATE));
    }
}
