package bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_S5_16395_파스칼의삼각형{

	static int N, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		System.out.println(pascal(N-1,k-1)); // nCr   N-1 = n   k-1 = r 
		
	}
	
	public static int pascal(int n, int k) { // (n-1) C (r-1) + (n-1) C r = nCr
		if(n==k || k==0) return 1;
		return pascal(n-1,k-1)+pascal(n-1,k);
	}

}