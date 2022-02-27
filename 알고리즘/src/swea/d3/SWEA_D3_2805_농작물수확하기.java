package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_2805_농작물수확하기 {
	
	static int T,point;
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c)-'0';
				}
			}
			point = N/2;
			
			int sum=0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(isOk(r,c))
						sum += map[r][c];
				}
			}
			
			System.out.println("#"+t+" "+sum);
		}

	}
	static boolean isOk(int nr,int nc) {
		
		return Math.abs(point - nr) + Math.abs(point - nc) <= point;
	}

}
