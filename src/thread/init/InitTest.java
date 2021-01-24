package thread.init;

import java.util.concurrent.*;

/**
 * 线程的生命周期
 *      新建：当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建状态
 *      就绪：处于新建状态的线程被start后，将进入线程队列等待CPU时间片，此时它以具备运行条件，只是没分配CPU资源
 *      运行：就绪的线程被调度并获得CPU资源时，便进入运行状态，run()方法定义了线程的操作和功能
 *      阻塞：在某种特殊情况下，被人为挂起或执行输入输出操作是，让C出PU并临时终止自己的执行，进入阻塞状态
 *      死亡：线程完成了全部工作或被提前强制地终止或出现异常导致结束
 */
public class InitTest {
    public static void main(String[] args) {

        //多线程实现方式一
        FirstInitializeThread firstInitializeThread = new FirstInitializeThread();
//        firstInitializeThread.setName("线程一");
        firstInitializeThread.start();


        //匿名方式
        new Thread(){
            @Override
            public void run(){
                System.out.println("匿名类 Thread, 调用start方法 ");
            }
        }.start();


        //多线程实现方式二
        SecondInitializeThread secondInitializeThread = new SecondInitializeThread();
        Thread thread = new Thread(secondInitializeThread);
        thread.start();


        //多线程实现方式三
        ThirdIninalizeThread thirdIninalizeThread = new ThirdIninalizeThread();
        FutureTask futureTask = new FutureTask(thirdIninalizeThread);
        new Thread(futureTask).start();
        try {
            //调用线程并获取返回值
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //多线程实现方式四
        //创建一个长度为10的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //对连接池进行一些设置，可以不设置（使用子类，设置多）
//        ThreadPoolExecutor service2 = (ThreadPoolExecutor) service;
//        service2.setCorePoolSize(15);  //设置核心线程池大小
//        service2.setKeepAliveTime();  //线程没有任务存活多久
        //执行指定的线程操作
        service.execute(new FourthInitializeThread()); //适合用于 Runnable
//        service.submit(new FourthInitializeThreadTwo()); //适合用于 Callable
        //用完关闭连接池
        service.shutdown();

        System.out.println("多线程执行");

    }
}
