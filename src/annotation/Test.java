package annotation;


import java.lang.annotation.Annotation;

public class Test {
    public static void main(String[] args) {

        // Inherited 注解继承测试
        Class clazz = Cat.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation: annotations){
            System.out.println(annotation);
        }
    }
}


@JavaMetaAnnotation
class Dog{
    @MyAnnotation(value="必填项")
    private String name;

    private String age;

    //    @JavaMetaAnnotation
    public void show(){
        System.out.println("输出");
    }
}

class Cat extends Dog{

}
