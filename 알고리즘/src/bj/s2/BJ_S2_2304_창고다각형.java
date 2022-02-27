package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_2304_창고다각형 {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr= new int[1001];
		N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			arr[num] = height;
		}
		
		int max=-1;
		int number=-1;
		
		for(int n =0; n<1001; n++) {
			if(arr[n]>max) {
				max = arr[n];
				number = n;
			}
		}

		
		int a=-1;
		for(int i=0; i<number; i++) {
			if(arr[i]>a) {
				a = arr[i];
			}else {
				arr[i] = a;
			}
		}
		
		
		int b=-1;
		for(int i=1000; i>number; i--) {
			if(arr[i]>b) {
				b = arr[i];
			}else {
				arr[i] = b;
			}
		}

		int sum=0;
		for(int n =0; n<1001; n++) {
			sum += arr[n];
		}
		
		System.out.println(sum);

	}

}
