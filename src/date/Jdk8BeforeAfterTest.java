package date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * JDK 8 之前日期处理
 */
public class Jdk8BeforeAfterTest {

    /**
     * DateTimeFormatter  格式化或解析日期、时间
     */
    @Test
    public void dateTimeFormatter(){
        //方式一
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //日期转字符串
        String dateStr = formatter.format(LocalDateTime.now());
        System.out.println(dateStr);
        //字符串转日期
        TemporalAccessor temporalAccessor = formatter.parse(dateStr);
        System.out.println(temporalAccessor);

        //方式二
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        System.out.println(formatter2.format(LocalDateTime.now()));

        //方式三
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter3.format(LocalDateTime.now()));
    }

    /**
     * Instant 瞬时
     */
    @Test
    public void instantTest(){
        //时区不同，相差8个小时
        Instant instant = Instant.now();
        System.out.println(instant);

        //将8小时时差调整
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取时间戳
        long milli = instant.toEpochMilli();

        //根据时间戳创建指定时间
        Instant instant2 = Instant.ofEpochMilli(milli);
    }

    /**
     * LocalDate 获取的是 yyyy-MM-dd 格式的时间
     * LocalTime 获取的是 HH24:mm:ss.ms 格式的时间
     * LocalDateTime 获取的是 日期整体值
     */
    @Test
    public void loaclTest(){
        //now() 获取当前时间
        LocalDate localDate = LocalDate.now();  //yyyy-MM-dd
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now(); //HH24:mm:ss.ms
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //创建指定 年、月、日、时、分、秒 时间
        LocalDateTime.of(2020, 12, 12, 12, 12, 12);

        //getXxx()   获取指定时间类型值
        System.out.println(localDateTime.getDayOfYear());

        //withXxx()   设置指定时间类型值
        LocalDateTime localDateTime3 = localDateTime.withSecond(23);
        System.out.println(localDateTime3);

        //plusXxx()   对指定时间值进行加
        //minusXxx()   对指定时间值进行减
    }

}
