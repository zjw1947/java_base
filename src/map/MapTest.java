package map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Map: 双列数据，存储 key-value 对的数据， key无序且不可重复， value无序可重复
 *      HashMap: 线程不安全，效率高，可以存储null的key与value（jdk7之前底层 数组+链表， jdk8 数组+链表+红黑树）
 *          LinkedHashMap:保证在遍历map元素时，可以按照添加顺序遍历
 *      TreeMap: 保证按照添加的 key-value 进行排序，实现排序遍历，按照key的自然排序或定制排序，底层红黑树（写法参考TreeSet）
 *      Hashtable: 古老实现类，线程安全，效率低，不能存储null的key与value
 *          Properties: 常用于处理配置文件，key与 value都是String类型
 *
 */
public class MapTest {

//    ImmutableMap.of("names",names,"datas",datas);

    /**
     * Properties 用于 properties 文件参数读取
     */
    @Test
    public void propertiesTest() {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/map/test.properties");
            properties.load(fis);
            System.out.println(properties.getProperty("name"));
            System.out.println(properties);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void mapForeachTest(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "111");
        map.put("2", "222");
        map.put("3", "333");

        for(Map.Entry m: map.entrySet()){
            System.out.println(m.getKey() + "--" + m.getValue());
        }
    }

}
