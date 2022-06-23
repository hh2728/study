package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_16926_배열돌리기1 {
	
	static int N,M;
	static int map [][];
	static int R;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
				
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int group = Math.min(N,M) / 2;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<group; j++) {
				int r =j;
				int c=j;
				
				int value = map[r][c];
				
				int dir =  0;
				
				while(dir<4) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					if(nr>=j&&nc>=j&&nr<N-j&&nc<M-j) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
					}
					else dir++;
				}
				
				map[j+1][j] = value;
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				System.out.print(map[r][c]+ " ");
			}
			System.out.println();
		}

		
		
	}
	
}
