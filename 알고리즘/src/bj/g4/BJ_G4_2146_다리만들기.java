package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2146_다리만들기 {

	static int N, ans, island;
	static int[][] map;
	static boolean[][] check;
	static int[][] deltas = {{0,-1},{0,1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		island = 1;
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1 && !check[r][c]) {
					makeLand(r,c);
					island++;
				}
			}
		}
		
		check = new boolean[N][N];
		ans = Integer.MAX_VALUE;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] != 0 && !check[r][c]) {
					makeBridge(r,c,map[r][c]);
					check = new boolean[N][N];
				}
			}
		}
		System.out.println(ans);

	}
	
	
	static void makeBridge(int r, int c, int num) {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(r,c,0));
		check[r][c] = true;
		
		while(!qu.isEmpty()) {
			Point temp = qu.poll();
			
			for(int d=0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isOk(nr,nc) && !check[nr][nc]) {
					if(map[nr][nc] == 0) {
						check[nr][nc] = true;
						qu.add(new Point(nr,nc,temp.count + 1));
						
					}else if(map[nr][nc] != 0 && map[nr][nc] != num) {
						ans = Math.min(ans, temp.count);
						return;
					}
				}
			}
		}
	}
	
	static void makeLand(int r, int c) {
		
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(r,c,0));
		check[r][c] = true;
		map[r][c] = island;
		
		while(!qu.isEmpty()) {
			Point temp = qu.poll();
			
			for(int d=0; d<4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isOk(nr,nc) && map[nr][nc] == 1 && !check[nr][nc]) {
					check[nr][nc] = true;
					map[nr][nc] = island;
					qu.add(new Point(nr,nc,temp.count+1));
				}
			}
		}
		
		
		
	}
	static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
	
	static class Point{
		int r, c, count;
		
		public Point(int r, int c, int count){
			this.r = r;
			this.c = c;
			this.count = count;
		}

	}

}
