package bj.g5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_1405_미친로봇 {
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visited;
	static int N;
	static double[] percentages;
	static double ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		percentages = new double[4]; // 동서남북으로 가는 각각의 확률
		for (int i = 0; i < 4; i++) {
			percentages[i] = Double.parseDouble(st.nextToken()) * 0.01;
		}

		visited = new boolean[30][30];
		visited[15][15] = true;
		DFS(15, 15, visited, 0, 1);

		System.out.println(ans);

	}

	// 동서남북으로 모든 경우에 대해 탐색.
	public static void DFS(int r, int c, boolean[][] visited, int cnt, double result) {
		if (cnt == N) { // 로봇의 최대 이동 횟수에 도달.
			ans += result; // 지금까지 이동한 방향들의 확률을 더함.
			return;
		}

	
		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			// 맵 밖이면 아웃
			if (!isOk(nr,nc)) {
				continue;
			}

			// 특정 지점을 방문하지 않았을 경우.
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				DFS(nr, nc, visited, cnt + 1, result * percentages[d]);
				visited[nr][nc] = false;
			}
		}
	}
	
	static boolean isOk(int r,int c) {
		return r>=0 && c>=0 && r<30 && c<30;
	}
}
