package com.example.leetcodehot100;

public class FindDuplicate_287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        for(;;){
            if (fast==slow){
                break;
            }else{
                fast = nums[fast];
                fast = nums[fast];
                slow = nums[slow];
            }
        }
        int temp = 0;
        while(temp!=slow){
            slow = nums[slow];
            temp = nums[temp];
        }
        return temp;
    }
}
