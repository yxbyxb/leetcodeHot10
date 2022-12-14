package com.example.study.extend;

import com.example.study.extend.Parent;

public class Children extends Parent {
    public void testChildren() {
        System.out.println("children");
        this.testParent();
        Parent parent = new Parent();
        parent.testParent();
    }
}
