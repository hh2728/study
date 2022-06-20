package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_G4_11559_PuyoPuyo {
	
	static char[][] map;
	static boolean[][] check;
	static List<int[]> list;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static int ans;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		map = new char[12][6];
		
		for(int r=0; r<12; r++) {
			String st = br.readLine();
			for(int c=0; c<6; c++) {
				char stc = st.charAt(c);
				map[r][c] = stc;
			}
		}
		
		ans = 0;
		while(true) {
			flag = false;
			
			for(int r=0; r<12; r++) {
				for(int c=0; c<6; c++) {
					if(map[r][c] != '.') {
						
						char color = map[r][c];
						check = new boolean[12][6];
						list = new ArrayList<>();
						
						int connect = bfs(r,c,color);
						if(connect >= 4) {
							flag = true;
							
							for(int[] change : list) {
								int cr = change[0] , cc = change[1];
								map[cr][cc] = '.';
							}
						}
					}
				}
			}
			
			if(!flag) break;
			else ans++;
			
			mapUpdate();
		}
		System.out.println(ans);
	}
	
	static int bfs(int r, int c, char color) {
		Queue<int[]> qu = new LinkedList<>();
		check[r][c] = true;
		
		qu.add(new int[] {r,c});
		list.add(new int[] {r,c});
		
		while(!qu.isEmpty()) {
			int[] temp = qu.poll();
			int tempr = temp[0];
			int tempc = temp[1];
			
			for(int d=0; d<4; d++) {
				int nr = tempr + deltas[d][0];
				int nc = tempc + deltas[d][1];
				
				if(nc<0 || nc>5 || nr<0 || nr>11) continue;
				if(check[nr][nc]) continue;
				
				if(map[nr][nc] == color) {
					list.add(new int[] {nr,nc});
					check[nr][nc] = true;
					qu.add(new int[] {nr,nc});
				}
			}
		}
		return list.size();
	}
	
	static void mapUpdate() {
		Queue<Character> qu = new LinkedList<>();
		
		for(int c=0; c<6; c++) {
			for(int r=11; r>=0; r--) {
				if(map[r][c] != '.') qu.add(map[r][c]);
				map[r][c] = '.';
			}
			
			int h=11;
			while(!qu.isEmpty()) {
				map[h][c] = qu.poll();
				h--;
			}
		}
	}

}
