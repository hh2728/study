package bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S5_1292_쉽게푸는문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[1001];
		int sum=0;
		int count =1;
		
		for(int i=1; i<=1000; i++) {
			for(int j=0; j<i; j++) {
				if(count==1001) break;
				arr[count++] = i;
			}
		}
		
		for(int i=a; i<=b; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
	}

}
