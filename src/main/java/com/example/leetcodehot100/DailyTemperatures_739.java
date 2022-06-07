package com.example.leetcodehot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures_739 {

    //    我必须立即使用单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> monotonousStack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!monotonousStack.isEmpty()&&temperatures[monotonousStack.peekFirst()] < temperatures[i]){
                Integer pop = monotonousStack.removeFirst();
                answer[pop] = i-pop;
            }
            monotonousStack.addFirst(i);
        }
        return answer;
    }

//    暴力纯纯的慢比
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] answer  = new int[temperatures.length];
//        for (int i=0;i<temperatures.length-1;i++){
//            for (int j = i+1;j<temperatures.length;j++){
//                if (temperatures[j]>temperatures[i]){
//                    answer[i] = j-i;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }
}
