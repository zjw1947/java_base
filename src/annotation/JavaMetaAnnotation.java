package annotation;

import java.lang.annotation.*;

/**
 *
 * jdk5 提供 4个标准的元注解
 *      Retention  指定所修饰的 Annotation（注解）的生命周期，只有生命为RetentionPolicy.RUNTIME 才能通过反射获取
 *      Target  用于指定被修饰的 Annotation 能用于修饰哪些元素  TYPE 类   FIELD 属性
 *      Documented  表示所修饰的注解被 javadoc 解析时，保留下来
 *      Inherited   表示所修饰的注解在使用时具有继承性
 *
 * 注：自定义注解常只会定义   Retention    Target
 *
 * jdk8 新特性
 *      可重复注解：   （1）创建一个注解A
 *                     （2）创建注解B, 与 注解A 的 @Target 与 @Inherited 注解属性一致，定义 A为 B 的成员
 *      类型注解：     （1）ElementType.TYPE_PARAMETER  表示该注解能写在类型变量的声明语句中（如：泛型声明）
 *                     （2）ElementType.TYPE_USE  b表示该注解能写在使用类型的任何语句中
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Documented
@Inherited
public @interface JavaMetaAnnotation {


}
