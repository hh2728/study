package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_모의SW_2383_점심식사시간 {
	
	static int m, min;
	static Stairs[] stairs;
	static boolean[] choice;
	static int[][] distance;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<Point> people = new ArrayList<>();
		
		for(int t=1; t<=T; t++) {
			stairs = new Stairs[2];
            min = Integer.MAX_VALUE;
			people.clear();
			int idx =0;
			
			int N = Integer.parseInt(br.readLine());
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					int temp =  Integer.parseInt(st.nextToken());
					if( temp == 1) {
						people.add(new Point(r,c));
					}else if ( temp > 1) {
						stairs[idx++] = new Stairs(r, c, temp);
					}
				}
			}
			
			m = people.size();
			choice = new boolean[m];
			distance = new int[2][m];
			
			for (int i = 0; i < 2; i++) {
                for (int j = 0; j < m; j++) {
                    distance[i][j] = getDist(stairs[i].index, people.get(j));
                }
            }
            choice(0);
            System.out.println("#" + t + " " + min);
			
			
		}

	}
	
	private static void choice(int depth) {
		if(m == depth) {
			solution(getInfo());
			return;
		}
		
		choice[depth] = true;
		choice(depth + 1);
		choice[depth] = false;
		choice(depth + 1);
	}
	
	public static void solution(int[] dst) {
		boolean[] check = new boolean[m];
		int count = 0;
		
		stairs[0].reset();
		stairs[1].reset();
		
		ArrayList<Integer> wait = new ArrayList<>();
		
		while(++count < min) {
			wait.clear();
			for(int i=0; i<m; i++) {
				if(check[i]) continue;
				int s_type = (choice[i]) ? 0 : 1;
				
				if(dst[i] == 0) wait.add(i);
				else {
					if(--dst[i] < (-1)*stairs[s_type].value) {
						stairs[s_type].out();
						check[i] = true;
					}
				}
			}
			for(Integer i : wait) {
				int s = (choice[i]) ? 0 : 1;
                if (stairs[s].status) { // 내려갈 수 있으면 내려감
                    dst[i]--;
                    stairs[s].down();
                }
			}
			if(isFinish(check)) min = count;
		}
		
	}
	static int getDist(Point a, Point b) { 
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }
	
	static int[] getInfo() {
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = (choice[i]) ? distance[0][i] : distance[1][i];
        }
        return result;
    }
	
	static boolean isFinish(boolean[] check) {
        for (int i = 0; i < m; i++) {
            if (!check[i]) return false;
        }
        return true;
    }
	
	public static class Point{
		int r,c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Stairs {
	    Point index;
	    int value, count;
	    boolean status;

	    public Stairs(int r, int c, int value) {
	        this.index = new Point(r, c);
	        this.value = value;
	        this.count = 0;
	        this.status = true;
	    }

	    public void down() {
	        if (++count == 3) this.status = false; // 꽉차면 false 처리
	    }

	    public void reset() {
	        this.count = 0;
	        this.status = true;
	    }

	    public void out() {
	        count--;
	        this.status = true;
	    }
	}

}
