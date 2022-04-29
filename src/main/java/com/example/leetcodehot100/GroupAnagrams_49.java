package com.example.leetcodehot100;

import java.util.*;

//27ms 击败8.38 应该是string的效率比array低 问题不大 改成array应该就好了
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i=0;i<strs.length;i++){
            StringBuilder sb = new StringBuilder(strs[i]);
            quickSort(sb,0,sb.length()-1);
            String key = sb.toString();
            if (map.get(key)==null){
                List<String> list = new ArrayList<>();
                map.put(key,list);
            }
            List<String> list = map.get(key);
            list.add(strs[i]);
        }
        for (List<String> list :map.values()){
            result.add(list);
        }
        return result;
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
