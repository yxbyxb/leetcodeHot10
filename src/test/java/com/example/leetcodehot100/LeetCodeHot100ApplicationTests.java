package com.example.leetcodehot100;

import com.example.leetcodeDaily.AnswerQueries_2389;
import com.example.leetcodeDaily.CountSubstrings_1638;
import com.example.leetcodeDaily.MergeStones_1000;
import org.junit.jupiter.api.Test;

import java.util.*;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    void aFunction() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        indegress存每个节点还有几个入度
        Map<Integer, Integer> indegrees = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt();
                graph.get(k).add(i);
                indegrees.put(i, indegrees.getOrDefault(i, 0) + 1);
            }
        }
//        计算需要几次
        int count = 0;
        while (!indegrees.isEmpty()) {
            Deque<Integer> queue = new ArrayDeque<>();
//            把当前入度为0的放入一个队列进来
            for (int i = 1; i <= n; i++) {
                if (indegrees.get(i) == 0) {
                    queue.push(i);
                }
            }
//            把入度为0的所有节点的相关节点入度-1
            while (!queue.isEmpty()) {
                Deque<Integer> newDequeue = new ArrayDeque<>();
                Integer pop = queue.pop();
//                把当前这个入度为0的从indegrees里移除
                indegrees.remove(pop);
                List<Integer> needMinus = graph.get(pop);
//            把入度为0的所有节点的相关节点入度-1
                for (Integer tempNode: needMinus) {
                    Integer tempNodeNum = indegrees.get(tempNode);
//                    如果当前节点入度为1，也就是-1后为0，放入新队列中
                    if (tempNodeNum == 1) {
                        newDequeue.add(tempNode);
                    }
                    indegrees.put(tempNode,tempNodeNum - 1);
                }
//                把队列换成新队列
                queue = newDequeue;
                count ++ ;
            }
        }
        System.out.println(count);
    }

    @Test
    public void doSomeTest() {
        long begin = System.nanoTime();
        long m = 0;
        for (long i = 0; i < 10000000000L; i++) {
            m++;
        }
        long end = System.nanoTime();
        System.out.println((end-begin)/1000000 + "ms");
    }

    private void update(int[] a) {
        a[0] = 100;
        System.out.println(a[0]);
    }

    @Test
    public void processTimeCostTest() {
        long start = System.nanoTime();
        int a = 1;
        int b = 2;
        for (int i = 0; i < 1000000000; i++) {
            int temp = a;
            a = b;
            b = temp;
        }
        long stop = System.nanoTime();
        System.out.println((stop - start) / 1000000 + "ms");
    }

    @Test
    public void CountSubstrings_1638Test() {
        CountSubstrings_1638 countSubstrings1638 = new CountSubstrings_1638();
        String s = "aba";
        String t = "baba";
        int i = countSubstrings1638.countSubstrings(s, t);
        System.out.println(i);
    }

    @Test
    public void MergeStones_1000Test() {
        MergeStones_1000 mergeStones1000 = new MergeStones_1000();
        int[] stones = new int[]{6, 4, 4, 6};
        int k = 2;
        int i = mergeStones1000.mergeStones(stones, k);
        System.out.println(i);
    }

    @Test
    public void AnswerQueries_2389Test() {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        AnswerQueries_2389 answerQueries2389 = new AnswerQueries_2389();
        int[] ints = answerQueries2389.answerQueries(nums, queries);
        System.out.println(ints);
    }

    @Test
    public void maximalSquare_221_Test() {
        MaximalSquare_221 maximalSquare_221 = new MaximalSquare_221();
        char[][] chars1 = new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'},
        };
        char[][] chars2 = new char[][]{
                new char[]{'1', '0'},
                new char[]{'0', '1'},
        };
        char[][] chars3 = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'0', '0', '1', '1', '1'},
        };
        char[][] chars4 = new char[][]{
                new char[]{'1', '1'},
                new char[]{'1', '1'},
        };
        char[][] chars5 = new char[][]{
                new char[]{'0', '0', '0', '1'},
                new char[]{'1', '1', '0', '1'},
                new char[]{'1', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'},
        };
        char[][] chars6 = new char[][]{
                new char[]{'1', '1', '1', '1', '1', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '1', '0', '0', '0'},
                new char[]{'0', '1', '1', '1', '1', '0', '0', '0'},
        };
        int i = maximalSquare_221.maximalSquare(chars6);
        System.out.println(i);
    }

}
