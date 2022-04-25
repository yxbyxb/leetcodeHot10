package com.example.leetcodehot100;

import com.example.pojo.ListNode;

//利用递归倒着来的特性
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.3 MB, 在所有 Java 提交中击败了71.35%的用户
public class RemoveNthFromEnd_19 {
    ListNode needRemove = null;
    ListNode preNeedRemove = null;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        myRemove(head,n);
        if (preNeedRemove==null){
            return head.next;
        }else {
            preNeedRemove.next = needRemove.next;
            return head;
        }
    }

    private int myRemove(ListNode head,int n){
        if (head==null){
            return 0;
        }
        int indexFromLast = myRemove(head.next,n)+1;
        if (indexFromLast==n){
            needRemove = head;
        }
        if (indexFromLast==n+1){
            preNeedRemove=head;
        }
        return indexFromLast;
    }
}
