package zhangpengfei;

/**
 * Created by ZPF on 2019/5/9.
 */
/*
背包问题
Vi表示第 i 个物品的价值，Wi表示第 i 个物品的体积，定义V(i,j)：
当前背包容量 j，前 i 个物品最佳组合对应的价值，
同时背包问题抽象化（X1，X2，…，Xn，其中 Xi 取0或1，表示第 i 个物品选或不选）。
1.建立模型：求max(V1X1+V2X2+…+VnXn)
2.约束条件：W1X1+W2X2+…+WnXn<capacity
3.（最重要的）寻找递推关系式
如果装入该商品会超过最大容量，那就是V(i,j)=V(i-1,j)
如果不会超，可以选择装入或者不装入,V(i,j)=max{v(i-1,j),v(i-1,j-w(i))+v(i)}
 */
public class RuckSuck {
    public static void main(String[] args) {
        int[] w={0,2,3,4,5};//商品的体积
        int[] v={0,3,4,5,6};//商品的价值
        int sum=8;//背包大小
        int[][] tab=new int[5][9];//动态规划表
        for(int i=1;i<=4;i++){
            for(int j=1;j<=8;j++){
                if(j<w[i]){//容量不够
                    tab[i][j]=tab[i-1][j];
                }
                else {
                    tab[i][j]=Math.max(tab[i-1][j],tab[i-1][j-w[i]]+v[i]);
                }
            }
        }
        for (int i=0;i<=4;i++){
            for(int j=0;j<=8;j++){
                System.out.print(tab[i][j]+"  ");
            }
            System.out.println();
        }
    }
}