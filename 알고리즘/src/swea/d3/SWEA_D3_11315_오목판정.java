package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_11315_오목판정 {

	static int T, N;
	static boolean isOk;
	static char[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int r = 0; r < N; r++) {
				map[r] = br.readLine().toCharArray();
			}

			isOk = false;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'o') {
						for (int d = 0; d < 8; d++) {
							for (int i = 1; i < 5; i++) {
								int nr = r + deltas[d][0] * i;
								int nc = c + deltas[d][1] * i;

								if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
									break;
								} else if (map[nr][nc] != 'o') {
									break;
								}

								if (i == 4)
									isOk = true;
							}
						}
					}
				}
			}
			if (isOk)
				System.out.println("#"+t+" YES");
			else
				System.out.println("#"+t+" NO");
		}

	}

}
