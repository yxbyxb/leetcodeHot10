package com.example.leetcodehot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//用并查集
public class LongestConsecutive_128 {
//    map 击败40%
    public int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        Map<Integer,int[]> map = new HashMap<>();
        int result = 1;
        for (int i=0;i<nums.length;i++){
            int[] current = new int[]{nums[i],nums[i]};
            if (map.get(nums[i])==null){
                map.put(nums[i],current);
            }else {
                continue;
            }
            int[] lastOne = map.get(nums[i]-1);
            int[] nextOne = map.get(nums[i]+1);
            if (lastOne!=null&&nextOne!=null){
                int[] right = map.get(nextOne[1]);
                int[] left = map.get(lastOne[0]);
                int begin = right[0] = left[0];
                int end = left[1] = right[1];
                int temp = end-begin+1;
                if (temp>result){
                    result = temp;
                }
            }else{
                boolean needCal = false;
                if (lastOne!=null){
                    int[] right = map.get(current[1]);
                    int[] left = map.get(lastOne[0]);
                    right[0] = left[0];
                    left[1] = right[1];
                    needCal = true;
                }
                if (nextOne!=null){
                    int[] right = map.get(nextOne[1]);
                    int[] left = map.get(current[0]);
                    right[0] = left[0];
                    left[1] = right[1];
                    needCal = true;
                }
                if (needCal){
                    int temp = current[1] - current[0]+1;
                    if (temp>result){
                        result = temp;
                    }
                }
            }
        }
        return result;
    }








    class SearchSet{
        private int[] parent;
        private int[] depth;

        public SearchSet(int n){
            this.parent = new int[n];
            for (int i=0;i<this.parent.length;i++){
                this.parent[i] = i;
            }
            for (int i=0;i<this.depth.length;i++){
                this.depth[i] = 1;
            }
        }

        public int find(int val){
            while(this.parent[val]!=val){
                val = this.parent[val];
            }
            return val;
        }

        public void put(int val){
            if (isValid(val-1)&&val-1!=parent[val-1]){
                parent[val] = parent[val-1];
            }
            if (isValid(val+1)){

            }
        }

        public boolean isValid(int n){
            if (n>=0&&n<parent.length){
                return true;
            }
            return false;
        }

        public void union(int a,int b){
            if (this.depth[a]<this.depth[b]){
                parent[a] = b;
            }
        }
    }
}
