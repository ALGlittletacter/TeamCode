package wangjianxian;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wjx
 * Date: 2019-05-01
 * Time: 13:09
 */

/**
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和
 */
public class GetSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int c = getNum(a,b);

        System.out.println(c);


    }
    public static int getNum(int a, int b){
        //a^b取的是不进位的结果，(a&b)<<1进位左移
        return b==0? a:getNum(a^b, (a&b)<<1);
    }
}
