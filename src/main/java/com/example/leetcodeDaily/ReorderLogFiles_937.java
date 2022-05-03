package com.example.leetcodeDaily;

public class ReorderLogFiles_937 {
    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        int index = result.length-1;
        int index2 = 0;
        for (int i=logs.length-1;i>=0;i--){
            char c = logs[i].charAt(logs[i].length()-1);
            if (c>=0+'0'&&c<=9+'0'){
                result[index] = logs[i];
                index--;
            }else {
                result[index2] = logs[i];
                index2++;
            }
        }

        quickSort(result,0,index);
        return result;
    }

    private void quickSort(String[] logs,int begin,int end){
        if (begin>=end){
            return ;
        }
        String temp = logs[begin];
        int i=begin+1;
        int index = i;
        for (;i<=end;i++){
            if (isASmallerThanB(logs[i],temp)){
                String t = logs[i];
                logs[i] = logs[index];
                logs[index] = t;
                index++;
            }
        }
        logs[begin] = logs[index-1];
        logs[index-1] = temp;
        quickSort(logs,begin,index-2);
        quickSort(logs,index,end);
    }

    private boolean isASmallerThanB(String a,String b){
        int indexA = a.indexOf(" ");
        int indexB = b.indexOf(" ");
        boolean result = false;
        if (a.substring(indexA+1).equals(b.substring(indexB+1))){
            for (int i = 0;i<indexA&&i<indexB;i++){
                if (a.charAt(i)!=b.charAt(i)){
                    result = a.charAt(i)<b.charAt(i) ? true : false;
                    break;
                }
            }
        }else {
            for (int i = indexA+1,j=indexB+1;i<a.length()&&j<b.length();i++,j++){
                if (a.charAt(i)!=b.charAt(j)){
                    result = a.charAt(i)<b.charAt(j) ? true : false;
                    break;
                }
            }
        }
        return result;
    }

//    private boolean isABiggerThanB(String a,String b){
//        int indexA = a.indexOf(" ");
//        int indexB = b.indexOf(" ");
//        boolean result = false;
//        if (a.substring(indexA+1).equals(b.substring(indexB+1))){
//            for (int i = 0;i<indexA&&i<indexB;i++){
//                if (a.charAt(i)!=b.charAt(i)){
//                    result = a.charAt(i)>b.charAt(i) ? true : false;
//                    break;
//                }
//            }
//        }else {
//            for (int i = indexA+1,j=indexB+1;i<a.length()&&j<b.length();i++,j++){
//                if (a.charAt(i)!=b.charAt(j)){
//                    result = a.charAt(i)>b.charAt(j) ? true : false;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
}
