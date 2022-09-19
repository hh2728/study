package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S1_2583_영역구하기 {

	static int M, N, K;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] map;
	static int count = 0;
	static ArrayList<Integer> List;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int a = y1; a < y2; a++) {
				for (int b = x1; b < x2; b++) {
					map[a][b] = 1;
				}
			}
		}

		List = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					count = 0;
					dfs(i, j);
					List.add(count);
				}
			}
		}
		System.out.println(List.size());

		Collections.sort(List);

		for (Integer c : List)
			System.out.print(c + " ");
	}

	public static void dfs(int r, int c) {
		map[r][c] = 1;
		count++;

		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];

			if (nr >= 0 && nc >= 0 && nr < M && nc < N) {
				if (map[nr][nc] == 0)
					dfs(nr, nc);
			}
		}

	}

}
