package zhangpengfei;
/**
 * Created by ZPF on 2019/4/29.
 */
/*
给出一个 32 位的有符号整数，
你需要将这个整数中每位上的数字进行反转
输入: -123
输出: -321
输入: 120
输出: 21
 */
public class IntegerInversion {
    public static int reverse(int x){// leetcode：执行10ms，内存33.8MB
        String a="";
        if(x==0){
            return 0;
        }
        else if(x>0){
            a=Integer.toString(x);
            StringBuffer sb=new StringBuffer(a);
            sb=sb.reverse();
            try{
                int m=Integer.parseInt(sb.toString());
                return m;
            }catch (Exception e){
                return 0;
            }
        }
        else {
            a=Integer.toString(x);
            StringBuffer sb1=new StringBuffer(a.substring(1));
            sb1=sb1.reverse();
            sb1.insert(0,"-");
            try {
                int m=Integer.parseInt(sb1.toString());
                return m;
            }catch (Exception e){
                return 0;
            }
        }
    }
    public static int reverse2(int x){
        int rev=0;
        //MAX_VALUE : 2147483647 MIN_VALUE : -2147483648 判断最后一位不要大于 7 和 不要小于8
        while (x!=0){
            int pop=x%10;
            x/=10;
            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            rev=rev*10+pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(214748154));
        System.out.println(reverse2(-214748));
    }

}
