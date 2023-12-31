package com.ssafy.class0810;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitTest {

	static int N, R, input[], numbers[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		long start = System.nanoTime();
		permutation(0, 0);
		long end = System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0);	
	}
	
	private static void permutation(int cnt, int flag) {
		
		if(cnt == R) {
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			//중복 체크
			if((flag & 1<<i) != 0) continue;
			//수 선택
			numbers[cnt] = input[i];
			//다음자리수 뽑기
			permutation(cnt+1, flag | 1<<i);
		}
	}

}
