package zhangpengfei;

import wangjianxian.LinkMerge;

/**
 * Created by ZPF on 2019/5/5.
 */
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class removelink {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val=x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int length=0;
        ListNode fhead=head;
        while (fhead!=null){
            length++;
            fhead=fhead.next;
        }
        length=length-n;
        fhead=dummy;
        while (length>0){
            length--;
            fhead=fhead.next;
        }
        fhead.next=fhead.next.next;
        return dummy.next;
    }
    //时间复杂度o(L),空间复杂度o(1)
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fhead = dummy;
        ListNode shead = dummy;
        for(int i=1;i<=n+1;i++){
            fhead=fhead.next;
        }
        while (fhead!=null){
            fhead=fhead.next;
            shead=shead.next;
        }
        shead.next=shead.next.next;
        return dummy.next;
        // 我们可以使用两个指针而不是一个指针。
        // 第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。
        // 现在，这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，
        // 直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。
        // 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
    }
}
