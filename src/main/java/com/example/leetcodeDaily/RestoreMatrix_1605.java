package com.example.leetcodeDaily;

public class RestoreMatrix_1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        int[] currentRowSum = new int[rowSum.length];
        int[] currentColSum = new int[colSum.length];
        System.arraycopy(colSum, 0, currentColSum, 0, colSum.length);
        for (int i = 0; i < rowSum.length; i++) {
            currentRowSum[i] = rowSum[i];
            for (int j = 0; j < colSum.length; j++) {
                if (currentRowSum[i] > currentColSum[j] ) {
                    result[i][j] = currentColSum[j];
                    currentRowSum[i] -= currentColSum[j];
                    currentColSum[j] -= currentColSum[j];
                } else {
                    result[i][j] = currentRowSum[i];
                    currentColSum[j] -= currentRowSum[i];
                    currentRowSum[i] -= currentRowSum[i];
                }
                if (currentRowSum[i] <= 0) {
                    break;
                }
            }
        }
        return result;
    }
}
