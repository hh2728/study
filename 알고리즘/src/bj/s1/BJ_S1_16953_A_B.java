package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_16953_A_B {

	static int A, B, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		ans =1;
		
		while(A!=B) {
			if(B<A) {
				System.out.println("-1");
				System.exit(0);
			}
			
			if(B%10==1) B = B/10;
			else if(B%2==0) B = B/2;
			else {
				System.out.println("-1");
				System.exit(0);
				
			}
			
			ans++;
		}
		
		System.out.println(ans);
	}
}
