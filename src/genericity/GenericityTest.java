package genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型：可以有多个参数
 *      定义异常类与静态方法（不会泛型方法）不能使用泛型
 */
public class GenericityTest {

    /**
     * 泛型类应用
     */
    @Test
    public void birdTest(){
        //定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object
        //要求：若定义了泛型，建议实例化时指明泛型
        Bird<String> bird = new Bird<String>("张三", 12, "说话");
        System.out.println(bird.getOther());
    }

    /**
     * 泛型方法应用
     */
    @Test
    public void genericityMethod(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(genericityMethod(list));
    }

    //泛型方法，  方法中泛型参数与类的泛型无关
    // 只有给写法才是泛型方法，只是包含泛型并不算泛型方法
    public <E> E genericityMethod(List<E> list){
        return list.get(0);
    }

    /**
     * 通配符  ？  相当于 Object
     */
    @Test
    public void globbingTest(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;

        //对于 List<?> 不能向其内部添加元素，除 null，获取时只能使用Object接收
        List<String> list3 = new ArrayList<>();
        list3.add("111");
        list = list3;
//        list.add("333");
        list.add(null);
    }

    /**
     * 有限制添加的通配符使用
     *      ? extends *
     *          G<? extends A>: 可以作为G<A>和G<B>的父类， B是A的子类
     *      ? super *
     *          G<? super A>: 可以作为G<A>和G<B>的父类， B是A的父类
     */
    @Test
    public void astrictTest(){
        List<? extends Teacher> list1 = null;
        List<? super Teacher> list2 = null;

        List<Student> students = null;
        List<Teacher> teachers = null;
        List<Object> objects = null;

        list1 = students;
        list1 = teachers;
//        list1 = objects;

//        list2 = students;
        list2 = teachers;
        list2 = objects;
    }
}

//泛型继承
class Father<T1, T2>{}

//子类不保留父类的泛型
//没有类型 擦除
class ChildOne<A, B> extends Father{}
//具体类型
class ChildTwo<A, B> extends Father<String, Integer>{}

//子类保留父类的泛型
//全部保留
class ChildThree<T1,T2, A, B> extends Father<T1, T2>{}
//部分保留
class ChildFour<T2, A, B> extends Father<Integer, T2>{}
