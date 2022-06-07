package com.example.leetcodehot100;

public class ReconstructQueue_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 1) {
            return people;
        }
        quickSortByHeightDesc(people, 0, people.length - 1);
        insertSortByNum(people, 0, people.length - 1);
        return people;
    }

    private void insertSortByNum(int[][] people, int begin, int end) {
        for (int i = 1; i < people.length; i++) {
            for (int j = i; j > 0; j--) {
                if (people[j][1] < j) {
                    int[] t = people[j];
                    people[j] = people[j - 1];
                    people[j - 1] = t;
                } else {
                    break;
                }
            }
        }
    }

    private void quickSortByHeightDesc(int[][] people, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int[] temp = people[begin];
        int i = begin + 1;
        int index = i;
        for (; i <= end; i++) {
            if (isABiggerThanB(people[i] , temp)) {
                int[] t = people[i];
                people[i] = people[index];
                people[index] = t;
                index++;
            }
        }
        people[begin] = people[index - 1];
        people[index - 1] = temp;
        quickSortByHeightDesc(people, begin, index - 2);
        quickSortByHeightDesc(people, index, end);
    }

    private boolean isABiggerThanB(int[] a,int[] b){
        if (a[0]>b[0]){
            return true;
        }

        if (a[0]==b[0]){
            if (a[1]<b[1]){
                return true;
            }
        }

        return false;
    }

    private void mergeSortByHeightDesc(int[][] people, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = (begin + end) / 2;
        mergeSortByHeightDesc(people, begin, mid);
        mergeSortByHeightDesc(people, mid + 1, end);

        int[][] copy = people.clone();
        int i = begin, j = mid + 1, index = begin;
        for (; i <= mid && j <= end && index < people.length; index++) {
            if (copy[i][0] > copy[j][0]) {
                people[index] = copy[i];
                i++;
            } else if (copy[i][0] < copy[j][0]) {
                people[index] = copy[j];
                j++;
            } else {
                if (copy[i][1] < copy[j][1]) {
                    people[index] = copy[i];
                    i++;
                } else {
                    people[index] = copy[j];
                    j++;
                }
            }
        }
        if (i <= mid) {
            for (; i <= mid; i++, index++) {
                people[index] = copy[i];
            }
        }
        if (j <= end) {
            for (; j <= end; j++, index++) {
                people[index] = copy[j];
            }
        }
    }
}
