package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_G4_2665_미로만들기 {
	
	static class Point implements Comparable<Point>{
		int r,c,dist;

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

	static int N,ans;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		ans = 0;
		dijkstra();
		System.out.println(ans);
		
	}
	
	private static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		visited[0][0] = true;
		
		while(true) {
			Point temp = pq.poll();
			
			if(temp.r == N-1 && temp.c == N-1) {
				ans = temp.dist;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isOk(nr,nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					pq.add(new Point(nr,nc,temp.dist));
					visited[nr][nc] = true;
				}else if(isOk(nr,nc) && !visited[nr][nc] && map[nr][nc] == 0 ) {
					pq.add(new Point(nr,nc,temp.dist+1));
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	private static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
