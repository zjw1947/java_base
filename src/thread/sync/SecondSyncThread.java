package thread.sync;

/**
 * 同步方式二： 同步方法
 *   不是静态方法：该方式同步监视器是 this
 *   不是静态方法：该方式同步监视器是 该类的对象 SecondSyncThread。class

 */
public class SecondSyncThread implements Runnable {

    private static int count = 1;

    @Override
    public void run() {
        while (true){
            if(count > 100){
                break;
            }
            hanleCount();
        }
    }

//    private synchronized void hanleCount(){
    private static synchronized void hanleCount(){
        try {
            if(count <= 100) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ":" + count);
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
