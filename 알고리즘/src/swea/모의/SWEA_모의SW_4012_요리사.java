package swea.모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_모의SW_4012_요리사 {
	
	static boolean[] choice;
	static int[][] map;
	static int n,answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<String> hs = new HashSet<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
		TreeSet<Integer> ts = new TreeSet<>((o1,o2)->o2-o1);
		ts.add(10);
		ts.add(100);
		ts.add(160);
		ts.add(1);
		System.out.println(ts);
		int a = 100;
		String tc = String.valueOf(a);
		char c = tc.charAt(0);
		int b = Integer.parseInt(tc);
		//char c = tc.charAt(0);
		double d ;
		d = b;
		
		int tdc = (int) d;
		
		System.out.println(String.format("%.10f", d));
		System.out.print(Math.round(d*100)/100.0);
		System.out.println(tdc);
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			n = N;
			choice = new boolean[N+1];
			answer = Integer.MAX_VALUE;
			map = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(1,0);
			System.out.println("#"+t+" "+answer);
		}		
		
	}
	
	static void dfs(int depth, int count) {
		if(depth == n+1) {
			if((n) /2 == count) {
				solution();
			}
				//System.out.println(Arrays.toString(choice));
			return;
		}
		
		choice[depth] = true;
		dfs(depth + 1, count+1);
		choice[depth] = false;
		dfs(depth + 1, count);
	}
	
	static void solution() {
		ArrayList<Integer> alist = new ArrayList<>();
		ArrayList<Integer> blist = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			if(choice[i] == true) {
				alist.add(i);
			}else {
				blist.add(i);
			}
		}
		
		int point = 0;
		int ap = 0;
		int bp = 0;
		
		for(int i=0; i<alist.size(); i++) {
			for(int j=0; j<alist.size(); j++) {
				if(i != j) {
					ap += map[alist.get(i)][alist.get(j)];
				}
			}
		}
		
		for(int i=0; i<blist.size(); i++) {
			for(int j=0; j<blist.size(); j++) {
				if(i != j) {
					bp += map[blist.get(i)][blist.get(j)];
				}
			}
		}
		
		point = Math.abs(ap - bp);
		
		answer = Math.min(answer, point);
	}

}
