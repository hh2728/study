package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_2606_바이러스 {

	static int N, S;
	static boolean num[];
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		S = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		num = new boolean[N + 1];

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = map[y][x] = 1;
		}

		bfs();
		int cnt = 0;
		for (int i = 2; i <= N; i++) {

			if (num[i] == true) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	static void bfs() {
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(1);
		num[1] = true;
		
		while (!qu.isEmpty()) {
			int virus = qu.poll();
			for (int i = 1; i <= N; i++) {
				if (i != virus && map[virus][i] == 1 && num[i] != true) {
					qu.add(i);
					num[i] = true;

				}
			}
		}
	}

}
