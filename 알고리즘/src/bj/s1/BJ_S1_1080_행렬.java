package bj.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1080_행렬 {
	
	static int N,M;
	static int[][] a,b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		a = new int[N][M];
		b = new int[N][M];

		for (int r = 0; r < N; r++) {
			String temp = br.readLine();

			for (int c = 0; c < M; c++) {
				a[r][c] = temp.charAt(c) - '0';
			}
		}
		
		for (int r = 0; r < N; r++) {
			String temp =br.readLine();

			for (int c = 0; c < M; c++) {
				b[r][c] = temp.charAt(c) - '0';
			}
		}

		int count = 0;
		
		for (int r = 0; r <= N - 3; r++) {
			for (int c = 0; c <= M - 3; c++) {
				
				if (a[r][c] != b[r][c]) {			//다르면 그자리에서 3x3 바꾸기
					count++;
					
					for (int p = r; p < r + 3; p++) {
						for (int q = c; q < c + 3; q++) {
							a[p][q] = (a[p][q] == 0) ? 1 : 0;		// 0이면 1  1이면 0
						}
					}
				}
			}
		}
		
		boolean flag = true;	// 끝까지 갔을때 확인
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] != b[i][j]) {
					flag = false;		// 완성이 안돼? 그럼 false
					break;
				}
			}
		}
		
		System.out.println((flag) ? count : -1);		//완성 불가능이야

	}

}
