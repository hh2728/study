package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_14936_엘리베이터장난 {
	
	static int N,m,count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int a = N;
		int b = N/2;
		int c = (N+1)/2;
		int d = (N-1)/3  + 1;
		
		//아무것도 안눌렀을때
		count++;
		// 다눌렀을때
		if(a<=m)count++;
		//짝수만 눌럿을때 n이 1이면 안눌른거랑 같아서 조건추가
		if(N>1 && b<=m)count++;
		//홀수만 눌럿을때 n이 1이면 a,c랑 같아서 조건추가
		if(N>1 && c<=m)count++;
		// n이 2면 c,d 같다.
		if(N>2 && d<=m)count++;
		
		if(N>=3 && b+d<=m)count++;
		
		if(N>=3 && c+d<=m)count++;
		
		if(N>=3 && a+d<=m)count++;
		
		System.out.println(count);
	}

}
