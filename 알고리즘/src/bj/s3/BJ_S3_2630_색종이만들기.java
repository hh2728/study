package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_2630_색종이만들기 {

	static int N, white, blue;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < N; c++) {

				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		white = 0;
		blue = 0;
		find(N, 0, 0);

		System.out.println(white);
		System.out.println(blue);

	}

	static void find(int n, int r, int c) {

		if (isOk(n, r, c)) {
			if (map[r][c] == 0)
				white++;
			else
				blue++;
			return;
		}

		int nn = n / 2;

		find(nn, r, c);
		find(nn, r, c + nn);
		find(nn, r + nn, c);
		find(nn, r + nn, c + nn);

	}

	static boolean isOk(int n, int r, int c) {

		int start = map[r][c];

		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (map[i][j] != start) {

					return false;
				}
			}
		}

		return true;
	}

}
