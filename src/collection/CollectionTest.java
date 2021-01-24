package collection;

import org.junit.Test;

import java.util.*;

/**
 * Collection接口： 单列集合，用来存储对象
 *      List接口：存储有序的，可重复的数据
 *          ArrayList: 线程不安全，效率高，底层使用 Object[] elemen
 *          LinkedList:对频繁的插入与删除效率高，底层使用 双向链表
 *          Vector: 线程安全，效率低，底层使用 Object[] elemen
 *      Set接口： 存储无序的，不可重复的数据
 *          HashSet: 线程不安全的，可以存null， 底层是 数组 + 链表
 *              LinkedHashSet: HashSet子类，遍历是可以按照添加顺序进行遍历
 *          TreeSet: 二叉树，可以按照添加对象指定属性进行排序，顺序一致表示"重复"，只能添加同一类型数据
 */
public class CollectionTest {

    /**
     * TreeSet 排序功能实现
     */
    @Test
    public void treeSetTest(){
        //方式一：
        //实体类对象实现Comparable接口，循环是按定义的顺序排列的
        Set<Cat> catSet = new TreeSet<>();
        catSet.add(new Cat("张三猫", 11));
        catSet.add(new Cat("李四猫", 4));
        catSet.add(new Cat("王五猫", 29));
        catSet.add(new Cat("张三猫", 3));
        for(Cat cat:catSet){
            System.out.println(cat);
        }
        System.out.println("=====================================");
        //方式二
        //TreeSet初始化时添加排序规则
        Comparator<Dog> comparable = new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                int c = o2.getName().compareTo(o1.getName());
                if(c == 0){
                    c = o2.getAge() - o1.getAge();
                }
                return c;
            }
        };
        Set<Dog> dogSet = new TreeSet<>(comparable);
        dogSet.add(new Dog("张三狗", 11));
        dogSet.add(new Dog("李四狗", 4));
        dogSet.add(new Dog("王五狗", 29));
        dogSet.add(new Dog("张三狗", 3));
        for(Dog dog:dogSet){
            System.out.println(dog);
        }
    }

    @Test
    public void handleForeachCollection(){
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 两个集合之间的操作
     */
    @Test
    public void handleTwoCollection(){
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        List list2 = new ArrayList();
        list2.add("3");
        list2.add("4");
        list2.add("5");

        //交集
//        list.retainAll(list2);
//        System.out.println(list);

        //并集
        /*list.addAll(list2);
        System.out.println(list);*/

        //差集
        list.removeAll(list2);
        System.out.println(list);
    }

}
