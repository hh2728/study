package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class BJ_S1_11067_모노톤길 {
	
	public static int T,n;
	public static ArrayList<Point> list;
	public static ArrayList<Integer> store;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<Point>();
			store = new ArrayList<Integer>();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Point(x,y));
			}
			
			st = new StringTokenizer(br.readLine());
			
			while(!st.hasMoreTokens()) {
				store.add(Integer.parseInt(st.nextToken()));
			}
			
			list.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					return o1.x - o2.x;
				}
			});
			
			for (int i = 0; i <list.size(); i++) {
				System.out.println(i+" x "+list.get(i));
			}
			System.out.println();
		}
	}
	private static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}	
		
	}
}
