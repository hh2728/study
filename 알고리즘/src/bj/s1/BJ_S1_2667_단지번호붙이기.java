package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_S1_2667_단지번호붙이기 {

	static int N,count;
	static int[][] map;
	static boolean[][] visit;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> result = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visit[r][c] && map[r][c]==1) {
					count=1;
					bfs(r,c);
					result.add(count);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
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
					count++;
				}
			}
		}
	}
	
	static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
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
