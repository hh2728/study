package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_15649_N과M1 {

	static int N,M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N+1];
		
		dfs(N,M,0);
		
	}
	
	static void dfs(int n, int m, int depth) {
		
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			//if(!visited[i]) {

			//	visited[i]=true;
				arr[depth] = i;
				dfs(n,m,depth+1);
				//visited[i] = false;
			//}
			
			
		}
		
	}

}
