package bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_2669_직사각형네개의합집합의면적구하기 {

	static int r1, c1, r2, c2;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[101][101];

		for (int t = 0; t < 4; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					map[r][c] = 1;
				}
			}
		}

		int cnt = 0;
		for (int r = 0; r < 101; r++) {
			for (int c = 0; c < 101; c++) {
				if (map[r][c] == 1)
					cnt++;
			}
		}

		System.out.println(cnt);
	}

}
