package com.example.leetcodeDaily;

import java.util.List;
import java.util.Stack;

//知道思想是用栈 但是没法调试 寄
public class Deserialize_385 {
      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public class NestedInteger {
          // Constructor initializes an empty nested list.
          public NestedInteger(){}

          // Constructor initializes a single integer.
          public NestedInteger(int value){}

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger(){return false;}

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger(){return 0;}

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value){};

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni){};

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList(){return null;}
      }

    public NestedInteger deserialize(String s) {
        NestedInteger result = null;
        Stack<Character> stack = new Stack<>();
        int numOfLeftBracket = 0;
        for (int i=0;i<s.length();i++){
            char sCharAtI = s.charAt(i);
            if (sCharAtI!=']'&&sCharAtI!=','){
                stack.push(sCharAtI);
                if (sCharAtI=='['){
                    numOfLeftBracket++;
                }
            }else{
                if (sCharAtI==']'){
                    StringBuffer stringBuffer;
                    while(true){
                        if (stack.isEmpty()){
                            break;
                        }
                        char c = stack.pop();
                        stringBuffer = new StringBuffer();
                        if (c!='['){
                            stringBuffer=(new StringBuffer(c)).append(stringBuffer);
                        }else{
                            NestedInteger tempNestedInteger = new NestedInteger(Integer.valueOf(stringBuffer.toString()));
                            if (result==null){
                                result = tempNestedInteger;
                            }else{
                                result.add(tempNestedInteger);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
