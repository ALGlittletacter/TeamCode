package zhangpengfei;

/**
 * Created by ZPF on 2019/4/30.
 */
//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
//请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
//你可以假设 nums1 和 nums2 不会同时为空。
//
//示例 1:
//
//nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
public class Median {
    //    public static double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        if (m > n) { // to ensure m<=n
//            int[] temp = A; A = B; B = temp;
//            int tmp = m; m = n; n = tmp;
//        }
//        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//        while (iMin <= iMax) {
//            int i = (iMin + iMax) / 2;
//            int j = halfLen - i;
//            if (i < iMax && B[j-1] > A[i]){
//                iMin = i + 1; // i is too small
//            }
//            else if (i > iMin && A[i-1] > B[j]) {
//                iMax = i - 1; // i is too big
//            }
//            else { // i is perfect
//                int maxLeft = 0;
//                if (i == 0) { maxLeft = B[j-1]; }
//                else if (j == 0) { maxLeft = A[i-1]; }
//                else { maxLeft = Math.max(A[i-1], B[j-1]); }
//                if ( (m + n) % 2 == 1 ) { return maxLeft; }
//
//                int minRight = 0;
//                if (i == m) { minRight = B[j]; }
//                else if (j == n) { minRight = A[i]; }
//                else { minRight = Math.min(B[j], A[i]); }
//
//                return (maxLeft + minRight) / 2.0;
//            }
//        }
//        return 0.0;
//    }
    public static double findMedianSortedArrays(int[] A, int[] B){
        int lena=A.length;
        int lenb=B.length;
        if(lena>lenb){
            int[] temp=A;
            A=B;
            B=temp;
        }
        lena=A.length;
        lenb=B.length;
        int imax=lena,imin=0;
        int halflen=(lena+lenb+1)/2;
        while(imax>=imin){
            int i=(imax+imin)/2;
            int j=halflen-i;
            if(i>imin&&A[i-1]>B[j]){//截取的A最后一个数太大了，imax要变小。
                imax=i-1;
            }
            else if(i<imax&&B[j-1]>A[i]){
                imin=i+1;
            }
            else {
                int x=0;
                if(i==0){
                    x=B[j-1];
                }
                else if(j==0){
                    x=A[i-1];
                }
                else {
                    x=Math.max(B[j-1],A[i-1]);
                }
                if((lena+lenb)%2==1){
                    return x;
                }
                else {
                    int y=0;
                    if(i==lena){
                        y=B[j];
                    }
                    else if(j==lenb){
                        y=A[i];
                    }
                    else {
                        y=Math.min(B[j],A[i]);
                    }
                    return (x+y)/2.0;//千万注意除2.0,不能除以2，不然返回值是整数
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 ={1,3};
        int[] nums2 ={2,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
