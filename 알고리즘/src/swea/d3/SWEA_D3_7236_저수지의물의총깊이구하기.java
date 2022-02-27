package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_7236_저수지의물의총깊이구하기 {
	
	static int T,N,max;
	static char[][] map;
	static int deltas[][] = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					String str = st.nextToken();
					map[r][c] = str.charAt(0);
				}
			}
			
			int max=-1;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] =='W') {
						int cnt=0;
						for(int d=0; d<8; d++) {
							int nr = r+deltas[d][0];
							int nc = c+deltas[d][1];
							
							if(isOk(nr,nc) && map[nr][nc]=='W') {
								cnt++;
							}
						}
						if(cnt==0) {
							max = 1;
						}
						max = Math.max(max, cnt);
						
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,max);

		}

	}
	static boolean isOk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
