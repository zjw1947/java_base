package enum_class;

import java.util.Arrays;


public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Dog.RED_DOG.getName());
        //toString()  返回当前枚举对象常量的名称
        System.out.println(Dog.RED_DOG.toString());

        //values()  返回枚举类型的对象数字
        System.out.println(Arrays.toString(Dog.values()));
        for(Dog dog: Dog.values()){
            System.out.println(dog.getName());
        }

        //valueOf()  把一个字符串转为对应的枚举类对象
        System.out.println(Dog.valueOf("RED_DOG").getName());

        //实现接口
        Cat.BLUE_CAT.show();
    }
}

/**
 * 使用 enum 关键字定义枚举类
 * 定义的枚举类默认继承于 java.lang.Enum 类
 */
enum Dog{
    //提供枚举值，用，隔开；结束
    RED_DOG("小红"),
    BLUE_DOG("小蓝"),
    BLACK_DOG("小黑");

    private String name;

    private Dog(String name){
        this.name = name;
    }

    public String getName(){
        return  this.name;
    }
}

/**
 * 枚举可以实现接口
 */
enum Cat implements EnumInterface{
    //方式一
    /*RED_CAT {
        @Override
        public void show() {
            System.out.println("1");
        }
    },
    BLUE_CAT {
        @Override
        public void show() {
            System.out.println("2");
        }
    };*/

    //方式二
    RED_CAT,
    BLUE_CAT;
    @Override
    public void show(){
        System.out.println("2");
    }
}
