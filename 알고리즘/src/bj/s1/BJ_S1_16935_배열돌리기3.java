package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_16935_배열돌리기3 {

	static int N, M, R;
	static int map[][], result[][];
	static int t[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		result = new int[N][M];
		t = new int[R];
		
		int rr = N/2;
		int cc = M/2;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < R; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < t.length; i++) {
			
			switch (t[i]) {
			
			case 1:
				result = new int[N][M];
				
				for (int r = 0; r < N; r++) {

					for (int c = 0; c < M; c++) {

						result[N-r-1 ][c] = map[r][c];

					}
				}

				map = result;
				break;
			case 2:
				result = new int[N][M];
				
				for (int r = 0; r < N; r++) {

					for (int c = 0; c < M; c++) {

						result[r ][M-1-c] = map[r][c];

					}
				}

				map = result;
				break;
			case 3:

				result = new int[M][N];
				
				int C = N-1;
				for (int r = 0; r < N; r++) {

					for (int c = 0; c < M; c++) {
						result[c][C] = map[r][c];
						
					}
					C--;
				}
				
				int temp = N;
				N =M;
				M = temp;
				
				map =result;
				break;
			case 4:

				result = new int[M][N];
				
				
				for (int r = 0; r < N; r++) {

					for (int c = 0; c < M; c++) {
						result[M-1-c][r] = map[r][c];
						
					}
				
				}
		
				
				temp = N;
				N =M;
				M = temp;
	
				map =result;
				break;
				
			case 5:

				result = new int[N][M];
				
				rr = N/2;
				cc = M/2;
				
				// 1->2
				for (int r = 0; r < rr; r++) {
					for (int c = 0; c < cc; c++) {
						result[r][c+cc] = map[r][c];
					}
				}
				// 2->3
				for (int r = 0; r < rr; r++) {
					for (int c = cc; c < M; c++) {
						result[r+rr][c] = map[r][c];
					}
				}
				// 3->4
				for (int r = rr; r < N; r++) {
					for (int c = cc; c < M; c++) {
						result[r][c-cc] = map[r][c];
						
					}
				}
				// 4->1
				for (int r = rr; r < N; r++) {
					for (int c = 0; c < cc; c++) {
						result[r-rr][c] = map[r][c];
					}
				}
				
				map = result;
	
				
				break;
				
			case 6 :
				
				result = new int[N][M];
				
				rr = N/2;
				cc = M/2;

				// 1->4
				for (int r = 0; r < rr; r++) {
					for (int c = 0; c < cc; c++) {
						result[r+rr][c] = map[r][c];
					}
				}
				//4->3
				for (int r = rr; r < N; r++) {
					for (int c = 0; c < cc; c++) {
						result[r][c+cc] = map[r][c];
					}
				}
				//3->2
				for (int r = rr; r < N; r++) {
					for (int c = cc; c < M; c++) {
						result[r-rr][c] = map[r][c];
					}
				}
				//2->1
				for (int r = 0; r < rr; r++) {
					for (int c = cc; c < M; c++) {
						result[r][c-cc] = map[r][c];
						
					}
				}
				map = result;

				break;
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}

	}

}
