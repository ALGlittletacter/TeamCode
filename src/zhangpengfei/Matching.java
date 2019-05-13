package zhangpengfei;

import java.util.*;

/**
 * Created by ZPF on 2019/5/13.
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符
 */
public class Matching {

    public static List<Integer> findSubstring(String s,String[] words){
        List<Integer> res=new ArrayList<>();
        if(s==null||s.length()==0||words==null||words.length==0)
            return res;
        HashMap<String,Integer> map=new HashMap<>();//储存words字符数组，value值为出现的次数
        int word=words[0].length();//每个子串的长度
        int number=words.length;//子串的个数
        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);//map中如果没有当前子串，则放入；如果有数目+1
        }
        for(int i=0;i<word;i++){
            int left=i,right=i,count=0;
            HashMap<String,Integer> temp=new HashMap<>();
            while (right+word<=s.length()){
                String match=s.substring(right,right+word);//滑动窗口
                right+=word;
                if(!map.containsKey(match)){
                    count=0;
                    left=right;
                    temp.clear();
                }
                else {
                    temp.put(match,temp.getOrDefault(match,0)+1);
                    count++;
                    while (temp.getOrDefault(match,0)>map.getOrDefault(match,0)){//如果匹配的个数多了，向右滑动word个字符
                        String match1=s.substring(left,left+word);
                        count--;
                        temp.put(match1,temp.getOrDefault(match1,0)-1);
                        left+=word;
                    }
                    if(count==number) res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*
        s = "barfoothefoobarman",
            words = ["foo","bar"]
         */
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s,words));
    }

}
