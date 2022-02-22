package bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_10163_색종이 {

	static int N, R, C, count;
	static int map[][] = new int[1001][1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		count = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			for (int r = R; r < R + 10; r++) {
				for (int c = C; c < C + 10; c++) {
					if (c <= 100 && r <= 100 && map[r][c] == 0) {
						map[r][c] = 1;
						count++;

					}
				}
			}

		}
		System.out.println(count);
	}

}
