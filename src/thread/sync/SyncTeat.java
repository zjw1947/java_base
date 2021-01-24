package thread.sync;

/**
 * 同步好处：只能有一个线程参与，其他线程等待，相当于一个单线程的过程，效率低
 */
public class SyncTeat {

    public static void main(String[] args) {
        /*FirstSyncThread firstSyncThread = new FirstSyncThread();
        Thread t1 = new Thread(firstSyncThread);
        Thread t2 = new Thread(firstSyncThread);
        Thread t3 = new Thread(firstSyncThread);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();*/

        /*SecondSyncThread secondSyncThread1 = new SecondSyncThread();
        SecondSyncThread secondSyncThread2 = new SecondSyncThread();
        SecondSyncThread secondSyncThread3 = new SecondSyncThread();

        Thread t1 = new Thread(secondSyncThread1);
        Thread t2 = new Thread(secondSyncThread2);
        Thread t3 = new Thread(secondSyncThread3);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();*/

        ThirdSyncThread thirdSyncThread = new ThirdSyncThread();
        Thread t1 = new Thread(thirdSyncThread);
        Thread t2 = new Thread(thirdSyncThread);
        Thread t3 = new Thread(thirdSyncThread);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
