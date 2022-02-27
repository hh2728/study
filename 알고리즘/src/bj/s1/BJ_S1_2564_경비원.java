package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원 {
	
	static int R,C,N;
	static int[][] store;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		store = new int[N+1][2];
		for(int n=0; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			
			store[n][0] = Integer.parseInt(st.nextToken());
			store[n][1] = Integer.parseInt(st.nextToken());
			
		}
		
		int cnt = 0;
		int direc = store[N][0];
		int num = store[N][1];
		
		if(direc == 1) { //동근이가 상에 있을 때
			for(int i=0; i<N; i++) {
				if(store[i][0] == 1) {
					cnt += Math.abs(store[i][1] - num);
				}else if(store[i][0] == 2) {
					cnt += Math.min(R + store[i][1] + num, R + (C - store[i][1]) + (C - num));
				}else if(store[i][0] == 3) {
					cnt += store[i][1] + num;
				}else {
					cnt += (R - store[i][1]) + num;
				}
			}
		}
		else if(direc == 2){ //하
			for(int i=0; i<N; i++) {
				if(store[i][0] == 1) {
					cnt += Math.min(R + store[i][1] + num, R + (C - store[i][1]) + (C - num));
				}else if(store[i][0] == 2) {
					cnt += Math.abs(store[i][1] - num);
				}else if(store[i][0] == 3) {
					cnt += (R - store[i][1]) + num;
				}else {
					cnt += (R - store[i][1]) + (C - num);
				}
			}
		}
		else if(direc == 3) { //좌
			for(int i=0; i<N; i++) {
				if(store[i][0] == 1) {
					cnt += num + store[i][1];
				}else if(store[i][0] == 2) {
					cnt += (R - num) + store[i][1];
				}else if(store[i][0] == 3) {
					cnt += Math.abs(store[i][1] - num);
				}else {
					cnt += Math.min(C + store[i][1] + num, C + (R - store[i][1]) + (R - num));
				}
			}
		}
		else if(direc == 4) { //우
			for(int i=0; i<N; i++) {
				if(store[i][0] == 1) {
					cnt += num + (C - store[i][1]);
				}else if(store[i][0] == 2) {
					cnt += (R - num) + (C - store[i][1]);
				}else if(store[i][0] == 3) {
					cnt += Math.min(C + store[i][1] + num, C + (R - store[i][1]) + (R - num));
				}else {
					cnt += Math.abs(store[i][1] - num);
				}
			}
		}
		
		System.out.println(cnt);
	}

}
