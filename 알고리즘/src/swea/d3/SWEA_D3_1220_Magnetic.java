package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1220_Magnetic {

	static int[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;

			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 100; r++) {
					if (map[r][c] == 1) {
						for (int i = 1; i < 100 - r; i++) {
							if (map[r + i][c] == 1) {
								r = r + i - 1;
								break;
							} else if (map[r + i][c] == 2) {
								cnt++;
								break;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n",t,cnt);

		}

	}

}
