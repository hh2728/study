package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_2573_빙산 {
	
	static int R,C,count,year;
	static int map[][];
	static boolean visit[][];
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		year = 0;
		
		while(true) {
			year++;
			runTime();

			if (isCheck()>= 2) {
				
				break;
			}
			if(isCheck() == 0) {
				year = 0;
				break;
			}
			
			visit = new boolean[R][C];

		}

		System.out.println(year);
	}
	
	static void runTime() {
		boolean[][] nmap = new boolean[R][C];

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==0) {
					
				}
				else if(map[i][j] != 0) {
					nmap[i][j] = true;
					int cnt=0;
					for(int d=0; d<4; d++) {
						int nr = i + deltas[d][0];
						int nc = j + deltas[d][1];
						
						if(isOk(nr,nc) && map[nr][nc] == 0 && !nmap[nr][nc]) {
							cnt++;
						}
					}
					if(map[i][j] - cnt <0) {
					map[i][j] = 0;
					}else {
					map[i][j] = map[i][j] - cnt;
					}
				}
				
			}
		}

	}
	
	public static int isCheck() {
        boolean[][] visited = new boolean[R][C];
 
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited); 
                    count++;
                }
            }
        }
        return count;
    }
 
    public static void DFS(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
 
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + deltas[i][0];
            nc = c + deltas[i][1];
 
            if (!isOk(nr,nc)) {
                continue;
            }
 
            if (map[nr][nc] != 0 && !visited[nr][nc]) {
                DFS(nr, nc, visited);
            }
        }
    }

	static boolean isOk(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C; 
	}

}
