package zhangpengfei;

/**
 * Created by ZPF on 2019/5/14.
 */
//滑动窗口经典问题
//给一组大小为n的整数数组，计算长度为k的子数组的最大值
public class SlidingWindow {
    public static int maxnum(int[] array,int k){
        if(array.length<k){
            return -1;
        }
        int left=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=array[i];
        }
        int tempsum=sum;
        while (left+k<array.length){
            tempsum=tempsum-array[left]+array[left+k];
            left++;
            sum=Math.max(sum,tempsum);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr={1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k=3;
        System.out.println(maxnum(arr,k));
    }
}