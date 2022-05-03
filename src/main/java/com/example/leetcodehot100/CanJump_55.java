package com.example.leetcodehot100;

public class CanJump_55 {
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        int needReach = nums.length-1;
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i]+i>=needReach){
                needReach=i;
            }
        }
        return needReach==0?true:false;
    }

//    递归
//    public boolean canJump(int[] nums) {
//        if (nums.length==1){
//            return true;
//        }
//        return myCanJump(nums,nums.length-1,nums.length-2);
//    }
//
//    private boolean myCanJump(int[] nums,int needReach,int index){
//        if(needReach==0){
//            return true;
//        }
//        if (index<0){
//            return false;
//        }
//        if (nums[index]+index>=needReach){
//            return myCanJump(nums,index,index-1);
//        }else{
//            return myCanJump(nums,needReach,index-1);
//        }
//    }
}
