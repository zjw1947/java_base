package annotation;

/**
 * 自定义注解
 *      注解声明为： @interface
 *      内部定义成员，不定义表示标识注解,
 *      定义了成员不设置默认值则必须在使用使用时设值
 *      只有一个成员是可以省略属性名
 */
public @interface MyAnnotation {

    String value();

    String nmae() default "test";

}
