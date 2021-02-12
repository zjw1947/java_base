package java8.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * lambda 使用示例
 *
 * 语法：
 *      一： 无参，无返回值
 *          Runnable r = () -> {System.out.println("");};
 *      二： 有参数，无返回值
 *          Runnable r = (String m) -> {System.out.println(m);};
 *      三： 参数数据类型可以省略，有编译器推断得出-类型推断
 *          Runnable r = (m) -> {System.out.println(m);};
 *      四： 值需要一个参数，参数小括号可以省略
 *          Runnable r = m -> {System.out.println(m);};
 *      五： 两个及以上参数，多条执行语句，且有返回值
 *          Runnable r = (m, n) -> {
 *              System.out.println(m);
 *              return n;
 *          };
 *      六： 只有一条执行语句，return与大括号都可以省略
 *          Runnable r = m -> System.out.println(m);
 *
 * @author zjw
 * @create 2021-02-03
 **/
public class LambdaTest {

    /**
     * 方法简化
     */
    @Test
    public void test1(){
        System.out.println("原始写法");
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(12, 15));

        System.out.println("lambda表达式写法");
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(12, 15));

        System.out.println("方法引用");
        Comparator<Integer> com3 = Integer :: compare;
        System.out.println(com2.compare(12, 15));
    }

}
