package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_1780_종이의개수 {

	static int N, mc, zc, pc;
	static int[][] map;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < N; r++) {
				map[i][r] = Integer.parseInt(st.nextToken());
			}
		}
		find(0, 0, N);
		System.out.println(mc);
		System.out.println(zc);
		System.out.println(pc);


	}

	public static void find(int row, int col, int size) {
		
		if (colorCheck(row, col, size)) {
			if (map[row][col] == -1) {
				mc++;
			} else if (map[row][col] == 0) {
				zc++;
			} else {
				pc++;
			}

			return;
		}

		int newSize = size / 3;

		find(row, col, newSize); // 왼쪽 위
		find(row, col + newSize, newSize); // 중앙 위
		find(row, col + 2 * newSize, newSize); // 오른쪽 위

		find(row + newSize, col, newSize); // 왼쪽 중간
		find(row + newSize, col + newSize, newSize); // 중앙 중간
		find(row + newSize, col + 2 * newSize, newSize); // 오른쪽 중간

		find(row + 2 * newSize, col, newSize); // 왼쪽 아래
		find(row + 2 * newSize, col + newSize, newSize); // 중앙 아래
		find(row + 2 * newSize, col + 2 * newSize, newSize); // 오른쪽 아래

	}


	public static boolean colorCheck(int row, int col, int size) {
		int color = map[row][col];


		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
