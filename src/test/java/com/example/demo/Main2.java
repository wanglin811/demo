package com.example.demo;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 m = new Main2();

		int[] A = { 13, 2, 38, 32, 1, 0, 1, 2, 5, 6, 7, 48, 9, 10};
		int K = 3;
		int L = 2;
		System.out.println(m.solution(A, K, L));
	}

	int resultK = 0;
	int resultL = 0;

	public int solution(int[] A, int K, int L) {
		int result = 0;
		int length = A.length;
		int[] B = A.clone();

		if (K + L > length) {
			result = -1;
		} else {
			int tempK = 0;
			int tempL = 0;
			int numK = 0;
			int numL = 0;
			int index = 0;
			for (int i = 0; i < length - K+1; i++) {
				numK=0;
				for (int j = i; j < i+K; j++) {
					numK += A[j];
				}
				if (numK > tempK) {
					tempK = numK;
					index = i;
				}
			}
			B = A.clone();
			for (int j = index; j < index+K; j++) {
				B[j] = 0;
			}
			for (int i = 0; i < length - L+1; i++) {
				numL=0;
				for (int j = i; j < i+L; j++) {
					numL += B[j];
				}
				if (numL > tempL) {
					tempL = numL;
					
				}
			}
			if (resultK < (tempK + tempL)) {
				resultK = tempK + tempL;
				tempK = 0;
				tempL = 0;
			}
			K=K+L;
			L=K-L;
			K=K-L;
			for (int i = 0; i < length - K+1; i++) {
				numK=0;
				for (int j = i; j < i+K; j++) {
					numK += A[j];
				}
				if (numK > tempK) {
					tempK = numK;
					index = i;
				}
			}
			B = A.clone();
			for (int j = index; j < index+K; j++) {
				B[j] = 0;
			}
			for (int i = 0; i < length - L+1; i++) {
				numL=0;
				for (int j = i; j < i+L; j++) {
					numL += B[j];
				}
				if (numL > tempL) {
					tempL = numL;
					
				}
			}
			if (resultK < (tempK + tempL)) {
				resultK = tempK + tempL;
				tempK = 0;
				tempL = 0;
			}

			if (resultK > resultL) {
				result = resultK;
			} else {
				result = resultL;
			}

		}
		return result;
	}
}
