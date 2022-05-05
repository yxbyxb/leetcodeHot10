package com.example.leetcodehot100;

public class Merge_56 {
    public int[][] merge(int[][] intervals) {
        quickSort(intervals,0,intervals.length-1);
        int[][] temp = new int[intervals.length][2];
        int index = 0;
        int[] origin = new int[2];
//        i:originIndex j:mergingIndex
        for (int i=0;i<intervals.length;){
            if (i==intervals.length-1){
                temp[index][0] = intervals[i][0];
                temp[index][1] = intervals[i][1];
                index++;
                break;
            }
            origin[0] = intervals[i][0];
            origin[1] = intervals[i][1];
            for (int j = i+1;j<intervals.length;j++){
                if (origin[1]>intervals[j][1]){
                    if (j==intervals.length-1){
                        temp[index][0] = origin[0];
                        temp[index][1] = origin[1];
                        index++;
                        i = j+1;
                        break;
                    }
                    continue;
                }
                if (origin[1]>=intervals[j][0]){
                    origin[1] = intervals[j][1];
                    if (j==intervals.length-1){
                        temp[index][0] = origin[0];
                        temp[index][1] = origin[1];
                        index++;
                        i = j+1;
                        break;
                    }
                }else {
                    temp[index][0] = origin[0];
                    temp[index][1] = origin[1];
                    index++;
                    i = j;
                    break;
                }
            }

        }
        int[][] result = new int[index][2];
        for (int i=0;i<index;i++){
            result[i] = temp[i];
        }
        return result;
    }

    private void quickSort(int[][] intervals,int begin,int end){
        if (begin>=end){
            return ;
        }
        int[] temp = intervals[begin];
        int i=begin+1;
        int index = i;
        for (;i<=end;i++){
            if (intervals[i][0]<temp[0]){
                int[] t = intervals[i];
                intervals[i] = intervals[index];
                intervals[index] = t;
                index++;
            }
        }
        intervals[begin] = intervals[index-1];
        intervals[index-1] = temp;
        quickSort(intervals,begin,index-2);
        quickSort(intervals,index,end);
    }
}
