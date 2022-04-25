package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        flashBack(result,n,new StringBuffer(),0,0);
        return result;
    }

    private void flashBack(List<String> result,int n,StringBuffer temp,int numOfLeft,int numOfRight){
        if (numOfRight==n){
            result.add(temp.toString());
        }else{
            if (numOfLeft<n){
                temp.append("(");
                flashBack(result,n,temp,numOfLeft+1,numOfRight);
                temp.deleteCharAt(temp.length()-1);
            }
            if (numOfRight<numOfLeft){
                temp.append(")");
                flashBack(result,n,temp,numOfLeft,numOfRight+1);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
