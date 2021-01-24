package thread.init;

/**
 * 多线程实现方式一
 * 常用方法：
 *      Thread.currentThread() 获取线程名字
 *      setName()/getName  线程名处理
 *      yield()  释放当前CPU执行权
 *      join()  该线程执行完其他线程才执行，多个线程跑是在其他线程中调用
 *      sleep(毫秒值)  线程进入睡眠**毫秒
 *      isAlive()  线程是否存活
 *      getPriority()  获取线程优先级
 *      setPriority(int p)  设置线程优先级
 *             MAX_PRIORITY  10
 *             MAX_PRIORITY  1
 *             NORM_PRIORITY  5  默认优先级
 *        wait()   线程等待
 *        notify()  唤醒其他优先级最高的线程
 *        notifyAll()  唤醒其他所有线程
 */
public class FirstInitializeThread extends Thread {

    public FirstInitializeThread(){}

    public FirstInitializeThread(String name){
        //可以给线程起名
        super(name);
    }

    @Override
    public void run(){
        try {
            sleep(2000);
//            Thread.currentThread().getName()
            System.out.println("多线程初始化方法一，继承 Thread, 调用start方法 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
