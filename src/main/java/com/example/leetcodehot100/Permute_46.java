package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//回溯 1ms 击败82.13
public class Permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(result,0,nums,temp);
        return result;
    }

    public void dfs(List<List<Integer>> result ,int index,int nums[],List<Integer> temp){
        if (index==nums.length){
            result.add(new ArrayList<>(temp));
        }else {
            for(int i = 0;i<nums.length;i++){
                if (nums[i]!=100){
                    int tempNum = nums[i];
                    temp.add(tempNum);
                    nums[i] = 100;
                    dfs(result,index+1,nums,temp);
                    temp.remove(temp.indexOf(tempNum));
                    nums[i] = tempNum;
                }
            }
        }
    }

}
