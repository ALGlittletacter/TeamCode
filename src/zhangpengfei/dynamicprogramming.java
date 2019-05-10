package zhangpengfei;

/**
 * Created by ZPF on 2019/5/7.
 */
/*
某幢大楼有100层。你手里有两颗一模一样的玻璃珠。
当你拿着玻璃珠在某一层往下扔的时候，一定会有两个结果，
玻璃珠碎了或者没碎。这幢大楼有个临界楼层。低于它的楼层，
往下扔玻璃珠，玻璃珠不会碎，等于或高于它的楼层，扔下玻璃珠，
玻璃珠一定会碎。玻璃珠碎了就不能再扔。现在让你设计一种方式，
使得在该方式下，最坏的情况扔的次数比其他任何方式最坏的次数都少。
也就是设计一种最有效的方式。
 */

/*
x.xu@dlut.edu.cn
解释：动态规划入门，
随便挑一层，假如为N层，扔下去后，如果碎了，从N到第一层尝试，最坏的情况可能为N；假如没碎，从N到最高层，
这时最坏的情况为100-N。也就是说，采用这种办法，最坏的情况为max{N, 100-N+1}。注意要加一，因为第一次是从第N层开始扔
 定义一个函数F（N），表示N层楼最有效方式最坏情况的次数；
那么F（N）=min(max(1,1+F(N-1)),max(2,F(N-2)+1),...,max(N-1,1+F(1)))

 */
public class dynamicprogramming {
    public static int floorThr(int n) {
        int[] array = new int[n + 1];
        array[1] = 1;
        for (int x = 2; x <= array.length - 1; x++) {
            array[x] = x;
            for (int j = 1; j < x; j++) {
                int temp = Math.max(j, array[x - j] + 1);//选择max(N,n-n+1)的较大值
                if (temp < array[x]) {//选出最差条件下最有效的
                    array[x] = temp;
                }
            }

        }
        return array[n];
    }
    public static void main (String args[]){
        int res = floorThr(100);
        System.out.println(res);
    }
}
