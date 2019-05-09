package zhangpengfei;

/**
 * Created by ZPF on 2019/5/9.
 */
//分治法找伪币
public class FalseMoney {

    public static void main(String[] args) {
        int[] array={2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2};//16个硬币
        int start=0,end=15;
        System.out.println(finding(array,start,end));
    }
//每次分半，比较重量，轻的递归
    private static int finding(int[] array, int start, int end) {
        int res=-1;
        if(start+1==end){
            if(array[start]>array[end]){
                res= end;
            }
            else {
                res= start;
            }

        }
        else {
            int mid=(start+end-1)/2;
            int suml=0,sumr=0;
            for(int i=start;i<=mid;i++){
                suml+=array[i];
            }
            for(int i=mid+1;i<=end;i++){
                sumr+=array[i];
            }
            if(suml==sumr){
                return res;
            }
            res=suml-sumr>0?finding(array,mid+1,end):finding(array,start,mid);
//            if(suml>sumr){
//                finding(array,mid+1,end);
//            }
//            if(suml<sumr){
//                finding(array,start,mid);
//            }如果要这么写，要把res设置为全局静态变量

        }
        return res;
    }
}
