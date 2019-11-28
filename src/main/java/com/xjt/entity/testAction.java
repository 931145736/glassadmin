package com.xjt.entity;

import java.util.ArrayList;
import java.util.List;

public class testAction {

    public static void main(String[] args){
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List list2 = new ArrayList();
        list2.add("a");
        list2.add("b");
        list2.add("c");


        for(int i=0;i<list1.size();i++){
            for(int k = 0;k<list2.size();k++){
                System.out.println(list1.get(i)+":"+list2.get(k));
            }
        }
    }
}
