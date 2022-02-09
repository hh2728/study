package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1210_Ladder1 {

	static int map[][] = new int[100][100];
	static boolean visit[][] = new boolean[100][100];
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 1; i <= 10; i++) {

			int x = 0;
			int y = 0;

			int t = Integer.parseInt(br.readLine());
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					visit[r][c] = false;
					if (map[r][c] == 2) {
						y = r;
						x = c;
					}
				}
			}
			find(y, x);
			System.out.printf("#%d %d\n", i, answer);

		}

	}

	public static void find(int r, int c) {

		while (true) {

			if (c - 1 >= 0 && map[r][c - 1] == 1 && visit[r][c - 1] == false) {		//왼쪽보고 안갓으면 가자
				visit[r][c - 1] = true;
				c -= 1;

			} else if (c + 1 < 100 && map[r][c + 1] == 1 && visit[r][c + 1] == false) {		//오른쪽 보고 안갓으면 가자
				visit[r][c + 1] = true;
				c += 1;


			} else {						//다 아니면 올라가자
				visit[r - 1][c] = true;
				r = r - 1;


			}
			if (r == 0)		//맨위면 끝내기
				break;
			answer = c;
		}
	}

}