package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_18405_경쟁적전염 {

	static int[][] map;
	static int N, K, S, X, Y;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		solution();

		System.out.println(map[X][Y]);
	}

	public static void solution() {

		outer: for (int s = 0; s < S; s++) {
			for (int i = 1; i <= K; i++) {
				visited = new boolean[N + 1][N + 1];
				
				for (int r = 1; r <= N; r++) {
					for (int c = 1; c <= N; c++) {
						if (map[r][c] == i && !visited[r][c]) {
							bfs(r, c, i);
						}
						if(map[X][Y] != 0) {
							break outer;
						}
					}
				}

			}

		}

	}

	public static void bfs(int r, int c, int virus) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];

			if (isOk(nr, nc)) {
				if (!visited[nr][nc] && map[nr][nc] == 0) {
					map[nr][nc] = virus;
					visited[nr][nc] = true;
				}
			}
		}
	}

	public static boolean isOk(int r, int c) {
		return r >= 1 && c >= 1 && r <= N && c <= N;
	}

}
