package date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * JDK 8 之前日期处理
 */
public class Jdk8BeforeDateTest {

    /**
     * 创建 Calendar 日历类
     */
    @Test
    public void calendatObj(){
        //初始化
        //方式一  创建子类 GregorianCalendar 对象
//        Calendar calendar = new GregorianCalendar();
        //方式二  调用静态方法 getInstance()
        Calendar calendar = Calendar.getInstance();

        //常用方法
        //get()  获取指定的时间值
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        //set()  对指定时间值进行设置
        calendar.set(Calendar.YEAR, 2);
        System.out.println(calendar.get(Calendar.YEAR));
        //add()  对指定时间值进行加减处理
        calendar.add(Calendar.YEAR, 2);
        System.out.println(calendar.get(Calendar.YEAR));
        //getTime()  日历对象转date
        Date date = calendar.getTime();
        //setTime()  date转日历对象
        calendar.setTime(date);
    }

    /**
     * 创建 Date 对象
     */
    @Test
    public void dateObj(){
        //创建当前时间
        Date date = new Date();
        System.out.println(date);

        //获取毫秒值
        date.getTime();

        //创建指定时间
        Date date2 = new Date(34482392L);

        //对时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
    }

    /**
     * System.currentTimeMillis() 获取当前时间戳
     * 获取的是 自 1970年1月1日0时0分0秒 与现在的毫秒值
     */
    @Test
    public void systemDate(){
        System.out.println(System.currentTimeMillis());
    }

}
