package bj.g5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_6987_월드컵 {

	static int win[],lose[],draw[],t1[],t2[];
	static boolean isOk;
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		t1 = new int[15];		//경기하는 2팀
		t2 = new int[15];
		
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<6;j++) {
				t1[cnt]=i;
				t2[cnt++]=j;
			}
		}
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			win = new int[6];		
			lose = new int[6];		
			draw = new int[6];	
			isOk=false;			
			int w=0,l=0,d=0;
			for(int j=0;j<6;j++) {
				w += win[j] = Integer.parseInt(st.nextToken());
				d += draw[j] = Integer.parseInt(st.nextToken());
				l += lose[j] = Integer.parseInt(st.nextToken());
			}
			if(w+d+l!=30)
				isOk=false;
			else
				dfs(0);
			if(isOk) System.out.print(1+" ");
			else System.out.print(0+" ");
		}
	}
	
	static void dfs(int idx) {
		if(isOk) return;
		if(idx==15) {
			isOk=true;
			return;
		}
		int a = t1[idx];
		int b= t2[idx];
		//a가 이기는 경우
		if(win[a]>0 && lose[b]>0) {
			win[a]--;
			lose[b]--;
			dfs(idx+1);
			win[a]++;
			lose[b]++;
		}
		//a와 b가 비기는 경우
		if(draw[a]>0 && draw[b]>0) {
			draw[a]--;
			draw[b]--;
			dfs(idx+1);
			draw[a]++;
			draw[b]++;
		}
		//a가 지는 경우
		if(lose[a]>0 && win[b]>0) {
			lose[a]--;
			win[b]--;
			dfs(idx+1);
			lose[a]++;
			win[b]++;
		}
	}
}