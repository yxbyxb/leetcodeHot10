package com.example.leetcodehot100;

//    * * * * *             · · · · *
//    · · · · ·     ---->   · · · · *
//    · · · · ·     ---->   · · · · *
//    · · · · ·             · · · · *
public class Rotate_48 {
    public void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                matrix[j][matrix.length-i-1] = temp[i][j];
            }
        }
    }
}
