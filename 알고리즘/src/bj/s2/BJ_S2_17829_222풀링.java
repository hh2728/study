package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_17829_222풀링 {

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		make(N);
		System.out.println(map[0][0]);

	}

	public static void make(int n) {
		if (n == 1)
			return;

		for (int r = 0; r < n; r += 2) {
			for (int c = 0; c < n; c += 2) {
				int[] temp = { map[r][c], map[r][c + 1], map[r + 1][c], map[r + 1][c + 1] };
				
				Arrays.sort(temp);
				
				map[r / 2][c / 2] = temp[2];
				// (2,2)->(1,1)   (2,0) -> (1,0)   (6,4) -> (3,2)  압축됨 
			}
		}

		make(n / 2);
	}

}
