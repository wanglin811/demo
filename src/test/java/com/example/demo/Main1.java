package com.example.demo;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 m = new Main1();
//		int[] A = {0,0,0,0,0,0,0,0,0,0};
//		int[] A = {3, 2, 3, 2, 1, 0,1,2,5,6,7,8,10};
//		int[] A = {3, 2, 3, 2, 1, 0,1,2,5,6,7,8,9,10};
//		int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
//		int[] A = {1,2,3,4,5,7,8,9,10,11};
		int[] A = {13, 2, 3, 32, 1, 0,1,2,5,6,7,48,9,10};
		System.out.println(m.solution(A));
	}
	
	public int addValue(int a){
		int re=0;
		if(a<=1){
			re=0;
		}else if(a==2){
			re=1;
		}else if(a==3){
			re=3;
		}else{
			for(int i=1;i<a;i++){
				re+=i;
			}
		}
		return re;
	}
public int solution(int[] A) {
		
		int length = A.length;
		int resultNum=0;//the result
		int num=0;
		int value=0;
		
		for(int i=0;i<A.length-1;i++){
			int valueTmp=A[i+1]-A[i];
			if(i==0){
				value=valueTmp;
				num++;
			}else if(value==valueTmp){
				num++;
				if(i==A.length-2){
					resultNum+=addValue(num);
				}
			}else{
				resultNum+=addValue(num);
				i=i-1;
				value=valueTmp;
				num=0;
			}
			
			
			
		}
		if(resultNum>=1000000000){
			resultNum=-1;
		}
		
        return resultNum;
    }
}
