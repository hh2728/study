package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_3980_선발명단 {
	
	static int[][] position = new int[11][11];
    static boolean[] visited;
    static int max;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            
        	for(int i = 0; i < 11; i++) {
            	st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++) {
                    position[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            max = 0;
            visited = new boolean[11];
            solution(0, 0);
            System.out.println(max);
        }
    }
 
    public static void solution(int pos, int total) {
        if(pos == 11) {
            max = Math.max(max, total);
            return;
        }
 
        for(int i = 0; i < 11; i++) {
            if(!visited[i] && position[pos][i] != 0) {
                visited[i] = true;
                solution(pos + 1, total + position[pos][i]);
                visited[i] = false;
            }
        }
    }
}
