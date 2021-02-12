package reflect;

/**
 * 静态代理
 *  特点：代理类和被代理类在编译期间，就确定下来了
 * @author zjw
 * @create 2021-02-03
 **/
public class StaticProxy {

    public static void main(String[] args) {
        TieBy tieBy = new TieBy();
        Shoes  shoes = new ProxyShoes(tieBy);
        shoes.todo();
    }

}


interface Shoes{
    void todo();
}

//代理类
class ProxyShoes implements Shoes{

    private Shoes shoes;

    public ProxyShoes(Shoes shoes){
        this.shoes = shoes;
    }

    @Override
    public void todo() {
        System.out.println("方法执行之前");
        shoes.todo();
        System.out.println("方法执行之后");
    }
}

//被代理类
class TieBy implements Shoes{

    @Override
    public void todo() {
        System.out.println("特步专卖店");
    }
}