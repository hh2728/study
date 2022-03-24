package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_1325_효율적인해킹_시간초과 {

	static int N, M, max, cnt, ans;
	static boolean[] visit;
	static List<Integer>[] adj;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		count = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[b].add(a);
		}
		max = 0;

		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];

			dfs(i);
			count[i] = cnt;
			if (cnt > max)
				max = cnt;
			cnt = 0;

		}
		for (int i = 1; i <= N; i++) {
			if (max == count[i])
				System.out.print(i + " ");
		}

	}

	public static void dfs(int start) {
		if (adj[start] == null)
			return;

		for (int j = 0; j < adj[start].size(); j++) {
			if (!visit[adj[start].get(j)]) {
				visit[adj[start].get(j)] = true;
				dfs(adj[start].get(j));
				cnt++;
			}
		}

	}
}