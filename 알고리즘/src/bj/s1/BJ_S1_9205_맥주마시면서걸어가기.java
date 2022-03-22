package bj.s1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_9205_맥주마시면서걸어가기 {
	
	static int T,N,sr,sc,dr,dc;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			List<point> list = new ArrayList<>();
			
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(i==0) {
					sr = r;
					sc = c;
				}else if(i==N+1) {
					dr = r;
					dc = c;
				}else {
					list.add(new point(r,c));
				}
			}
			
			bw.write(bfs(list)? "happy\n" : "sad\n");
			
		}
		
		bw.flush();
		bw.close();

	}
	
	public static boolean bfs(List<point> list) {
		
		Queue<point> q = new LinkedList<>();
		q.add(new point (sr,sc));
		
		boolean[] visited = new boolean[N];
		
		
		while(!q.isEmpty()) {
			point temp = q.poll();
			int pr = temp.r;
			int pc = temp.c;
			
			if(Math.abs(pr-dr) + Math.abs(pc-dc) <= 1000) {
				return true;
			}
			
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					int nr = list.get(i).r; 
					int nc = list.get(i).c;
					int dis = Math.abs(pr - nr) + Math.abs(pc - nc);
					
					if(dis <= 1000) {
						visited[i] = true;
						q.add(new point(nr,nc));
					}
				}
			}
		}
		return false;
	}
	
	static class point{
		int r,c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "point [r=" + r + ", c=" + c + "]";
		}
		
	}

}
