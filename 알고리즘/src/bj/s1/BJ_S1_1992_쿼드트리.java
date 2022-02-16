package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1992_쿼드트리 {

	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			str = br.readLine();

			for (int c = 0; c < N; c++) {

				map[r][c] = str.charAt(c) - '0';
			}
		}

		find(N, 0, 0);

	}

	static void find(int n, int r, int c) {

		if (isOk(n, r, c)) {
			if (map[r][c] == 0)

				System.out.print("0");
			else if (map[r][c] == 1)
				System.out.print("1");
			return;
		}

		int nn = n / 2;

		System.out.print("(");
		find(nn, r, c);
		find(nn, r, c + nn);
		find(nn, r + nn, c);
		find(nn, r + nn, c + nn);
		System.out.print(")");

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
