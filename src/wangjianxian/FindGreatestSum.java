package wangjianxian;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wjx
 * Date: 2019-05-04
 * Time: 18:12
 */
public class FindGreatestSum {
    public static int FindGreatestSumSolution(int[] array){
        if(array.length <= 0){
            return -1;
        }
        int realMax = array[0];
        int currentMax = 0; //当前最大值
        for(int i = 0;i<array.length;i++){
            if(currentMax + array[i] >= array[i]){
                //当前最大值加上当前数组的数如果比数组当前这个数大，那么就累加，因为前面连续和大于0，所以加上这个数连续和肯定大
                currentMax += array[i];
            }else{
                currentMax = array[i];
            }
            if(currentMax > realMax){
                //每计算一个当前最大连续和就和最后的要返回的结果进行比较
                realMax = currentMax;//更新
            }
        }
        return realMax;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,-4, 6,2,-5};
        int n = FindGreatestSumSolution(array);
        System.out.println(n);
    }
}
