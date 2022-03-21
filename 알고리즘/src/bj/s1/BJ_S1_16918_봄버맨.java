package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_16918_봄버맨 {
	
	static int R,C,N;
	static char[][] map;
	static Queue<point> q = new LinkedList<>();
    static int bombtime[][];
    static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
    static int time = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		bombtime = new int[R][C];
		
		
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = str.charAt(c);
				//폭탄있으면 설치 해놓기
				if(map[r][c]=='O') {
					// 탐색을 위해
                    q.add(new point(r,c));
                    bombtime[r][c] = 3;
                }
			}
		}
		
		// 2로 나누어지면 맵에 온통 폭탄뿐
		while(time++ <N) {
            if(time%2==0) {
                setbomb();
            }
            else {
                getbomb();
            }
        }
        
        print();
	}
	
	// 터지는 시간이랑 지난 시간이랑 같으면 폭탄 터짐
	public static void getbomb() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(bombtime[i][j] == time) {
                    bomb(i,j);
                }
            }
        }
    }
    
	// 폭탄 터트리기
    public static void bomb(int x, int y) {
        map[x][y] = '.';
        
        for(int d=0; d<4; d++) {
            int nx = x+deltas[d][0];
            int ny = y+deltas[d][1];
            
            if(isOk(nx,ny) && map[nx][ny]=='O' &&bombtime[nx][ny]!=time) {
                bombtime[nx][ny] = 0;
                map[nx][ny] = '.';
            }
        }
    }
    
    // 폭탄설치하기 , 폭탄없으면 설치하고 3초후로 값넣기
    public static void setbomb() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]=='.') {
                    map[i][j]='O';
                    bombtime[i][j] = time+3;
                }
            }
        }
    }
    
    
    public static void print() {
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                System.out.print(map[r][c]+"");
            }
            System.out.println();
        }
    }
    

    public static boolean isOk(int r, int c) {
        if(r>=0 && c>=0 && r<R && c<C) {
            return true;
        }
        return false;
    }

	static class point{
		int r,c;
		
		point(int r, int c){
			this.r=r;
			this.c=c;
		}

	}
}
