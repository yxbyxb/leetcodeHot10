package com.example.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision_037 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<asteroids.length;i++){
            if (stack.isEmpty()||!crash(stack.peek(),asteroids[i])){
                stack.push(asteroids[i]);
                continue;
            }
            boolean needPush = true;
            while (!stack.isEmpty()&&crash(stack.peek(),asteroids[i])){
                Integer peek = stack.peek();
                if (peek==-asteroids[i]){
                    stack.pop();
                    needPush = false;
                    break;
                }else if(peek<-asteroids[i]){
                    stack.pop();
                }else{
                    needPush = false;
                    break;
                }
            }
            if(needPush){
                stack.push(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length-1; i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean crash(int a, int b){
        if ((a>0&&b<0)){
            return true;
        }
        return false;
    }
}
