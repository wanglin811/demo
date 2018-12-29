package com.example.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args){
		Main m = new Main();
		int[] A = new int[100000];
		int[] B = {2,-2,3,0,4,-7};
		for(int i=0;i<100000;i++){
			A[i]=0;
		}
		long t1=System.currentTimeMillis();
		System.out.println(m.solution(A));
		long t2=System.currentTimeMillis()-t1;
		System.out.println(t2);
	}
	public int solution(int[] A) {
		
		int length = A.length;
		int num=0;//the result
		int addValue=0;
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		for(int i=0;i<list.size();i++){
			for(int k=i;k<list.size();k++)
			{
				addValue+=list.get(k);
				if(addValue==0){
					num++;
				}
			}
			addValue=0;
	}
	if(num>=1000000000){
		num=-1;
	}
	
    return num;
    }
	
//public int solution1(Integer[] A) {
//	List<Integer> B =  Arrays.asList(A);
//		int length = B.size();
//		int num=0;//the result
//		int addValue=0;
//		Iterator it = B.iterator();
//		while(it.hasNext())
//		    {
//				addValue+it.
//		    } 
//		if(num>=1000000000){
//			num=-1;
//		}
//		
//        return num;
//    }
}
