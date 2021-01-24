package exception;

public class Test {
    public static void main(String[] args) {
        try {
            method(0);
        }catch (CustomExecption e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("程序执行结束");
        }
    }

    /**
     * throws： 表示捕获异常
     * throw: 表示抛出异常
     */
    public static void method(int i) throws CustomExecption{
        if(i == 0){
            throw new CustomExecption("出现异常");
        }
    }
}
