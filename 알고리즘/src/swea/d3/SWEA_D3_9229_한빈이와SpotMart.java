package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229_한빈이와SpotMart {
	
	static int T,N,M,snack[],num[];
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			snack = new int[N];
			num = new int[2];
			sum =-1;
	
			
			st = new StringTokenizer(br.readLine()," ");

			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0,0);
			System.out.printf("#%d %d\n",t,sum);
		}
		

	}
	
	public static void solve(int cnt, int idx) {	//2번만 돌기
		
		if (cnt == 2) {
			int max =0;
			max =  num[0]+num[1];
			if(max<=M && max>sum) 
				sum = max;
				return;
			}
			
			for(int i = idx; i<N; i++) {
				num[cnt] = snack[i];
				solve(cnt+1, i+1);
			}
		}
}


