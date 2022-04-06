package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17471_게리맨더링 {

	static int[][] adj;
	static int N, min;
	static int[] people;
	static boolean[] checked, visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		people = new int[N + 1];
		adj = new int[N + 1][N + 1];
		checked = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				int z = Integer.parseInt(st.nextToken());
				adj[i][z] = 1;
				adj[z][i] = 1;
			}
		}

		min = Integer.MAX_VALUE;
		makeArea(N, checked);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void makeArea(int toCheck, boolean[] checked) {
		if (toCheck == 0) {
			visited = new boolean[N + 1];
			int count = 0;
			int asum = 0;
			int bsum = 0;

			for (int i = 1; i <= N; i++) {
				if (count >= 3)
					return;

				if (checked[i] && !visited[i]) {
					count++;
					asum += bfs(i);

				} else if (!checked[i] && !visited[i]) {
					count++;
					bsum += nbfs(i);

				}
			}
			
			if (count == 2) {

				min = Math.min(min, Math.abs(asum - bsum));
			}
			return;
		}

		// inductive part
		checked[checked.length - toCheck] = true;
		makeArea(toCheck - 1, checked);
		checked[checked.length - toCheck] = false;
		makeArea(toCheck - 1, checked);
	}

	static int bfs(int n) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(n);
		visited[n] = true;
		int sum = people[n];

		while (!qu.isEmpty()) {
			int temp = qu.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[temp][i] == 1 && !visited[i] && checked[i]) {

					qu.add(i);
					visited[i] = true;
					sum += people[i];
				}
			}
		}

		return sum;
	}

	static int nbfs(int n) {
		Queue<Integer> qu = new LinkedList<>();

		qu.add(n);
		visited[n] = true;
		int sum = people[n];

		while (!qu.isEmpty()) {
			int temp = qu.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[temp][i] == 1 && !visited[i] && !checked[i]) {

					qu.add(i);
					visited[i] = true;
					sum += people[i];
				}
			}
		}

		return sum;
	}

	static boolean isOk(int r, int c) {
		return r >= 0 && c >= 0 && r <= N && c <= N;
	}

}
