package com.example.leetcodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMutation_433 {

    public int minMutation(String start, String end, String[] bank) {
        int[] min = new int[1];
        min[0] = 100000;
        int[] used = new int[bank.length];
        flashBack(bank,end,start,0,0,min,used);
        if (min[0]==100000){
            min[0] = -1;
        }
        return min[0];
    }

    private void flashBack(String[] bank, String end,String temp,int index,int result,int[] min,int[] used){
        if (temp.equals(end)){
            if (result<min[0]){
                min[0] = result;
            }
            return;
        }
        if (index==bank.length){
            return;
        }
        if (used[index]!=1&&canReach(temp,bank[index])){
            used[index] = 1;
            flashBack(bank,end,bank[index],0,result+1,min,used);
            used[index] = 0;
            flashBack(bank,end,temp,index+1,result,min,used);
        }else {
            flashBack(bank,end,temp,index+1,result,min,used);
        }

    }

    private boolean canReach(String target,String temp){
        if (target.length()!=temp.length()){
            return false;
        }
        int step = 0;
        for (int i=0;i<target.length();i++){
            if (target.charAt(i)!=temp.charAt(i)){
                step++;
                if (step>1){
                    return false;
                }
            }
        }
        if (step==0){
            return false;
        }
        return true;
    }

    //        这是一段可以建立所有的i能到达的j的索引的代码
        /*Map<String, List<String>> map = new HashMap<>();
        for (int i=0;i<bank.length;i++){
            for (int j=0;j<bank.length;j++){
                List<String> list = map.getOrDefault(bank[i],new ArrayList<>());
                if (canReach(bank[j],bank[i])){
                    list.add(bank[j]);
                }
            }
        }
        for (int i=0;i<bank.length;i++){
            List<String> list = map.getOrDefault(start,new ArrayList<>());
            if (canReach(bank[i],bank[i])){
                list.add(bank[i]);
            }
        }*/
}
