package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        flashBack(result,candidates,target,0,0,new ArrayList<>(),0);
        return result;
    }

    private void flashBack(List<List<Integer>> result,int[] candidates,int target,int index,int sum,List<Integer> temp,int j){
        if (sum>target){
            return;
        }
        if (sum==target){
            result.add(temp);
            return;
        }
        if (index==candidates.length){
            return;
        }

        for (int i=j;i<candidates.length;i++){
            temp.add(candidates[i]);
            flashBack(result,candidates,target,index+1,sum+candidates[i],temp, j);
            temp.remove(temp.lastIndexOf(candidates[i]));
        }
    }
}
