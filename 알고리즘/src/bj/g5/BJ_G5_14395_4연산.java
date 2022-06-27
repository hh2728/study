package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G5_14395_4연산 {
	
	static long s,t;
	static Set<Long> list;
	static char[] dir = {'*','+','-','/'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		list = new HashSet<Long>();
		if(s == t) {
			System.out.println(0);
		}else {
			bfs(s);
		}
	}
	
	private static void bfs(long s) {
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(s,""));
		list.add(s);
		
		while(!qu.isEmpty()) {
			Point temp = qu.poll();
			if(temp.num == t) {
				System.out.println(temp.str);
				return;
			}
			
			for(int d=0; d<4; d++) {
				long n_point = 0;
				switch(d) {
				case 0:
					n_point = temp.num * temp.num;
					break;
				case 1:
					n_point = temp.num + temp.num;
					break;
				case 2:
					n_point = temp.num - temp.num;
					break;
				case 3:
					if(temp.num == 0) continue;
					n_point = temp.num / temp.num;
					break;
				}
				
				if(!list.contains(n_point)) {
					list.add(n_point);
					qu.offer(new Point(n_point, temp.str + dir[d]));
				}
			}
		}
		System.out.println(-1);
		return;
	}
	
	static class Point{
		long num;
		String str;
		
		public Point(long num, String str) {
			super();
			this.num = num;
			this.str = str;
		}
		
		
	}
}
