package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_2174_로봇시뮬레이션 {

	static int A, B, N, M;
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int dir;
	static List<robot> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[B + 1][A + 1];
		list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String F = st.nextToken();
			int dir = 0;

			switch (F) {
			case "N":
				dir = 1;
				break;
			case "E":
				dir = 2;
				break;
			case "S":
				dir = 3;
				break;
			case "W":
				dir = 4;
				break;
			}

			list.add(new robot(y, x, dir));
			map[y][x] = r+1;
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			int time = Integer.parseInt(st.nextToken());

			for (int t = 0; t < time; t++) {
				switch (order) {
				case "F":
					//System.out.println("앞");
					goF(num);
					break;

				case "R":
					//System.out.println("우");
					turnR(num);
					break;

				case "L":
					//System.out.println("좌");
					turnL(num);
					break;
				}

			}

		}
		System.out.println("OK");
	}

	public static void goF(int num) {
		robot temp = list.get(num - 1);
		//System.out.println(temp);

		switch (temp.dir) {
		case 1:
			temp.r += 1;
			if (temp.r > B) {
				System.out.println("Robot " + num + " crashes into the wall");
				System.exit(0);
			} else if (map[temp.r][temp.c] != 0) {
				System.out.println("Robot " + num + " crashes into robot " + map[temp.r][temp.c]);
				System.exit(0);
			} else {
				list.set(num-1, temp);
				map[temp.r][temp.c] = num;
			}
			break;
		case 2:
			temp.c += 1;
			if (temp.c > A) {
				System.out.println("Robot " + num + " crashes into the wall");
				System.exit(0);
			} else if (map[temp.r][temp.c] != 0) {
				System.out.println("Robot " + num + " crashes into robot " + map[temp.r][temp.c]);
				System.exit(0);
			} else {
				list.set(num-1, temp);
				map[temp.r][temp.c] = num;
			}
			break;
		case 3:
			temp.r -= 1;
			if (temp.r < 1) {
				System.out.println("Robot " + num + " crashes into the wall");
				System.exit(0);
			} else if (map[temp.r][temp.c] != 0) {
				System.out.println("Robot " + num + " crashes into robot " + map[temp.r][temp.c]);
				System.exit(0);
			} else {
				list.set(num-1, temp);
				map[temp.r][temp.c] = num;
			}
			break;
		case 4:
			temp.c -= 1;
			if (temp.c < 1) {
				System.out.println("Robot " + num + " crashes into the wall");
				System.exit(0);
			} else if (map[temp.r][temp.c] != 0) {
				System.out.println("Robot " + num + " crashes into robot " + map[temp.r][temp.c]);
				System.exit(0);
			} else {
				list.set(num-1, temp);
				map[temp.r][temp.c] = num;
			}
			break;
		}
	}

	public static void turnL(int num) {
		robot temp = list.get(num - 1);

		if (temp.dir == 1) {
			temp.dir = 4;
		} else {
			temp.dir = temp.dir - 1;
		}
		list.set(num-1, temp);
		
	}

	public static void turnR(int num) {
		robot temp = list.get(num - 1);

		if (temp.dir == 4) {
			temp.dir = 1;
		} else {
			temp.dir = temp.dir + 1;
		}

		list.set(num-1, temp);
	}

	public static class robot implements Comparable<robot>{
		int r, c, dir;

		robot(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
		@Override
		public String toString() {
			return "r:"+r+" c:"+c+" 방향:"+dir;
		}
		
		@Override
		public int compareTo(robot o) {
			return o.r- this.r;
		}
	}

}
