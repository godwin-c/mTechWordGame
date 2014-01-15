/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtechcomm.wordgame;

import java.util.ArrayList;

/**
 *
 * @author LANREWAJU
 */
public class sortingFile {
   ArrayList  al = new ArrayList();
   
    public void sort(int x){
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        
       
        for(int i = 0; i<al.size(); i++){
           // for(int j = 0;j<al.size(); j++){
//                if(Integer.parseInt(al.get(i).toString())> x){
//                    al.add(i, x);
//                    al.add(i+1, Integer.parseInt(al.get(i).toString()));
//                }else{
//                    System.out.println("No match found");
//                //}
//            }
        }
        System.out.println("the element " + al);
    }
 public static void main(String [] a){
    sortingFile sf = new sortingFile();
    sf.sort(0);
 }   
}
