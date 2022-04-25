package com.example.leetcodehot100;

//此题为耻辱 建议日后重刷 今天脑袋转不动了
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int left = -1;
        for (int i=nums.length-1;i>0;i--) {
            if (nums[i]>nums[i-1]) {
                left = i-1;
                break;
            }
        }
        if (left==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        for (int j=nums.length-1;j>left;j--){
            if (nums[left]<nums[j]){
                int temp = nums[left];
                nums[left] = nums[j];
                nums[j] = temp;
                reverse(nums,left+1,nums.length-1);
                return;
            }
        }
    }

    private void reverse(int[] nums,int left,int right){
        for (int i=left,j=right;i<j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
