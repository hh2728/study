package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G4_17140_이차원배열과연산 {

	static int[][] map;
	static int[] cnt;
	static ArrayList<Num> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()) - 1;
		int C = Integer.parseInt(st.nextToken()) - 1;
		int val = Integer.parseInt(st.nextToken());

		map = new int[3][3];

		for (int r = 0; r < 3; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int time = -1;

		while (true) {
			time++;

			if (time > 100) {
				time = -1;
				break;
			}
			if (R < map.length && C < map[0].length) {
				if (map[R][C] == val) {
					break;
				}
			}

			int row = map.length;
			int col = map[0].length;
			int[][] temp = new int[101][101];

			if (row >= col) { // R

				int max = Integer.MIN_VALUE;

				for (int i = 0; i < row; i++) {
					cnt = new int[101];

					// 0이면 패스, 아니면 카운ㅌ트올리기
					for (int j = 0; j < col; j++) {
						if (map[i][j] == 0) {
							continue;
						}
						int n = map[i][j];
						cnt[n]++;
					}

					// 숫자들 리스트에 저장
					list = new ArrayList<>();

					for (int j = 1; j < cnt.length; j++) {
						if (cnt[j] != 0) {
							list.add(new Num(j, cnt[j]));
						}
					}

					// 갯수, 숫자로 정렬
					Collections.sort(list);

					// 배열에 저장
					int z = 0;
					for (int j = 0; j < list.size(); j++) {
						temp[i][z] = list.get(j).n;
						temp[i][z + 1] = list.get(j).len;
						z += 2;
					}

					// 크기가 max보다 크면 교체 -> 2곱한이유는 (숫자,갯수) 이기때문에
					if (max < list.size() * 2) {
						max = list.size() * 2;
					}
				}
				// 100넘어가면 저장할 필요 없음
				if (max > 100)
					max = 100;

				map = new int[row][max];

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						map[i][j] = temp[i][j];
					}
				}
			}

			else { // C연산
				int max = Integer.MIN_VALUE;

				for (int i = 0; i < col; i++) {
					cnt = new int[101];
					for (int j = 0; j < row; j++) {
						if (map[j][i] == 0) {
							continue;
						}
						int n = map[j][i];
						cnt[n]++;
					}
					list = new ArrayList<>();

					for (int j = 1; j < cnt.length; j++) {
						if (cnt[j] != 0) {
							list.add(new Num(j, cnt[j]));
						}
					}

					Collections.sort(list);

					int z = 0;
					for (int j = 0; j < list.size(); j++) {
						temp[z][i] = list.get(j).n;
						temp[z + 1][i] = list.get(j).len;
						z += 2;
					}

					if (max < list.size() * 2)
						max = list.size() * 2;
				}
				if (max > 100)
					max = 100;

				map = new int[max][col];

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						map[i][j] = temp[i][j];
					}
				}
			}
		}

		System.out.println(time);

	}

	static class Num implements Comparable<Num> {
		int n, len;

		public Num(int n, int len) {
			super();
			this.n = n;
			this.len = len;
		}

		@Override
		public int compareTo(Num o) {
			if (this.len == o.len) {
				return this.n - o.n;
			}
			return this.len - o.len;
		}

	}

}
