package wangjianxian;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wjx
 * Date: 2019-04-28
 * Time: 22:22
 */

/**
 *
 * 	* 分析：如果两个单向链表有公共的结点，也就是说两个链表从某一结点开始，它们的m_pNext都指向同一个结点。但由于是单向链表的结点，每个结点只有一个m_pNext，因此从第一个公共结点开始，之后它们所有结点都是重合的，不可能再出现分叉。所以，两个有公共结点而部分重合的链表，拓扑形状看起来像一个Y，而不可能像X
 * 	*
 * 所以说两个节点有共同的一部分节点，也有重合的第一个节点（可以当作双向链表的尾节点）
 * 	*
 * 所以可以先计算出两个链表的长度，求一下两者的差，之后长的链表先走差的长度单位的长度，然后比较节点是否相等，如果相等，那么就是第一个共有节点。
 */
public class LinkMerge {
    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }


    public ListNode  FindFirstCommonNode(ListNode pHead1,  ListNode pHead2){
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int length1 = 0;
        int length2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //分别求两个链表的长度
        while(p1!=null){
            length1++;
            p1 = p1.next;
        }
        while(p2!=null){
            length2++;
            p2 = p2.next;
        }
        //长的那个链表，就先走长度为长度差的单位
        int cha = 0;
        if(length1 > length2){
            cha = length1 - length2;
            p1 = pHead1;
            p2 = pHead2;
            for(int i = 0;i<cha;i++){
                p1 = p1.next;
            }
        }else{
            cha = length2 - length1;
            p2 = pHead2;
            p1 = pHead1;
            for(int i = 0;i<cha;i++){
                p2 = p2.next;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}