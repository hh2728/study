package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj_S1_1325_효율적인해킹 {

	static Com[] comps;
	static int N;
	static int M;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		comps = new Com[N + 1];
		for (int i = 1; i <= N; i++) {
			comps[i] = new Com(i);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			comps[b].adj.add(comps[a]);
		}

		answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			dfs(i, i);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, answer[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (max == answer[i]) {
				System.out.print(i + " ");
			}
		}

	}

	public static void dfs(int start, int now) {

		for (Com c : comps[now].adj) {
			if (!visited[c.idx]) {
				visited[c.idx] = true;
				dfs(start, c.idx);
				answer[start]++;
			}
		}

	}

	static class Com {
		int idx;
		ArrayList<Com> adj;

		public Com(int idx) {
			this.idx = idx;
			this.adj = new ArrayList<>();
		}
	}

}
