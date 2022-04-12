package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_5604_구간합 {
	
	static int T;
	static long A,B;
	static long[] counts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A= Long.parseLong(st.nextToken());
			B= Long.parseLong(st.nextToken());
			
			counts = new long[10];
			long point=1;
			
			while(A<=B) {
				for(; A%10!=0 && A<=B; A++) {
					calc(A, point);
				}
				for(; B%10!=9 && A<=B; B--) {
					calc(B, point);
				}
				
				if(A>B) {
					break;
				}
				
				A/=10;
				B/=10;
				long row = B-A+1;
				for(int i=1; i<10; i++) {
					counts[i] += row * point;
				}
				point *= 10;
			}
			
			long sum=0;
			for(int i=1; i<10; i++) {
				sum += i*counts[i];
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}

	private static void calc(long n, long point) {
		while(n>0) {
			counts[(int)(n%10)] += point;
			n/=10;
		}
		
	}

}
