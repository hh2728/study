package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14502_연구소 {
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N,M,ans;
	static int[][] map;	//원본
	static int[][] cmap;	//카피본
	static boolean[][] visit;	
	static boolean go;	//엉뚱한데 벽세웠나 확인
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = Integer.MIN_VALUE;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(3,new int[3],new boolean[N*M+1]);
		System.out.println(ans);
	}
	
	//순열로 다 조합생각하기
	static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose==0) {
			visit = new boolean[N][M];
			cmap = new int[N][M];
			int count =0;
			go = false;
			
			//작업환경 카피
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					cmap[n][m] = map[n][m];
				}
			}
			//순열로 얻은 숫자로 벽세우기 
			makeWall(choosed[0]);
			makeWall(choosed[1]);
			makeWall(choosed[2]);
			
			//바이러스 확산
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(cmap[n][m] ==2) {
						bfs(n,m);
					}
				}
			}
			//안전구역 찾기
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(cmap[n][m] ==0) {
						count++;
					}
				}
			}
			//벽있는곳이나 바이러스위에 벽세우려고했으면 벽이 3개가 안되니까 계산하면 안됨
			if(go)count=0;

			ans = Math.max(count, ans);
			return;
		}
		
		//순열부분
		for(int i=0; i<N*M; i++) {
			if(!visited[i]) {
			choosed[3-toChoose] = i;
			visited[i] = true;
			permutation(toChoose-1,choosed,visited);
			visited[i] = false;
			}
		}
	}
	
	static void bfs(int r, int c) {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(r,c));
		visit[r][c] = true;

		while(!qu.isEmpty()) {
			Point temp = qu.poll();
			
			for(int d=0; d<4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				//범위안에 있고, 방문한적 없고, 벽이 아니면
				if(isOk(nr,nc) && !visit[nr][nc] && cmap[nr][nc] != 1) {
					cmap[nr][nc] = 2;
					visit[nr][nc] = true;

					qu.add(new Point(nr,nc));
				}
			}
		}

	}
	
	static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
	
	//벽만들기
	static void makeWall(int a) {
		int nr=0,nc=0;
		
		// 숫자가 가로M보다 크면 처리해서 쓰기. 
		// ex) M =7일때 a가 15이면 (1,6)로 변환
		if(a>=M) {
			 nr = a/M;
			 nc = a%M;
		}else {
			 nr = 0;
			 nc = a;
		}
		
		// 벽, 바이러스가 아니면 벽세우기
		if(map[nr][nc] == 0) {
			cmap[nr][nc] =1;
		}else if(map[nr][nc] ==2 || map[nr][nc]==1){
			go = true;
		}
	}

}
