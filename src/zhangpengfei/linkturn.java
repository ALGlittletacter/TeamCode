package zhangpengfei;

/**
 * Created by ZPF on 2019/5/4.
 */
/*
给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，
那么将最后剩余节点保持原有顺序。
示例 :

给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class linkturn {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head,int k){
        if(head==null){
            return null;
        }
        ListNode finallink=head;
        ListNode res=head;
        ListNode[] clclink=new ListNode[k];//链表数组，存储每k个链表
        ListNode realstart=new ListNode(0);
        realstart.next=head;
        for(int i=0;i<k-1;i++){
            if(res==null) return head;
            res=res.next;
        }
        if(res==null){//如果k大于链表长度的话，直接返回head
            return head;
        }
        while(finallink!=null){
            for(int i=0;i<k;i++){//链表存到数组中去，如果剩余节点不足放满整个数组，就返回res。
                if(finallink==null){
                    return res;
                }
                clclink[i]=finallink;
                finallink=finallink.next;
            }
            for(int i=k-1;i>0;i--){//翻转链表的指向
                clclink[i].next=clclink[i-1];
            }
            realstart.next=clclink[k-1];//上次循环的最后一个节点更新为本次翻转后的第一个节点(比如3->2->1->6->5->4)
            realstart=clclink[0];
            clclink[0].next=finallink;//本次循环结束后的最后一个指向下一个节点（还未翻转，比如3->2->1->4）
        }
        return res;
    }
}
//时间复杂度O（n^2），空间复杂度o(n)
