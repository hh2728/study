package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

import java.util.StringTokenizer;

public class BJ_S1_1697_숨바꼭질 {

	static int N,K,ans;
	static PriorityQueue<Point> qu = new PriorityQueue<>();
	static int[] sec;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sec = new int[1000001];
		ans = Integer.MAX_VALUE;
		Arrays.fill(sec, Integer.MAX_VALUE);
		
		bfs();


	}
	private static void bfs() {
		
		qu.add(new Point(N,0));
		
		while(!qu.isEmpty()) {
			
			Point temp = qu.poll();
			
			if(temp.n == K) {
				System.out.println(temp.p);
				break;
			}
			
			if(temp.n <0 || temp.n > 1000000) {
				continue;
			}
			
			if(temp.p < sec[temp.n]) {
				sec[temp.n] = temp.p;
			}else {
				continue;
			}
					
			
			qu.add(new Point(temp.n-1,temp.p+1));

			qu.add(new Point(temp.n+1,temp.p+1));

			qu.add(new Point(temp.n*2,temp.p+1));

		}
		
	}

	private static class Point implements Comparable<Point>{
		int n,p;

		public Point(int n, int p) {
			super();
			this.n = n;
			this.p = p;
		}

		@Override
		public int compareTo(Point o) {
			return this.p - o.p;
		}
		
		
	}
}
