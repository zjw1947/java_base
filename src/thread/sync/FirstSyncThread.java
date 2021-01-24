package thread.sync;

/**
 * 同步方式一： 同步代码块
 *      synchronized (同步监视器){方法体}；
 *
 * 要求：
 *      1.操作共享数据的代码，是需要被同步地代码
 *      2、共享数据：多个线程共同操作的变量
 *      3、同步见识器，俗称：锁，任何一个类的对象都可以充当锁，但是多个线程必须共同=用同一把锁
 */
public class FirstSyncThread implements Runnable {

    private int count = 1;

//    private static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //new 一个类保证同步监视器一致
//            synchronized (obj){
            //使用类对象保证同步监视器一致
            synchronized (FirstSyncThread.class){
            //只创建了一个该对象是可使用 this 关键字保证同步监视器一致
//            synchronized (this){
                try {
                    Thread.sleep(100);
                    if(count > 100){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() +":" + count);
                    count++;
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

}
