package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

//剪枝不会 只击败了25%
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        flashBack(result,candidates,target,0,0,temp);
        return result;
    }

    private void flashBack(List<List<Integer>> result,int[] candidates,int target,int index,int sum,List<Integer> temp){
        if (sum==target){
            result.add(new ArrayList<>(temp));
        }else if (sum>target||index>=candidates.length){
        }else{
            temp.add(candidates[index]);
            flashBack(result,candidates,target,index,sum+candidates[index],temp);
            temp.remove(temp.lastIndexOf(candidates[index]));
            flashBack(result,candidates,target,index+1,sum,temp);
        }
    }
}
