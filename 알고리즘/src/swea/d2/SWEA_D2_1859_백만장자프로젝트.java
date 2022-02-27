package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_1859_백만장자프로젝트 {

	static int T, N,max;
	static long ans;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			ans=0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			max = arr[N-1];
			for(int i=N-2; i>=0; i--) {
				if(max <= arr[i]) {
					max = arr[i];
				}else {
					ans += max - arr[i];
				}
			}
			
			System.out.printf("#%d %d\n",t,ans);
			
		}

	}

}
