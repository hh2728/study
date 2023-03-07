package bj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G3_14890_경사로 {
	
	static int N,L;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		int answer=0;
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			if(checkPath(i,0,true)) {
				answer++;
			}
			
			if(checkPath(0,i,false)) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	
	static boolean checkPath(int x, int y, boolean flag) {
		
		int[] height = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			if(flag) {
				height[i] = map[x][i];
			}else {
				height[i] = map[i][y];
			}
		}
		
		for(int i=0; i<N-1; i++) {
			
			if(height[i] == height[i+1]) {
				continue;
			}
			else if(height[i] - height[i+1] == 1) {
				
				for(int j= i+1; j<=i+L; j++) {
					if(j>=N || height[i+1] != height[j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			}
			else if(height[i] - height[i+1] == -1) {
				
				for(int j=i; j>i-L; j--) {
					if(j<0 || height[i] != height[j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			}
			else {
				return false;
			}
		}
		
		
		return true;
	}

}
