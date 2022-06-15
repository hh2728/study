package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_G4_9663_NQueen {

	static int N, count = 0;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		nQueen(0);
		System.out.println(count);

	}

	static void nQueen(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			if (isOk(depth)) {
				nQueen(depth + 1);
			}
		}
	}

	static boolean isOk(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}

		return true;
	}

}
