package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1873_상호의배틀필드 {
	
	static double[][] work;
	static boolean[] visit;	
	static int N;
	static double max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			work = new double[N][N];
			visit = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					work[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}
			}
			
			max = 0.0;
			for(int i = 0; i < N; i++) {
				dfs(i, 0, 1);
			}
			System.out.printf("#%d %.6f\n", t, max*100);
		}
	}
	

	public static void dfs(int x, int depth, double result) {
		result *= work[x][depth];
		visit[x] = true;
		
		if(depth == N - 1) {
			if(max < result)
				max = result;
			visit[x] = false;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == false && result * work[i][depth+1] > max) dfs(i, depth+1, result);
		}
		visit[x] = false;
	}

}
