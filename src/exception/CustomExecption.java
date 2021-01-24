package exception;

/**
 * 自定义异常类
 *      1.继承于现有的异常结构：RuntimeException 、Exception
 *      2.提供全局常量：serialVersionUID
 *      3.提供重载的构造器
 */
public class CustomExecption extends Exception {

    private static final long serialVersionUID = 1548642743183422918L;

    public CustomExecption(){}

    public CustomExecption(String message){
        super(message);
    }

}
