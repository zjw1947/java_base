package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    /**
     * 反射基本
     */
    @Test
    public void baseTest() throws Exception {
        //方式一：调用运行时类的对象
        /*Person person = new Person();
        Class clazz = person.getClass();*/
        //方式二： 调用运行时类的属性
//        Class clazz = Person.class;
        //方式三： 调用Class的静态方法
        Class clazz = Class.forName("reflect.Person");
        //方式四： 使用类的加载器
        /*ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class clazz = classLoader.loadClass("reflect.Person");*/

        //获取构造器
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        //创建对象
        Object obj = constructor.newInstance("张三", 12);
        System.out.println(obj);
        //设置属性值
        Field field = clazz.getDeclaredField("age");
        field.set(obj, 22);
        System.out.println(obj);
        //调用对象方法
        Method method = clazz.getDeclaredMethod("show");
        method.invoke(obj);
    }

}
