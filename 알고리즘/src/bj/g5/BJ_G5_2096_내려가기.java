package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_2096_내려가기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dmax = new int[N][3];
		int[][] dmin = new int[N][3];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<3; i++) { 
				int temp = Integer.parseInt(st.nextToken());
				//arr[n][i] = temp;
				
				if(n==0) {
					dmax[n][i] = temp;
					dmin[n][i] = temp;					
				}else {
					
					if(i==0) {
						dmax[n][i] = Math.max( dmax[n-1][i], dmax[n-1][i+1]) + temp;
						
						dmin[n][i] = Math.min( dmin[n-1][i], dmin[n-1][i+1]) + temp;
					}else if(i == 2) {
						dmax[n][i] = Math.max( dmax[n-1][i-1], dmax[n-1][i]) + temp;
						
						dmin[n][i] = Math.min( dmin[n-1][i-1], dmin[n-1][i]) + temp;
					}else {
						dmax[n][i] = Math.max( Math.max( dmax[n-1][i-1], dmax[n-1][i]), dmax[n-1][i+1]) + temp;
						
						dmin[n][i] = Math.min( Math.min( dmin[n-1][i-1], dmin[n-1][i]), dmin[n-1][i+1]) + temp;
					}
					
				}
				
			}
		}

		for(int i=0; i<3; i++) {
			max = Math.max(max, dmax[N-1][i]);
			min = Math.min(min, dmin[N-1][i]);
		}
		sb.append(max+" "+min);
		System.out.println(sb);
		
		
	}

}
