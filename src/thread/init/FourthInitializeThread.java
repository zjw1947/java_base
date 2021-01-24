package thread.init;

import java.util.concurrent.Callable;

/**
 * 推荐使用该方式
 */
public class FourthInitializeThread implements Runnable {

    @Override
    public void run() {
        System.out.println("多线程实现方式四，线程池 runable ");
    }
}

class FourthInitializeThreadTwo implements Callable<Object>{

    @Override
    public Object call() throws Exception {
        System.out.println("多线程实现方式四，线程池 callable ");
        return "线程池";
    }
}
