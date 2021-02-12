package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用反射创建的对象
 * @author zjw
 * @create 2021-02-01
 **/
public class ReflectRunTest {

    /**
     * 调用属性
     */
    @Test
    public void useFieldTest() throws Exception {
        Class clazz = Person.class;
        //创建对象
        Person person = (Person) clazz.newInstance();
        //获取指定属性
        //getField: 只能获取public 修饰的属性
        Field field = clazz.getDeclaredField("name");
        //设置当前属性可访问
        field.setAccessible(true);
        //设置属性
        field.set(person, "张三");
        System.out.println(person.getName());
    }

    /**
     * 调用方法
     */
    @Test
    public void useMethodTest() throws Exception{
        Class clazz = Person.class;
        //创建对象
        Person person = (Person) clazz.newInstance();
        //获取指定方法
        //参数1：方法名    参数2：形参列表
        Method method = clazz.getDeclaredMethod("ptest", String.class);
        //设置当前方法可调用
        method.setAccessible(true);
        //调用
        //参数2： 形参值
        Object param = method.invoke(person, "test");
        System.out.println(param);

        System.out.println("-----------静态方法-----------");

        Method staticMethod = clazz.getDeclaredMethod("useTest");
        staticMethod.invoke(person);
    }

    /**
     * 调用构造器
     */
    @Test
    public void useConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;
        //获取构造器
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        //设置构造器是可访问的
        constructor.setAccessible(true);
        //创建对象
        Person person = (Person)constructor.newInstance("张三", 12);
        System.out.println(person.toString());
    }
}
