package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_B2_2309_일곱난쟁이 {

	static int[] arr;
	static int[] choose;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9];
		choose = new int[7];
		visited = new boolean[9];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		ans = 0;

		combination(7, choose, visited);

	}

	static void combination(int toChoose, int[] choosed, boolean[] visited) {

		if (toChoose == 0) {
			int sum = 0;

			for (int i = 0; i < choosed.length; i++) {

				sum += choosed[i];

			}

			if (sum == 100) {
				Arrays.sort(choosed);

				for (int i = 0; i < choosed.length; i++) {

					System.out.println(choosed[i]);

				}
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - toChoose] = arr[i];

				combination(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

}
