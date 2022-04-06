package bj.g4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_G4_2239_스도쿠 {
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	static int[][] map;
	static boolean isFinish;
	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		for(int r=0; r<9; r++) {
			String str = br.readLine();
			for(int c=0; c<9; c++) {
				map[r][c] = str.charAt(c)-'0';
				if(map[r][c] == 0) {
					list.add(new Point(r,c));
				}
			}
		}

		dfs(0);
		

	}
	
	static void dfs(int idx) {
		if(idx == list.size()) {
			isFinish = true;
			for(int r=0; r<9; r++) {
				for(int c=0; c<9; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			return;
		}
		
		if(isFinish) return;
		
		Point temp = list.get(idx);
		for(int i=1; i<=9; i++) {
			if(map[temp.r][temp.c] == 0 && isOk(temp.r, temp.c, i)) {
				map[temp.r][temp.c] = i;
				dfs(idx+1);
				map[temp.r][temp.c] = 0;
			}
		}
	}

	private static boolean isOk(int r, int c, int num) {
		
		for (int i = 0; i < 9; i++) {
            if (map[r][i] == num)
                return false;
            if (map[i][c] == num)
                return false;
        }

		int sr = r/3 * 3;
		int sc = c - c%3;
		for(int row=sr;row<sr+3;row++) {
			for(int col=sc;col<sc+3;col++) {
				if(map[row][col]==num) return false;
			}
		}
		
		
		return true;
	}

}
