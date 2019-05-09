package wangjianxian;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wjx
 * Date: 2019-05-02
 * Time: 16:10
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * 最小的K个数
 *思路：使用大小为k的最大堆，堆顶元素不断与数组元素比较，当堆中元素小于k时不断入堆 ，如果到达临界点，这时就需要比较数组元素与堆顶元素的大小关系，如果堆顶元素大，就把堆顶元素出堆，反之不用操作,时间复杂度O（n）
 */
public class GetLeastNum {
    public ArrayList<Integer> GetLeastNumSolution(int[] array, int k){
        ArrayList<Integer> resultList  = new ArrayList<Integer>();
        if(k > array.length || k<=0){
            return resultList;
        }
        //使用优先队列建堆，优先级队列默认的是最小堆，所以重写比较器
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0;i<array.length;i++){
            if(i< k){
                maxHeap.add(array[i]);
            }else{
                if(maxHeap.peek() > array[i]){
                    maxHeap.poll();
                    maxHeap.add(array[i]);
                }
            }
        }
        while(!maxHeap.isEmpty()){
            resultList.add(maxHeap.poll());
        }
        return resultList;
    }
}
