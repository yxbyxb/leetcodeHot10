package com.example.leetcodehot100;

import com.example.leetcodeDaily.ReorderLogFiles_937;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
        ReorderLogFiles_937 reorderLogFiles_937 = new ReorderLogFiles_937();
        String[] strings = reorderLogFiles_937.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
        for (String s : strings){
            System.out.println(s);
        }
    }

}
