package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S4_1065_한수 {
	
	static int N,count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		count = 0;
		if(N < 100) {
			count = N;
		}else {
			count = 99;
			for(int i=100; i<=N; i++) {
				int a = i / 100;
				int b = (i/10) % 10;
				int c = i % 10;
				
				if((a-b) == (b-c)) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
