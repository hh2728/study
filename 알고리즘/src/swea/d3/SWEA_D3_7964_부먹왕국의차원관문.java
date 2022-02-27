package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_7964_부먹왕국의차원관문 {

	static int T, cnt, ans;
	static int C, R;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());

			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[C];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < C; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < C; i++) {
				cnt++;
				if (map[i] == 1) {
					cnt = 0;
				}
				if (cnt == R) {
					ans++;
					cnt = 0;
				}
			}

			System.out.printf("#%d %d\n", t, ans);

		}
	}

}
