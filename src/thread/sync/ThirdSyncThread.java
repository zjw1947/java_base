package thread.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步方式三： lock锁    jdk1.5新增
 *      synchronized (同步监视器){方法体}；

 */
public class ThirdSyncThread implements Runnable {

    private int count = 1;

    //true 表示公平的，按得到锁线程的顺序依次执行
//    private ReentrantLock lock = new ReentrantLock(true);
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                Thread.sleep(100);
                if(count > 100){
                    break;
                }
                System.out.println(Thread.currentThread().getName() +":" + count);
                count++;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

}
