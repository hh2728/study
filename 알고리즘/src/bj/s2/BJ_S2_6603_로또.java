package bj.s2;

import java.util.Scanner;

public class BJ_S2_6603_로또 {

	static int N;
	static int[] input, numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt();
			
			if(N==0)break;
			
			input = new int[N];
			numbers = new int[6];
			
			for(int i =0; i<N; i++) {
				input[i] = sc.nextInt();
			}
			
			combination(0,0);
				
			System.out.println();
		}

	}
	
	public static void combination(int cnt, int start) {
		
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				System.out.printf("%d ",numbers[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i= start; i<N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1); // 다음자리는 현재 뽑은 i의 다음수 부터 시작
			
		}
	}

}
