package bj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G3_11066_파일합치기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());			
			int arr[] = new int[num];
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < num; j++) {
				
				arr[j] = Integer.parseInt(st.nextToken());

			}
			System.out.println(solution(arr));
		}

	}

	public static int MIN(int a, int b) {
		return a <= b ? a : b;
	}

	public static int sum(int[] a, int s, int e) {
		if (s == 0)
			return a[e];
		else
			return a[e] - a[s - 1];
	}

	private static int solution(int[] a) {
		int size = a.length;
		int DP[][] = new int[size][size]; // i~j까지 최소합 DP
		int s[] = new int[size]; // SUM 저장

		// i요소까지 총합
		s[0] = a[0];
		
		for (int i = 1; i < size; i++)
			s[i] += s[i - 1] + a[i];
		
		// 초기값 저장
		for (int i = 0; i < size - 1; i++)
			DP[i][i + 1] = a[i] + a[i + 1];

		for (int gap = 2; gap < size; gap++) { // i와 j간 gap 3칸부터
			for (int i = 0; i + gap < size; i++) { // i인덱스
				int j = i + gap; // j인덱스
				DP[i][j] = Integer.MAX_VALUE; // MIN을 구하기 위해

				for (int k = i; k < j; k++) // i~j 사이의 k값
					DP[i][j] = Math.min(DP[i][k] + DP[k + 1][j] + sum(s, i, j), DP[i][j]);
			}
		}
		
		return DP[0][a.length - 1];
	}

}
