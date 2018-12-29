package com.example.demo;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 m = new Main2();

		int[] A = {13, 2, 38, 32, 1, 0,1,2,5,6,7,48,9,10};
		int K=3;
		int L=2;
		System.out.println(m.solution(A,K,L));
	}
	
	public int solution(int[] A, int K, int L) {
        int result=0;
        int length=A.length;
        int[] B=A.clone();
        int resultK=0;
        int resultL=0;
        if(K+L>length){
        	result=-1;
        }else{
        	int tempK=0;
        	int tempL=0;
        	int numK=0;
    		int numL=0;
    		int index=0;
        	for(int i=0;i<length-2;i++){
        		numK=A[i]+A[i+1]+A[i+2];
        		if(numK>tempK){
        			tempK=numK;
        			index=i;
        		}
        	}
        	B=A.clone();
        	B[index]=0;
        	B[index+1]=0;
        	B[index+2]=0;
    		for(int j=0;j<length-1;j++){
				numL=B[j]+B[j+1];
				if(numL>tempL){
					tempL=numL;
				}
			}
    		if(resultK<(tempK+tempL)){
        		resultK=tempK+tempL;
        		tempK=0;
        		tempL=0;
        	}
        	
        	result = resultK;
        }
        return result;
    }

}
