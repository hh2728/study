package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_알고스팟 {

	static int N,M,count;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int m=0;m<M; m++) {
				map[n][m] = str.charAt(m)-'0';
				
			}
		}
		count=Integer.MAX_VALUE;
		bfs(0,0);

		System.out.println(count);
	}

	private static void bfs(int i, int j) {
		PriorityQueue<point> qu = new PriorityQueue<>();
		visited = new boolean[N][M];
		qu.add(new point(i,j,0));
		visited[i][j] = true;
		
		while(!qu.isEmpty()) {
			point temp = qu.poll();

			if(temp.r == N-1 && temp.c == M-1) {
				count= Math.min(count, temp.count);
				return;
			}
			
			
			for(int d=0; d<4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				
				if(isOk(nr,nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					qu.add(new point(nr,nc,temp.count+1));
				}else if(isOk(nr,nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					qu.add(new point(nr,nc,temp.count));
				}
			}
			
		}

		
	}
	
	private static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
	
	
	
	static class point implements Comparable<point>{
		int r,c,count ;

		public point(int r, int c,int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}

		@Override
		public int compareTo(point o) {
			return this.count - o.count;
		}
		
		
	}

}
