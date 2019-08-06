package com.xjy.cat.test;

import java.util.ArrayList;
import java.util.List;

public class test {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list= new ArrayList<>();
            List<Integer> list0 = new ArrayList<>();
            list0.add(1);
            for(int i =0;i<numRows;i++){
                if(i==0){
                    list.add(list0);
                }if(i>0){

                }
            }
            return list;
        }
    public static void main(String[] args) {

    }
}
