package thread.init;

/**
 * 推荐使用该方式
 */
public class SecondInitializeThread implements Runnable {

    @Override
    public void run() {
        System.out.println("多线程初始化方法二，实现 Runnable 接口 ");
    }
}
