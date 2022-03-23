package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S1_10597_순열장난 {
	
	static String s;
	static int len;
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		len = s.length();
		visit= new boolean[51];
		dfs(0,0,"");

	}
	private static void dfs(int idx, int N, String ans) {
		if(idx == len) {
			for(int i =1; i<=N; i++) {
				if(!visit[i])
					return;
			}
			System.out.println(ans.trim());
			System.exit(0);
			return;
		}
		
		String tmp = s.substring(idx, idx+1);
		int num = Integer.parseInt(tmp);
		if(!visit[num]) {
			visit[num] = true;
			dfs(idx+1, (num > N)? num :N, ans+" "+tmp);
			visit[num] = false;
		}
		if(idx < len-1) {
			tmp = s.substring(idx, idx+2);
			num = Integer.parseInt(tmp);
			if(num < 51 && !visit[num]) {
				visit[num] = true;
				dfs(idx+2, (num > N)? num : N, ans+" "+tmp);
				visit[num] = false;
			}
		}
	}

}
