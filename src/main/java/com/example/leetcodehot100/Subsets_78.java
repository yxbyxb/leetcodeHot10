package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        flashBack(result,temp,0,nums);
        return result;
    }

    private void flashBack(List<List<Integer>> result,List<Integer> temp,int index,int[] nums){
        if (index>=nums.length){
            return;
        }
        temp.add(nums[index]);
        result.add(new ArrayList<>(temp));
        flashBack(result,temp,index+1,nums);
        temp.remove(temp.indexOf(nums[index]));
        flashBack(result,temp,index+1,nums);
    }
}
