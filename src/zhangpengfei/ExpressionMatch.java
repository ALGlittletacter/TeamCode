package zhangpengfei;

/**
 * Created by ZPF on 2019/4/29.
 */
/*
给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
 */
public class ExpressionMatch {
    public static boolean isMatch_Dp(String s, String p) {
        if(s==null||p==null){
            return false;
        }
        int sIndex=0;
        int pIndex=0;
        return matchCore(s,sIndex,p,pIndex);
    }
    public static void main(String[] args) {
        System.out.println(isMatch_Dp("ab",".*c"));
    }
    private static boolean matchCore(String s, int sIndex, String p, int pIndex) {
        //如果都匹配到了最后
        if(sIndex==s.length()&&pIndex==p.length()){
            return true;
        }
        //如果p已经匹配完但是s还没匹配完，肯定不匹配，false
        if(sIndex!=s.length()&&pIndex==p.length()){
            return false;
        }
        //如果当前pindex的下一个是*，
        if(pIndex+1<p.length()&&p.charAt(pIndex+1)=='*'){
            //如果sindex对应字符pindex或者通配符“.”
            if(sIndex!=s.length()&&s.charAt(sIndex)==p.charAt(pIndex)||sIndex!=s.length()&&p.charAt(pIndex)=='.'){
                // 有三种可能，跳过pindex和pindex+1
                //或者pindex和pindex+1刚好匹配一个sindex
                //或者pindex匹配sindex，继续匹配sindex+1
                return matchCore(s,sIndex,p,pIndex+2)||matchCore(s,sIndex+1,p,pIndex+2)||matchCore(s,sIndex+1,p,pIndex);
            }
            //如果不匹配，pindex+2
            else {
                return matchCore(s,sIndex,p,pIndex+2);
            }
        }
        //如果pindex+1不是'*',如果sindex和pindex匹配，sindex+1，pindex+1
        if(sIndex!=s.length()&&(s.charAt(sIndex)==p.charAt(pIndex)||p.charAt(pIndex)=='.')){
            return matchCore(s,sIndex+1,p,pIndex+1);
        }
        //如果还不匹配，返回false
        else {
            return false;
        }
    }
}
/*
执行用时 : 750 ms, 在Regular Expression Matching的Java提交中击败了6.25% 的用户
内存消耗 : 35 MB, 在Regular Expression Matching的Java提交中击败了91.70% 的用户
 */
