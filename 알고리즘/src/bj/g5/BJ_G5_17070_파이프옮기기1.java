package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_17070_파이프옮기기1 {
	
	static int N,ans;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		dfs(1,2,0);
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int dir) {
		if(r ==N && c ==N) {
			ans++;
			return;
		}
		
		switch (dir) {
       
		case 0: // 파이프가 가로 방향일 경우, 갈 수 있는 경우는 동쪽과 대각선임.
            if (c + 1 <= N && map[r][c + 1] == 0) { // 동쪽
                dfs(r, c + 1, 0);
            }
            break;
       
        case 1: // 파이프가 세로 방향일 경우, 갈 수 있는 경우는 남쪽과 대각선임.
            if (r + 1 <= N && map[r + 1][c] == 0) { // 남쪽
                dfs(r + 1, c, 1);
            }
            break;
       
        case 2: // 파이프가 대각선일 경우, 갈 수 있는 경우는 동쪽과 남쪽, 대각선임.
            if (c + 1 <= N && map[r][c + 1] == 0) { // 동쪽
                dfs(r, c + 1, 0);
            }
 
            if (r + 1 <= N && map[r + 1][c] == 0) { // 남쪽
                dfs(r + 1, c, 1);
            }
            break;
        }
 
        // 대각선
        if (c + 1 <= N && r + 1 <= N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
            dfs(r + 1, c + 1, 2);
        }
		
	}

}
