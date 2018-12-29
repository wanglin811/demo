package com.example.demo;

public class Main4 {
	
	public static void main(String[] args){
		Main4 m = new Main4();
		int[] A = new int[100000];
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
		for(int i=0;i<length;i++){
				for(int k=i;k<length;k++)
				{
					addValue+=A[k];
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
}
