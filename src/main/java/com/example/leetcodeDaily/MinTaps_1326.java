package com.example.leetcodeDaily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinTaps_1326 {
    int count = 0;

    public int minTaps(int n, int[] ranges) {
        int currentStart = n;
        int currentEnd = 0;
//        stack存打开的龙头的水的右位置
        Deque<Integer> stackLeft = new ArrayDeque();
//        stack存打开的龙头的水的右位置
        Deque<Integer> stackRight = new ArrayDeque();
        for (int i = 0; i <= n; i++) {
            if (ranges[i] == 0) {
                continue;
            }
            int tempStart = i - ranges[i];
            tempStart = tempStart < 0 ? 0 : tempStart;
            int tempEnd = i + ranges[i];
            tempEnd = tempEnd > n ? n : tempEnd;
            if (tempStart <= currentEnd) {
                if (tempEnd > currentEnd) {
                    currentEnd = tempEnd;
                    this.pourStack(stackLeft, stackRight, tempStart, currentStart);
                    stackLeft.push(tempStart);
                    stackRight.push(tempEnd);
                    this.count++;
                }
                if (tempStart <= currentStart) {
                    currentStart = tempStart;
                }
            }
        }
        if (currentStart <= 0 && currentEnd >= n) {
            return this.count;
        }
        return -1;
    }

    private void pourStack(Deque<Integer> stackLeft, Deque<Integer> stackRight, int tempStart, int currentStart) {
        if (tempStart <= 0) {
            this.count -= stackRight.size();
            stackRight.clear();
            stackLeft.clear();
            return;
        }
        while (stackRight.size() > 1) {
            if (stackRight.peek() >= tempStart) {
                Integer lastRight = stackRight.pop();
                Integer lastLeft = stackLeft.pop();
                if (stackRight.peek() >= tempStart) {
                    this.count--;
                } else {
                    stackRight.push(lastRight);
                    stackLeft.push(lastLeft);
                    return;
                }
            }
        }
        if (!stackRight.isEmpty()) {
            if (tempStart <= stackLeft.peek()) {
                stackLeft.pop();
                stackRight.pop();
                this.count--;
            }
        }
    }
}
