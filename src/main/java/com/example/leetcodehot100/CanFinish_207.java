package com.example.leetcodehot100;

import java.util.*;

public class CanFinish_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        0为访问 1 已访问 -1搜索中
        int[] visited = new int[numCourses];
        List<Integer>[] find = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == prerequisites[i][1]) {
                return false;
            }
            if (find[prerequisites[i][1]] == null) {
                find[prerequisites[i][1]] = new ArrayList<>();
                find[prerequisites[i][1]].add(prerequisites[i][0]);
            } else {
                find[prerequisites[i][1]].add(prerequisites[i][0]);
            }
        }
        for (int i = 0; i < find.length; i++) {
            if (visited[i]==1){
                continue;
            }
            boolean dfs = dfs(find, visited, i);
            if (!dfs) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] find, int[] visited, int currentCourse) {
        if (visited[currentCourse] == -1) {
            return false;
        }
        visited[currentCourse] = -1;
        List<Integer> list = find[currentCourse];
        if (list==null){
            visited[currentCourse] = 1;
            return true;
        }
        for (int i : list) {
            if (visited[i]==1){
                continue;
            }
            boolean dfs = dfs(find, visited, i);
            if (!dfs) {
                return false;
            }
        }
        visited[currentCourse] = 1;
        return true;
    }


//    下面是石山代码
    /**
     * find[i] 表示学i之前要先学find[i]
     * 看有没有形成环形
     * 快慢指针
     * find[i]可能有多个 用一个set存下 如果有重复的就说明有环形        ×
     * slow自己或者fast自己里有重复的说明有环
     * find[i]只有一个 切这一个find[i]==i的时候 说明到了顶点 没有环   ×
     * slow或者fast集合里所有的find[i]==i的时候说明走到了尽头
     */
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<Integer>[] find = new List[numCourses];
//        for (int i=0;i<prerequisites.length;i++){
//            if (prerequisites[i][0]==prerequisites[i][1]){
//                return false;
//            }
//            if (find[prerequisites[i][0]]==null){
//                find[prerequisites[i][0]] = new ArrayList<>();
//                find[prerequisites[i][0]].add(prerequisites[i][1]);
//            }else{
//                find[prerequisites[i][0]].add(prerequisites[i][1]);
//            }
//        }
//        for (int i=0;i<numCourses;i++){
//            if (find[i]==null){
//                find[i] = new ArrayList<>();
//                find[i].add(i);
//            }
//        }
//        for (int i=0;i<find.length;i++){
//            if (hasCircle(find,i)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean hasCircle(List<Integer>[] find,int index){
//        if (goingAround(find,index,new HashSet<>())){
//            return false;
//        }
//        return true;
//    }
//
////    能不能走到头
////    回溯又超时 操你妈
//    private boolean goingAround(List<Integer>[] find,int index,Set<Integer> hasPassed){
//        if (find[index].size()==1&&index==find[index].get(0)){
//            return true;
//        }
//        for (int i  = 0;i< find[index].size();i++){
//            if (!hasPassed.add(find[index].get(i))){
//                return false;
//            }else{
//                boolean temp = goingAround(find,find[index].get(i),hasPassed);
//                if (!temp){
//                    return false;
//                }
//                hasPassed.remove(find[index].get(i));
//            }
//        }
//        return true;
//    }

}
