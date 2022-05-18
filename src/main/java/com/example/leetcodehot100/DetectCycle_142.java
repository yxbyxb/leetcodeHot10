package com.example.leetcodehot100;

import com.example.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle_142 {
    //    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet();
//        while(head!=null){
//            if (!set.add(head)){
//                return head;
//            }
//            head = head.next;
//        }
//        return null;
//    }
//    快慢指针+一个新指针 设前面一段为x，圆圈长为y,相遇点两边分别长a,b，fast跟slow相遇的时候
//    lFast = x+ny+a lSlow=x+my+a
//    lFast-lSlow=(n-m)y=(n-m-1)y+a+b vFast=2vSlow->lFast=2lSlow ->(n-m-1)y-x+b=0 x=(n-m-1)y+b
//    所以 fast和slow相遇的时候 新指针从起点开始 和slow会在圆圈的起点相遇
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode result = head;
        head = head.next;
        fast = fast.next;
        if (fast == null) {
            return null;
        }
        fast = fast.next;
        while (fast != null && head != null) {
            if (fast == head) {
                while (head != null && result != null) {
                    if (head == result) {
                        return result;
                    }
                    head=head.next;
                    result=result.next;
                }
            }
            head = head.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        return null;
    }
}
