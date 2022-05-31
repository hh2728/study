package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S1_11067_모노톤길 {

	public static int T, n;
	public static ArrayList<Point> list;
	public static ArrayList<Integer> store;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<Point>();
			store = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Point(x, y, 0));
			}

			st = new StringTokenizer(br.readLine());

			while (!st.hasMoreTokens()) {
				store.add(Integer.parseInt(st.nextToken()));
			}

			list.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					return o1.x - o2.x;
				}
			});

			Point old = new Point(0, 0, 0);
			int point=0;
			int count =0;
			while (true) {
				ArrayList<Point> tlist = new ArrayList<Point>();
				
				for (int i = 0; i < list.size(); i++) {
					Point temp = list.get(i);

					if (old.x + 1 == temp.x) {
						int dist = Math.abs(temp.y - old.y) + Math.abs(temp.x - old.x);
						temp.setDist(dist);
						tlist.add(temp);
						point = i;
						
					}

				}
				tlist.sort(new Comparator<Point>() {

					@Override
					public int compare(Point o1,Point  o2) {
						return o1.dist - o2.dist;
					}
				});
				
				int num=0;
				for(int i=list.size()-point; i<tlist.size(); i++ ) {
					list.get(i).x = tlist.get(num).x;
					list.get(i).y = tlist.get(num).y;
					num++;
				}
				count++;
				System.out.println("hi");
				if(count>10)break;
			}
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i + " x " + list.get(i));
			}
			System.out.println();
		}
	}

	private static class Point {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		public void setDist(int dist) {
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}

	}
}
