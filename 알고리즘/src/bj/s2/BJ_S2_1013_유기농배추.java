package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_S2_1013_유기농배추 {
	
	static int T,M,N,K,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			ans=0;
			st= new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			visit = new boolean[N][M];
			map = new int[N][M];
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c] == 1 && !visit[r][c]) {
						bfs(r,c);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
			
		}
		
		

	}
	
	static void bfs(int r, int c) {
		
		Queue<point> qu = new LinkedList<point>();
		visit[r][c] = true;
		qu.add(new point(r, c));
		
		
		while (!qu.isEmpty()) {
			point temp = qu.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isOk(nr,nc) && !visit[nr][nc] && map[nr][nc] ==1) {
					visit[nr][nc] = true;
					qu.add(new point(nr,nc));
				}
			}
		}
	}
	
	static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}

	static class point {
		int r, c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}
