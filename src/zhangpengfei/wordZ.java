package zhangpengfei;

import java.util.ArrayList;
import java.util.List;

/*将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。*/
public class wordZ {
    public static String convert1(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        //创建应该有的行数，如果s.length大于numRows，最多有numRows行，否则仅需要s.length行即可。
        for(int i=0;i<Math.min(s.length(),numRows);i++){
            list.add(new StringBuilder());
        }
        int currentRow=0;//记录当前位置所在的行数
        boolean isdown=false;//记录接下来字符向上走还是向下走，初始为向上走，每次在第0行和第n-1行调转位置。
        for(char c:s.toCharArray()){
            list.get(currentRow).append(c);
            if(currentRow==0||currentRow==numRows-1){
                isdown=!isdown;
            }
            currentRow+=isdown?1:-1;
        }
        StringBuilder result=new StringBuilder();//整合List中每行的字符
        for(StringBuilder sb:list){
            result.append(sb);
        }
        return result.toString();  //时间复杂度：O(n),空间复杂度O(n)
    }
    public static String convert2(String s,int numRows){
        //按行访问
        /*
        第0行的字符是原字符串的第k倍的2*numRows-2的字符
        第x行的字符是原字符串的（第k倍的2*numRows-2）+x或-x
        第numRows-1行的字符位置=第0行的字符位置+numRows-1
         */
        if(numRows==1){
            return s;
        }
        int cycle=2*numRows-2;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<numRows;i++){
            for(int j=0;j+i<s.length();j+=cycle){
                sb.append(s.charAt(j+i));
                if(i!=0&&i!=numRows-1&&j+cycle-i<s.length()){
                    sb.append(s.charAt(j+cycle-i));
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert1("LEETCODEISHIRING",3));;
        System.out.println(convert2("LEETCODEISHIRING",3));;
    }
}
