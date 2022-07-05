package bj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G3_2109_순회공연 {

	static int n,ans;
	static Point[] list;
	static boolean[] days;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new Point[n];
		days = new boolean[10001];
		ans = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list[i] = new Point(p,d);
		}
		
		Arrays.sort(list);
		
		for(int i=0; i<n; i++) {
			for(int j = list[i].d; j>0; j--) {
				if(!days[j]) {
					days[j] = true;
					ans += list[i].p;
					break;
				}
			}
		}
		
	
		System.out.println(ans);

	}
	private static class Point implements Comparable<Point>{
		int p,d;

		public Point(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Point o) {
			if(o.p == this.p) {
				return o.d - this.d;
			}
			return o.p - this.p;
		}

		@Override
		public String toString() {
			return "Point [p=" + p + ", d=" + d + "]";
		}
		
		
	}

}
