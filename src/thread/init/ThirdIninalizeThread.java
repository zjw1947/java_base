package thread.init;

import java.util.concurrent.Callable;

/**
 *  多线程实现方式一     JDK 1.5 新增
 *      可以有返回值就抛出异常,并且支持泛型
 *          注：泛型与返回值类型一致
 */
public class ThirdIninalizeThread implements Callable {

    private int count = 1;

    @Override
    public Object call() throws Exception {
        System.out.println("多线程初始化方法三，实现 Callable, 调用start方法 ");
        return ++count;
    }
}

class ThirdIninalizeThreadT implements Callable<Integer> {

    private int count = 1;

    @Override
    public Integer call() throws Exception {
        System.out.println("多线程初始化方法三(泛型)，实现 Callable, 调用start方法 ");
        return ++count;
    }
}