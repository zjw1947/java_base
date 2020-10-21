package array;

public class BaseArray {

    public static void main(String[] args) {
        int[][] arr = new int[4][];
        //结果为null   因为未初始化值
        System.out.println(arr[1]);

        System.out.println("***************** 杨辉三角形 ********************");
        yanHui();
    }

    /**
     * 杨辉三角形
     * 例：   2   3
     *            5
     *     上面一个数与左上那个数数相加等于这个数
     */
    public static void yanHui(){
        //初始化数组，只显示10行即可
        int[][] arr = new int[10][];

        //数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            //首末元素赋值
            arr[i][0] = arr[i][i] = 1;
            //非首末元素赋值
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i -1][j] + arr[i -1][j - 1] ;
            }
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
