package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_10157_자리배정 {

	static int R, C, K, cnt;
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		map = new int[R][C];

		int num = 1;
		int row = R, col = 0;
		int i;
		int Result[] = new int[2];
		boolean isTrue = true;
		while (isTrue) {

			if (K > R * C)
				break;

			if (row - 1 >= 0 && row + 1 < R && col - 1 >= 0 && col + 1 > C && map[row - 1][col] != 0
					&& map[row + 1][col] != 0 && map[row][col - 1] != 0 && map[row][col + 1] != 0)
				break;

			// 상
			for (i = row - 1; i >= 0; i--) {
				if (map[i][col] != 0)
					break;
				map[i][col] = num++;
				if (map[i][col] == K) {
					Result[0] = i;
					Result[1] = col;
					isTrue = false;
				}
			}
			row = i + 1;
			// 우
			for (i = col + 1; i < C; i++) {
				if (map[row][i] != 0)
					break;
				map[row][i] = num++;
				if (map[row][i] == K) {
					Result[0] = row;
					Result[1] = i;
					isTrue = false;
				}
			}
			col = i - 1;
			// 하
			for (i = row + 1; i < R; i++) {
				if (map[i][col] != 0)
					break;
				map[i][col] = num++;
				if (map[i][col] == K) {
					Result[0] = i;
					Result[1] = col;
					isTrue = false;
				}
			}
			row = i - 1;
			// 좌
			for (i = col - 1; i >= 0; i--) {
				if (map[row][i] != 0)
					break;
				map[row][i] = num++;
				if (map[row][i] == K) {
					Result[0] = row;
					Result[1] = i;
					isTrue = false;
				}
			}
			col = i + 1;
		}

		if (K > (R * C))
			System.out.println(0);
		else
			System.out.println((Result[1] + 1) + " " + (R - Result[0]));

	}

}
