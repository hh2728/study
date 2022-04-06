package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_14888_연산자끼워넣기 {
	
	static int N,max,min;
	static int[] arr;
	static int[] op;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		
		for(int n=0; n<4; n++) {
			op[n] = Integer.parseInt(st.nextToken());
		}
		
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		
		dfs(arr[0], 1);
		
		System.out.println(max);
		System.out.println(min);

	}
	public static void dfs(int num, int idx) {
		
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
	
			if (op[i] > 0) {
 

				op[i]--;
 
				switch (i) {
 
				case 0:	dfs(num + arr[idx], idx + 1);	break;
				case 1:	dfs(num - arr[idx], idx + 1);	break;
				case 2:	dfs(num * arr[idx], idx + 1);	break;
				case 3:	dfs(num / arr[idx], idx + 1);	break;
 
				}

				op[i]++;
			}
		}
	}
	

}
