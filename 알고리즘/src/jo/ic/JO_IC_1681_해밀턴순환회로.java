package jo.ic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_IC_1681_해밀턴순환회로 {

	static int N, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		visited = new boolean[N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		ans = Integer.MAX_VALUE;
		dfs(1, 0, 0);

		System.out.println(ans);

	}

	public static void dfs(int cnt, int num, int sum) {
		if (sum > ans)
			return;
		if (cnt == N) {
			if (map[num][0] != 0 && ans > sum + map[num][0]) {
				ans = sum + map[num][0];
			}
			return;
		}
		for (int i = 1; i < N; i++) {
			if (map[num][i] == 0 || visited[i])
				continue;
			visited[i] = true;
			dfs(cnt + 1, i, sum + map[num][i]);
			visited[i] = false;
		}
	}

}
