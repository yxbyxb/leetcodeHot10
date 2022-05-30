package com.example.leetcodehot100;

import com.example.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//怎么写都没有arrays.sort快
public class SortList_146 {
    public ListNode sortList(ListNode head) {
        int[] arr = listToInt(head);
//        mergeSort(arr,0,arr.length-1);
        intToList(arr,head);
        return head;
    }

    private int[] listToInt(ListNode head){
        List<Integer> list = new ArrayList<>();
        int[] temp = new int[lengthOfList(head)];
        int index=0;
        while (head!=null){
            temp[index++] = head.val;
            head = head.next;
        }
        int[] result = new int[index];
        for (int i=0;i<index;i++){
            result[i] = temp[i];
        }
        return result;
    }

    private void intToList(int[] arr,ListNode head){
        int index=0;
        while (head!=null){
            head.val = arr[index++];
            head = head.next;
        }
    }

    private int lengthOfList(ListNode head){
        int result = 0;
        while (head!=null){
            result+=1;
            head = head.next;
        }
        return result;
    }



//    public void mergeSort(int nums[],int start,int end){
//        if (start>=end){
//            return;
//        }
//        int mid = (start+end)/2;
//
//        mergeSort(nums,start,mid);
//        mergeSort(nums,mid+1,end);
//        int[] copy = nums.clone();
//        int i=start,j=mid+1,index=start;
//        for (;i<=mid&&j<=end&&index<nums.length;index++){
//            if (copy[i]<copy[j]){
//                nums[index] = copy[i];
//                i++;
//            }else {
//                nums[index] = copy[j];
//                j++;
//            }
//        }
//        if (i<=mid){
//            for (;i<=mid;i++,index++){
//                nums[index] = copy[i];
//            }
//        }
//        if (j<=end){
//            for (;j<=end;j++,index++){
//                nums[index] = copy[j];
//            }
//        }
//    }
//
//        快排排链表不好用 过不了最后一个
//    private void quickSort(ListNode head,ListNode end){
//        if (head==end){
//            return;
//        }
//        ListNode randomFirst = head;
//        while (goToNextOrNot(randomFirst,end)){
//            randomFirst = randomFirst.next;
//        }
//        ListNode first = head;
//        int t = first.val;
//        first.val = randomFirst.val;
//        randomFirst.val = t;
//        ListNode myHead = head.next;
//        ListNode needChange = head.next;
//        ListNode pre = head;
//        while (myHead!=end){
//            if (myHead.val<first.val){
//                t = needChange.val;
//                needChange.val = myHead.val;
//                myHead.val = t;
//                pre = pre.next;
//                needChange = needChange.next;
//            }
//            myHead = myHead.next;
//        }
//        t = first.val;
//        first.val = pre.val;
//        pre.val = t;
//        quickSort(first,pre);
//        quickSort(needChange,end);
//    }
//
//    private boolean goToNextOrNot(ListNode begin,ListNode end){
//        Random r = new Random();
//        boolean result = r.nextBoolean();
//        return (result&&(begin==end));
//    }
}
