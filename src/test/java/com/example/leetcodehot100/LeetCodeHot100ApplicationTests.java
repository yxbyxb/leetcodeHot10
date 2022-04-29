package com.example.leetcodehot100;

import com.example.study.fileAndFlow.FileCopier;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
        GroupAnagrams_49 groupAnagrams_49 = new GroupAnagrams_49();
        List<List<String>> lists = groupAnagrams_49.groupAnagrams(new String[]{"abc", "acb", "cd", "dc", "yxb", "bac"});
        System.out.println(lists);
    }

    public void quickSort(StringBuilder result,int begin,int end){
        if (begin>=end){
            return ;
        }
        char temp = result.charAt(begin);
        int i=begin+1;
        int index = i;
        for (;i<=end;i++){
            if (result.charAt(i)<temp){
                char t = result.charAt(i);
                result.replace(i,i+1,result.charAt(index)+"");
                result.replace(index,index+1,t+"");
                index++;
            }
        }
        result.replace(begin,begin+1,result.charAt(index-1)+"");
        result.replace(index-1,index,temp+"");
        quickSort(result,begin,index-2);
        quickSort(result,index,end);
    }

}
