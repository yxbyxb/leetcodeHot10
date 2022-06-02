package com.example.leetcodehot100;

public class NumIslands_200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j]=='1'){
                    result++;
                    infect(grid,i,j);
                }
            }
        }

        return result;
    }

    private void infect(char[][] grid,int row,int col){
        if (row<0||row>=grid.length||col<0||col>=grid[0].length){
            return;
        }
        if (grid[row][col]=='1'){
            grid[row][col] = '2';
            infect(grid,row,col-1);
            infect(grid,row,col+1);
            infect(grid,row-1,col);
            infect(grid,row+1,col);
        }
    }
}
