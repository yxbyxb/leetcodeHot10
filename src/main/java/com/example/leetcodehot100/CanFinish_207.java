package com.example.leetcodehot100;

import java.util.*;

public class CanFinish_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] find = new int[numCourses][numCourses];
        for (int i=0;i<numCourses;i++){
            for (int j=1;j<find[0].length;j++){
                find[i][j] = i;
            }

        }
        for (int i=0;i<prerequisites.length;i++){
            if (prerequisites[i][0]==prerequisites[i][1]){
                return false;
            }
            find[prerequisites[i][0]][++find[prerequisites[i][0]][0]] =prerequisites[i][1];
        }
        for (int i=0;i<find.length;i++){
            if (hasCircle(find,i)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCircle(int[][] find,int index){
//        for (int i=1;i<=find[index][0];i++){
//            if (index == find[index][i]){
//                return false;
//            }
//        }
//
//        Set<Integer> parents = new HashSet<>();
//        int[] quick = new int[find[0].length];
//        for (int i=0;i<find[quick[i]].length;i++)
//        for ()
//        while (true){
//            for
//            find[index]!=index&&find[quick]!=quick
//            index = find[index];
//            quick = find[quick];
//            quick = find[quick];
//            if (index==quick){
//                return true;
//            }
//        }
        return false;
    }

}
