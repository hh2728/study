package bj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G2_3109_빵집 {

	static int R, C;
	static char[][] map;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		for (int r = 0; r < R; r++) {
			if (find(r, 0))
				ans++;
		}

		System.out.println(ans);

	}

	public static boolean find(int r, int c) {
		map[r][c] = '@';

		if (c == C - 1)
			return true;

		if (r > 0 && map[r - 1][c + 1] == '.') {
			if (find(r - 1, c + 1))
				return true;
		}
		if (map[r][c + 1] == '.') {
			if (find(r, c + 1))
				return true;
		}
		if (r + 1 < R && map[r + 1][c + 1] == '.') {
			if (find(r + 1, c + 1))
				return true;
		}
		return false;
	}

}
