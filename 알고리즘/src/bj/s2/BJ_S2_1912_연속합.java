package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_1912_연속합 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int answer = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		
		for(int i=1; i<=n; i++) {
			if(arr[i] > dp[i-1] + arr[i]) {
				dp[i]= arr[i];
			}else {
				dp[i] = dp[i-1] + arr[i];
			}
			
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
	
}
