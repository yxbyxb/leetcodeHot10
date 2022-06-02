package com.example.leetcodehot100;

public class MaximalSquare_221 {
    //    正方形的左上角和右下角 (a,b)到(m,n)是矩形的条件是 (a,b)到(m-1,n-1)是矩形切m-a这一列和n-b这一行都是1
    public int maximalSquare(char[][] matrix) {
//         i,j,len-1
        char[][][] dp = new char[matrix.length][matrix[0].length][(matrix.length < matrix[0].length ? matrix.length : matrix[0].length)];
//      某一行 某一列的  i-j是否都是‘1’ 0表示初始 1表示都是1 2表示不都是1 i~j是否都是1 =i~j-1 && j本身 把allOne也用动态规划做不知道能不能快点
//        这下好了 把空间也挤爆了
        int[][][] rowAllOne = new int[matrix.length][matrix[0].length][matrix[0].length];
        int[][][] colAllOne = new int[matrix[0].length][matrix.length][matrix.length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    rowAllOne[i][j][j] = 1;
                }else{
                    rowAllOne[i][j][j] = 2;
                }
            }
        }
        for (int i=0;i<matrix[0].length;i++){
            for (int j=0;j<matrix.length;j++){
                if (matrix[j][i]=='1'){
                    colAllOne[i][j][j] = 1;
                }else{
                    colAllOne[i][j][j] = 2;
                }
            }
        }
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j][0] = '1';
                    if (maxLen!=1){
                        maxLen=1;
                    }
                }else {
                    dp[i][j][0] = '0';
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int lenMinusOne = 1; i+lenMinusOne<matrix.length&&j+lenMinusOne<matrix[0].length; lenMinusOne++) {
                    if (dp[i][j][lenMinusOne -1] == '1' && allOne(matrix, i, j, lenMinusOne+1,rowAllOne,colAllOne)) {
                        dp[i][j][lenMinusOne] = '1';
                        if (maxLen<lenMinusOne+1){
                            maxLen=lenMinusOne+1;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return maxLen*maxLen;
    }

    private boolean allOne(char[][] matrix, int i, int j, int len,int[][][] rowAllOne,int[][][] colAllOne) {
        if(colAllOne[j+len-1][i][i+len-1-1]==0){
            for (int m=i+1;m<i+len;m++){
                if (colAllOne[j+len-1][i][m]!=0){
                    continue;
                }else{
                    if (colAllOne[j+len-1][i][m-1]==1&&matrix[m][j+len-1]=='1'){
                        colAllOne[j+len-1][i][m] = 1;
                    }else{
                        colAllOne[j+len-1][i][m] = 2;
                    }
                }
            }
        }else {
            if (colAllOne[j+len-1][i][i+len-1-1]==1&&matrix[i+len-1][j+len-1]=='1'){
                colAllOne[j+len-1][i][i+len-1] = 1;
            }else{
                colAllOne[j+len-1][i][i+len-1] = 2;
            }
        }
        if (colAllOne[j+len-1][i][i+len-1]==2){
            return false;
        }


        if(rowAllOne[i+len-1][j][j+len-1-1]==0){
            for (int m=j+1;m<j+len;m++){
                if (rowAllOne[i+len-1][j][m]!=0){
                    continue;
                }else{
                    if (rowAllOne[i+len-1][j][m-1]==1&&matrix[i+len-1][m]=='1'){
                        rowAllOne[i+len-1][j][m] = 1;
                    }else{
                        rowAllOne[i+len-1][j][m] = 2;
                    }
                }
            }
        }else{
            if (rowAllOne[i+len-1][j][j+len-1-1]==1&&matrix[i+len-1][j+len-1]=='1'){
                rowAllOne[i+len-1][j][j+len-1] = 1;
            }else{
                rowAllOne[i+len-1][j][j+len-1] = 2;
            }
        }

        if (rowAllOne[i+len-1][j][j+len-1]==2){
            return false;
        }

//        加动态规划前的老逻辑
//        for (int index = i; index < i + len; index++) {
//            if (matrix[index][j+len-1] != '1') {
//                return false;
//            }
//        }
//        for (int index = j; index < j + len; index++) {
//            if (matrix[i+len-1][index] != '1') {
//                return false;
//            }
//        }
        return true;
    }
}
