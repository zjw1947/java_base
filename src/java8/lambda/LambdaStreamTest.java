package java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream关注的是对数据的运算，与cpu打交道
 *
 * stream 说明
 *      1.不会存储对象
 *      2.不会改变源对象。相反，会返回一个结果的新stream
 *      3.操作是延迟执行的，意味着需要等到结果的时候才执行
 *
 *
 *
 * @author zjw
 * @create 2021-02-08
 **/
public class LambdaStreamTest {

    /**
     * stream创建方式
     */
    @Test
    public void initTest(){
        //通过集合
        List<String> list = Arrays.asList("张三", "李四", "王五");
        Stream<String> stream = list.stream();
        Stream<String> paralleStream = list.parallelStream(); //返回一个并行流

        //通过数组
        int[] arr = new int[]{3, 5, 6, 1};
        IntStream intStream = Arrays.stream(arr);

        //通过stream的of()
        Stream<Integer> integerStream = Stream.of(1,5,3,2);

        //创建无限流
        Stream.iterate(0, s -> s + 1).limit(10).forEach(System.out:: println);
        Stream.generate(Math::random).limit(10).forEach(System.out:: println);
    }


    /**
     * 中间操作
     */
    @Test
    public void middleOperation(){
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("小红", 2, "公"));
        list.add(new Dog("小橙", 5, "母"));
        list.add(new Dog("小黄", 1, "公"));
        list.add(new Dog("小绿", 3, "母"));
        list.add(new Dog("小蓝", 9, "公"));

        //对数据进行筛选
        //过滤
        list.stream().filter(s -> s.getName().contains("蓝")).forEach(System.out::println);

        //截断流  获取指定前几个的值
        list.stream().limit(2).forEach(System.err::println);

        //跳过元素  从第几个值之后开始， 若不足则返回空流
        list.stream().limit(2).forEach(System.out::println);

        //排重  通过hashcode() 与 equals() 方法进行排重
        list.stream().distinct().forEach(System.err::println);



        //映射
        //获取具体值
        list.stream().map(s -> s.getName()).forEach(System.out::println);

        //接收一个函数为参数，将流中的每个值都换成另一个流，所有流连成一个流
        List list2 = new ArrayList<>();
        list.add(new Dog("小红", 2, "公"));
        list.add(new Dog("小橙", 5, "母"));
        list2.add(list);
        list2.stream().flatMap(s -> list2.stream()).forEach(System.err::println);



        //排序
        list.stream().sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge())).forEach(System.out::println);
    }

    /**
     * 终止操作
     */
    @Test
    public void terminatingOperation(){
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("小红", 2, "公"));
        list.add(new Dog("小橙", 5, "母"));
        list.add(new Dog("小黄", 1, "公"));
        list.add(new Dog("小绿", 3, "母"));
        list.add(new Dog("小蓝", 9, "公"));

        //匹配与查找
        //是否匹配所有元素
        System.out.println("是否匹配所有元素： "+ list.stream().allMatch(s -> s.getName().contains("小")));

        //是否匹配部分元素
        System.err.println("是否匹配部分元素： "+ list.stream().anyMatch(s -> s.getName().contains("蓝")));

        //是否没有匹配元素
        System.out.println("是否没有匹配元素： "+ list.stream().noneMatch(s -> s.getName().contains("蓝")));

        //查找第一个元素
        System.err.println("查找第一个元素： "+ list.stream().findFirst());

        //获取流中任意元素
        System.out.println("获取流中任意元素： "+ list.stream().findAny());

        //查找结果总数
        System.err.println("查找结果总数： "+ list.stream().count());

        //查找某个参数最大的值
        System.out.println("查找某个参数最大的值： "+ list.stream().max((s1, s2) -> s1.getAge() - s2.getAge()));
        System.err.println("查找某个参数最大的值： "+ list.stream().map(s -> s.getAge()).max(Integer::compare));

        //查找某个参数最小的值
        System.out.println("查找某个参数最小的值： "+ list.stream().map(s -> s.getAge()).min(Integer::compare));

        //归约
        //获取总和
        System.err.println("获取总和： "+ list.stream().map(Dog::getAge).reduce((d1, d2) -> d1 + d2));
        System.out.println("获取总和： "+ list.stream().map(Dog::getAge).reduce(0, Integer::sum));

        //收集
        //将符合添加的值进行整合
        System.err.println("将符合添加的值进行整合： "+ list.stream().filter(s -> "公".equals(s.getSex())).collect(Collectors.toList()));
    }
}
