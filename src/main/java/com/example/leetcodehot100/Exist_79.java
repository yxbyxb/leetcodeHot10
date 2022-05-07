package com.example.leetcodehot100;

public class Exist_79 {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    if (word.length()==1){
                        return true;
                    }
                    int[][] used = new int[board.length][board[0].length];
                    used[i][j] = 1;
                    boolean exist = dfs(board, word, 1, i, j,used);
                    used[i][j] = 0;
                    if (exist){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int indexOfWord,int row,int col,int[][] used){
        if (indexOfWord==word.length()){
            return true;
        }
        char c = word.charAt(indexOfWord);
        boolean result = false ;
        if (row!=0){
            if (board[row-1][col]==c&&used[row-1][col]==0){
                used[row-1][col] = 1;
                result = dfs(board,word,indexOfWord+1,row-1,col,used);
                if (result){
                    return true;
                }
            }
        }
        if (row!=board.length-1){
            if (board[row+1][col]==c&&used[row+1][col]==0){
                used[row+1][col] = 1;
                result = dfs(board,word,indexOfWord+1,row+1,col,used);
                if (result){
                    return true;
                }
            }
        }
        if (col!=0){
            if (board[row][col-1]==c&&used[row][col-1]==0){
                used[row][col-1] = 1;
                result = dfs(board,word,indexOfWord+1,row,col-1,used);
                if (result){
                    return true;
                }
            }
        }
        if (col!=board[0].length-1){
            if (board[row][col+1]==c&&used[row][col+1]==0){
                used[row][col+1] = 1;
                result = dfs(board,word,indexOfWord+1,row,col+1,used);
                if (result){
                    return true;
                }
            }
        }
        used[row][col] = 0;
        return false;
    }

    private int[] getPosition(char[][] board,char c,int row,int col,int[][] used){
        int[] result = new int[]{-1,-1};
        if (row!=0){
            if (board[row-1][col]==c&&used[row-1][col]==0){
                result[0] = row-1;
                result[1] = col;
            }
        }
        if (row!=board.length-1){
            if (board[row+1][col]==c&&used[row+1][col]==0){
                result[0] = row+1;
                result[1] = col;
            }
        }
        if (col!=0){
            if (board[row][col-1]==c&&used[row][col-1]==0){
                result[0] = row;
                result[1] = col-1;
            }
        }
        if (col!=board[0].length-1){
            if (board[row][col+1]==c&&used[row][col+1]==0){
                result[0] = row;
                result[1] = col+1;
            }
        }
        return result;
    }
}
