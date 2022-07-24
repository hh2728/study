package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G4_17298_오큰수 {

	static int N,arr[];
	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		// 배열에 입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {

			/*
			arr - 9 5 4 8
			stack - 
			
			i-0일때
			stack 0 push
			
			i-1
			arr 0 <arr 1  성립 x
			stack 0 1
			
			i-2
			arr 1< arr 2 성립 x
			stack 0 1 2
			
			
			i-3
			arr 2 < arr 3 성립 o
			arr 2 -> arr 3 
			arr - 9 5 8 8
			
			arr 1 < arr 3 성립 o
			arr 1 -> arr 3
			arr - 9 8 8 8
			
			arr 0 < arr 3 성립 x
			stack 0 3 남음
			*/
			
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}

			stack.push(i);
		}
		
		// 남은거는 -1로 만들기
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);

	}

}
