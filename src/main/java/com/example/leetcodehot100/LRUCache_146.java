package com.example.leetcodehot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache_146 {

    private Queue<Integer> queue;
    private Map<Integer,Integer> map;
    private int length = 0;
    private  int capacity;

    public LRUCache_146(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        boolean flag = queue.contains(key);
        if (flag) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(queue.contains(key)){
            queue.remove(key);
            map.put(key,value);
            queue.add(key);
        }else {
            if (length==capacity){
                queue.remove();
                map.put(key,value);
                queue.add(key);
            }else {
                map.put(key,value);
                queue.add(key);
                length++;
            }
        }
    }
}
