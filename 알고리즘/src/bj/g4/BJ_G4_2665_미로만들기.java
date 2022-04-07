package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_G4_2665_미로만들기 {
	
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N;
	static int[][] map;
	static int[][] dist;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c)-'0';
				dist[r][c] = Integer.MAX_VALUE;
			}
		}

		dijkstra();
		System.out.println(dist[N-1][N-1]);
		
	}
	
	private static void dijkstra() {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(0,0));
		dist[0][0] = 0;

		
		while(!qu.isEmpty()) {
			Point temp = qu.poll();
			
			for(int d=0; d<4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isOk(nr,nc) && dist[nr][nc] > dist[temp.r][temp.c]) {
					if(map[nr][nc] == 1) {
						dist[nr][nc] = dist[temp.r][temp.c];
					}else if(map[nr][nc] == 0) {
						dist[nr][nc] = dist[temp.r][temp.c]+1;
					}
					qu.offer(new Point(nr,nc));
				}

			}
		}
	}
	
	private static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
