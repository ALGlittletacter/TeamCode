package wangjianxian;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wjx
 * Date: 2019-04-29
 * Time: 13:09
 */

/**
 * Q:在有序数组中查找数字出现的次数
 * A:首先是有序数组，所以出现的数字如果有必然是连续的，所以的hi用二分法进行左右两侧的划分，分别求出最左最右下标即可
 * 复杂度分析时间复杂度O(n) 空间复杂度O(1)
 */
public class FindNumInSortArray {
    public static int FindNum(int[] array, int target){
        //简单的鲁棒性检测
        if(array == null){
            return -1;
        }
        //设置最左下标
        int leftIndex = -1;
        //设置最右下标
        int rightIndex = -1;
        //因为左面查找和右面查找都会使用start,end所以这样赋值
        int start = 0;
        int end = array.length-1;

        while(start<=end){
            int mid = (start + end)/2;
            //充分利用有序性，如果中间的数值大于target那么end=mid-1,小于那么就start=mid+1,等于但是如果不是最左的end= mid-1，直到跳出循环，找到的是最左面的target
            if(array[mid]>target){
                end = mid - 1;
            }else if(array[mid]<target){
                start = mid + 1;
            }else{
                leftIndex = mid;//不断循环直到找到最左下标
                end = mid - 1;
            }
        }

        //同理找到的是最右面的target
        start = 0;
        end = array.length - 1;
        while (start <= end){
            int mid = (start+end)/2;
            if(array[mid] < target){
                end = mid -1;
            }else if(array[mid] > target){
                start = mid + 1;
            }else{
                start = mid + 1;
                rightIndex = mid;//不断循环直到找到最右下标
            }
        }
        //返回数目
        return rightIndex-leftIndex + 1;
    }

}
