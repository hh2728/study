package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_SW문제해결응용_1249_보급로 {
	
	static class Point implements Comparable<Point>{
		int r, c, dist;

		public Point(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}
		
	}
	
	static int T,N,min;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}

			dijkstra();
			
			System.out.println("#"+t+" "+min);
		}
		
	}
	
	static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,map[0][0]));
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Point temp = pq.poll();
			
			if(temp.r==N-1 && temp.c ==N-1) {
				min = temp.dist;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isOk(nr,nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					pq.add(new Point(nr,nc,temp.dist + map[nr][nc]));
				}
			}
		}
	}
	
	private static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
