package bj.g1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_1194_달이차오른다가자 {
	
	static int N, M;
    static char map[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        int r = -1;
        int c = -1;
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') {
                    r = i;
                    c = j;
                }
            }
        }
        escape(r, c);
    }
    
    public static void escape(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(-1, -1, 0));
        q.offer(new Point(r, c, 0));
        boolean visit[][][] = new boolean[N][M][64];
        visit[r][c][0] = true;
        
        int count = -1;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            if(now.r == -1) {
                count++;
                if(!q.isEmpty())
                    q.offer(now);
                continue;
            }
            
            if(map[now.r][now.c] == '1') {
                System.out.println(count);
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = now.r + deltas[i][0];
                int nc = now.c + deltas[i][1];
                
                int key = now.key;

                if(isOk(nr, nc) && !visit[nr][nc][key]) {
                    //열쇠
                    if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
                        key |= (1 << map[nr][nc] - 'a');
                        visit[nr][nc][key] = true;
                        q.offer(new Point(nr, nc, key));
                    }
                    //문
                    else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
                        if(!((key & (1 << map[nr][nc] - 'A')) == 0)) {
                            visit[nr][nc][key] = true;
                            q.offer(new Point(nr, nc, key));
                        }
                    }
                    //빈 칸
                    else {
                        q.offer(new Point(nr, nc, key));
                        visit[nr][nc][key] = true;
                    }
                }

            }
        }
        System.out.println(-1);
    }
    
    public static boolean isOk(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M && map[r][c] != '#';
    }
    
    static class Point {
        int r, c, key;
        
        Point(int r, int c, int key) {
            this.r = r;
            this.c = c;
            this.key = key;
        }
    }

}
