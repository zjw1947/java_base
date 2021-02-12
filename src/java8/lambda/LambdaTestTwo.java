package java8.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zjw
 * @create 2021-02-07
 **/
public class LambdaTestTwo {

    /**
     * java内置四大核心函数式接口
     *  消费型接口   Consumer<T>      void accept(T t)
     *  供给型接口   Supplier<T>      T get()
     *  函数型接口   Function<T, R>   R apply(T t)
     *  断定型接口   Predicate<T>     boolean test(T t)
     */
    @Test
    public void test(){
        System.out.println("消费型");
        consumerTest("张三", s -> System.out.println("消费型接口实现" + s) );

        System.out.println("供给型");
        System.out.println(predicateTest("张三", s -> s.contains("李")));

    }

    // 消费型
    public void consumerTest(String str, Consumer<String> con){
        con.accept(str);
    }

    // 断定型
    private boolean predicateTest(String str, Predicate<String> predicate){
        return predicate.test(str);
    }

    /**
     * 方法引用
     *      1.使用情境：当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用
     *      2.方法引用：本质上就是lambda表达式，而lambda表达式座位函数式接口的实例
     *      3.使用格式： 类（对象） :: 方法名
     *          三种情况：
     *              对象 :: 非静态方法
     *              类 :: 静态方法
     *              类 :: 非静态方法
     *      4.方法引用使用要求:要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参类表和返回值一致（针对前两种情况）
     *
     */
    @Test
    public void quoteTest(){
        //对象 :: 方法
        PrintStream ps = System.out;
        Consumer<String> con = ps :: println;
        con.accept("张三");

        //类 :: 静态方法
        Comparator<Integer> com = Integer::compareTo;
        System.out.println(com.compare(12, 15));

        //类 :: 非静态方法
        Comparator<String> c = String::compareTo;
        System.out.println(c.compare("张三", "李四"));

    }

}
