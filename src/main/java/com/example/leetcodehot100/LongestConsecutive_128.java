package com.example.leetcodehot100;

//用并查集
public class LongestConsecutive_128 {
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

        public void union(int a,int b){
            if (this.depth[a]<this.depth[b]){
                parent[a] = b;
            }
        }
    }
}
