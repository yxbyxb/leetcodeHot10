package com.example.leetcodehot100;

import com.example.study.fileAndFlow.FileCopier;
import org.junit.jupiter.api.Test;

import java.io.IOException;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
        FileCopier fileCopier = new FileCopier();
        fileCopier.readChineseFile();
    }

}
