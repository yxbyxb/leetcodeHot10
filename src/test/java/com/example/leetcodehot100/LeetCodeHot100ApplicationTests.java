package com.example.leetcodehot100;

import com.example.Pojo.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
        LetterCombinations_17 letterCombinations17 = new LetterCombinations_17();
        List<String> strings = letterCombinations17.letterCombinations("23");
        System.out.println(strings);
    }

    @Test
    public void removeNthFromEndTest() {
        RemoveNthFromEnd_19 removeNthFromEnd_19 = new RemoveNthFromEnd_19();
        ListNode inputListNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        removeNthFromEnd_19.removeNthFromEnd(inputListNode,2);
        while (inputListNode!=null){
            System.out.println(inputListNode.val);
            inputListNode = inputListNode.next;
        }
    }
}
