package zhangpengfei;
/**leetcode42:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
        计算按此排列的柱子，下雨之后能接多少雨水。*/
/**
 * Created by ZPF on 2019/5/7.
 */
public class vat {
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1, level = 0, res = 0;
        while (l < r) {
            int lower = height[(height[l] < height[r]) ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
/*
执行用时 : 3 ms, 在Trapping Rain Water的Java提交中击败了96.09% 的用户
内存消耗 : 36.3 MB, 在Trapping Rain Water的Java提交中击败了91.42% 的用户
 */
