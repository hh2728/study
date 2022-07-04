package swea.d2;

import java.util.Scanner;

public class SWEA_D2_2001_파리퇴치 {

	static int T;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();

		
		for(int t=1; t<= T; t++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			int map[][] = new int[N][N];
			int max=0;

			for(int r=0; r<N; r++ ) {
				for(int c= 0; c<N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			for(int r=0; r<=N-M; r++) {
				for(int c=0; c<=N-M; c++) {
					int sum=0;
						
						for(int i=r; i<r+M; i++) {
							for(int j=c; j<c+M; j++) {
								
								sum += map[i][j];
								
							}
						}
				
						if(sum>max) max = sum;
				}
			}
			System.out.printf("#%d %d\n",t,max);
		
		}
	}

}
