package com.example.leetcodehot100;


import java.util.HashSet;
import java.util.Set;

/**
 * 208
 * 前缀树 待优化 Vector<Tree>
 */
public class Trie {
    Set<String> map;
    Set<String> mapPre;

    public Trie() {
        map = new HashSet<>();
        mapPre = new HashSet<>();
    }

    public void insert(String word) {
        map.add(word);
        for (int i = 0; i < word.length(); i++) {
            mapPre.add(word.substring(0, i + 1));
        }
    }

    public boolean search(String word) {
        return map.contains(word);
    }

    public boolean startsWith(String prefix) {
        return mapPre.contains(prefix);
    }
}
