package compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 对 对象进行排序操作
 */
public class CompareTest {

    @Test
    public void test(){
        //类实现 Comparable 接口
        Person[] arr = new Person[4];
        arr[0] = new Person("张三", 12);
        arr[1] = new Person("李四", 2);
        arr[2] = new Person("王五", 16);
        arr[3] = new Person("赵六", 7);
        //调用了实体类的compareTo方法
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //定制排序
        Person[] arr2 = new Person[4];
        arr2[0] = new Person("张三", 12);
        arr2[1] = new Person("李四", 2);
        arr2[2] = new Person("王五", 16);
        arr2[3] = new Person("赵六", 7);
        Arrays.sort(arr2, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() == o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getAge()  > o2.getAge()? 1: -1;
            }
        });
        System.out.println(Arrays.toString(arr2));

    }

}
