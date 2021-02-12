package reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 反射学习
 */
public class ReflectTest {

    /**
     * 反射基本-创建对象与设置属性值
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

    /**
     * 属性获取
     */
    @Test
    public void propertyTest(){
        Class clazz = Person.class;

        //获取属性结构： 获取的是 public 修饰的属性
        Field[] fields = clazz.getFields();
        for(Field field: fields){
            System.out.println(field);
        }
        System.out.println("----------------------");

        //获取属性结构： 不考虑权限问题
        Field[] fields1 = clazz.getDeclaredFields();
        for(Field field: fields1){
            System.out.println("参数" + field);
            //修饰符： 值看源码常量
            System.out.println(field.getModifiers());
            //数据类型
            System.out.println(field.getType());
            //变量名
            System.out.println(field.getName());
        }
    }

    /**
     * 获取方法
     */
    @Test
    public void methodTest(){
        Class clazz = Person.class;

        //获取所有修饰符为 public 的方法
        Method[] methods = clazz.getMethods();
        for(Method method: methods){
            System.out.println(method);
        }
        System.out.println("----------------------");

        //不考虑权限问题
        Method[] methods1 = clazz.getMethods();
        for(Method method: methods1){
            System.out.println("方法" + method);
            //获取注解
            for(Annotation annotation: method.getAnnotations()){
                System.out.print(annotation + "   ");
            }
            //修饰符：值看源码常量
            System.out.println(method.getModifiers());
            //返回值类型
            System.out.println(method.getReturnType());
            //方法名
            System.out.println(method.getName());
            //获取参数
            for(Parameter parameter: method.getParameters()){
                System.out.print(parameter + "   ");
            }
            //获取抛出的异常
            for(Object obj: method.getExceptionTypes()){
                System.out.print(obj + "     ");
            }
        }
    }

    /**
     * 属性构造器
     */
    @Test
    public void constructorTest(){
        Class clazz = Person.class;

        //获取构造器： 获取的是 public 修饰的属性
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor: constructors){
            System.out.println(constructor);
        }
        System.out.println("----------------------");

        //获取属性结构： 不考虑权限问题
        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for(Constructor constructor: constructors1){
            System.out.println(constructor);
        }
    }

    /**
     * 获取父类
     */
    @Test
    public void parentTest(){
        Class clazz = Person.class;

//        Class parent = clazz.getSuperclass();
//        System.out.println(parent);

        Type genericSuperclass =  clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        //获取泛型类型
        Type[] types = parameterizedType.getActualTypeArguments();
        System.out.println(types[0].getTypeName());
    }

    /**
     * 获取接口
     */
    @Test
    public void interfaceTest(){
        Class clazz = Person.class;
        Class[] interfaces =  clazz.getInterfaces();
        for(Class c: interfaces){
            System.out.println(c);
        }
    }

    /**
     * 获取接口
     */
    @Test
    public void packageTest(){
        Class clazz = Person.class;
        Package packages =  clazz.getPackage();
        System.out.println(packages);

    }
}
