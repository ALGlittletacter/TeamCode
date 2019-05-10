package zhangpengfei;

/**
 * Created by ZPF on 2019/5/10.
 */
//动态规划切木头，和背包问题类似
public class CutWood {
    public static void main(String[] args) {
        int n=8;
        int[] price={0,1,5,8,9,10,17,17,20,23,28};
        int[] r=new int[n+1];
        for(int i=0;i<=n;++i){
            r[i]=0;
        }
        for(int i=1;i<=n;++i){
            int q=-1;
            for(int j=1;j<=i;++j){
                if(q<price[j]+r[i-j]){//比较在当前位置切割还是不切割，选择price更高的。
                    q=price[j]+r[i-j];
                }
                r[i]=q;
            }
        }
        System.out.println(r[n]);
    }
}
