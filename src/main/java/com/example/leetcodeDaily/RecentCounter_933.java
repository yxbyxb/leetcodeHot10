package com.example.leetcodeDaily;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter_933 {
    List<Integer> requests = new ArrayList<>();
    int last3kPing = 0;
    int index = 0;

    public RecentCounter_933() {
    }

    public int ping(int t) {
        requests.add(t);
        last3kPing++;
        for(;index<requests.size();index++){
            int temp = requests.get(index);
            if(temp<t-3000){
                last3kPing--;
            }else {
                break;
            }
        }
        return last3kPing;
    }

}
