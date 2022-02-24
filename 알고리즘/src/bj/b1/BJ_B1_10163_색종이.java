package bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_10163_색종이 {

	static int N, r1, c1, r2, c2, count;
	static int map[][] = new int[1001][1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		count = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			for (int r = r1; r < r1 + r2; r++) {
				for (int c = c1; c < c1 + c2; c++) {

					map[r][c] = i;

				}
			}
		}
		for (int i = 1; i <= N; i++) {
			count = 0;
			for (int r = 0; r < 1001; r++) {
				for (int c = 0; c < 1001; c++) {
					if (map[r][c] == i) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

}
