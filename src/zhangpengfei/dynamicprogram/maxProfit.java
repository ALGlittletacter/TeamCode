package zhangpengfei.dynamicprogram;

/**
 * Created by ZPF on 2019/6/25.
 */
/*
动态规划
今天恒生电子笔试题，明明知道是动态规划问题，自己还是不知道怎么做，再练练吧,这是我的考试做法
还不知道怎么简单做
题目类似这道题：
一个人一天只能进行最多两次买和两次卖，并且只有卖了才能继续买。
问一天可以获得的最大收益，要采用时间复杂度低的实现

输入：5 2,4,6,8,10.输出:8 (2买，10卖）

输入：6 10,22,5,75,65,80.输出：87  （10买，22卖，5买，80卖）
 */
public class maxProfit {
    public static int max(int[][] array,int a,int b){
        if(a>=array.length||b>=array.length){
            return 0;
        }
        int max=array[a][b];
        for(int i=a;i<array.length;i++){
            for (int j=b;j<array[a].length;j++){
                if(max<array[i][j]){
                    max=array[i][j];
                }
            }
        }
        return max;
    }
    public static int maxProfit(int[] prices, int length) {
        int res = 0;
        int dp[][] = new int[length-1][length-1];
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length-1; j++) {
                dp[i][j] = prices[j+1] - prices[i];
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }
        int max = 0;
        if(max<max(dp,0,0)){
            max=max(dp,0,0);
            //System.out.println(max);
        }
        for(int i=0;i<length-1;i++){
            for(int j=i;j<length-1;j++){
                if(max<dp[i][j]+max(dp,j+1,j+1)){
                    max=dp[i][j]+max(dp,j+1,j+1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array={1,6,2,10};
        System.out.println(maxProfit(array,4));
    }
}
