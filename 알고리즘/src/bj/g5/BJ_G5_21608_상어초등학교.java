package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BJ_G5_21608_상어초등학교 {
	
	static int n;
    static int[][] map;
    static int[] order;
    static List<Integer>[] list;
    static PriorityQueue<Point> queue = new PriorityQueue<>();
    static int[] y = {1, -1, 0, 0}, x = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
 
        //교실, 자리 순서, 좋아하는 친구 리스트 넣기
        map = new int[n + 1][n + 1];
        order = new int[n*n+1];
 
        list = new ArrayList[n*n+1];
 
        for (int i = 1; i <= n*n; i++) {
            list[i] = new ArrayList<>();
        }
        
        // 자리배치 순서와 좋아하는 친구 리스트 저장
        for (int i = 1; i <= n * n; i++) {
            String[] s = br.readLine().split(" ");
            order[i] = Integer.parseInt(s[0]);
            for (int j = 1; j < 5; j++) {
                list[Integer.parseInt(s[0])].add(Integer.parseInt(s[j]));
            }
        }
 
        //자리배치
        for (int i = 1; i <= n * n; i++) {
            solve(order[i]);
            queue.clear();
        }
 
        //만족도 
        int result=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                result += getPrice(i,j);
            }
        }
        System.out.println(result);
 
    }
 
    private static int getPrice(int a, int b){
    	//학생번호 저장해서
        int num = map[a][b];
 
        int ny, nx, likeCount=0;
        
        //리스트에서 한명씩 붙잡고 사방탐색으로 확인해보기, 내 근처에 친구가있는가 있으면 like카운트 올림
        // 있을때마다 카운트 올려서 규칙에 맞게   값 return 
        for(Integer now : list[num]){
            for (int i = 0; i < 4; i++) {
                ny = a + y[i];
                nx = b + x[i];
                if (ny >= 1 && ny <= n && nx >= 1 && nx <= n) {
                    if(map[ny][nx]==now){
                        likeCount++;
                    }
                }
            }
        }
        if(likeCount==0){
            return 0;
        }
        else if(likeCount==1){
            return 1;
        }
        else if(likeCount==2){
            return 10;
        }
        else if(likeCount==3){
            return 100;
        }
        else{
            return 1000;
        }
    }
 
    private static void solve(int num) {
 
        int ny, nx;
        int nearCount, likeCount;
        
        //자리배치 돌면서 해보자
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nearCount = 0;
                likeCount = 0;
                
                //이미 누가 앉아있으면 패스
                if (map[i][j] != 0) {
                    continue;
                }
                
                // 사방탐색
                for (int k = 0; k < 4; k++) {
                    ny = i + y[k];
                    nx = j + x[k];
                    
                    // 지금 자리배치 받는 친구가 좋아하는 친구가 있으면 like 올리기, 빈자리면 near 올리기
                    if (ny >= 1 && ny <= n && nx >= 1 && nx <= n) {
                        for (Integer now : list[num]) {
                            if (now == map[ny][nx]) {
                                likeCount++;
                            }
                        }
                        if (map[ny][nx] == 0) {
                            nearCount++;
                        }
                    }
                }
                
                //pq에 넣으면 자동으로 정렬
                queue.add(new Point(i, j, nearCount, likeCount));
            }
        }
 
        Point poll = queue.poll();
        map[poll.y][poll.x] = num;
    }
    
    static class Point implements Comparable<Point> {
        int y;
        int x;
        int nearCount;
        int likeCount;
     
        public Point(int y, int x, int nearCount, int likeCount) {
            this.y = y;
            this.x = x;
            this.nearCount = nearCount;
            this.likeCount = likeCount;
        }
     
        @Override
        public int compareTo(Point o2) {
        	//주위에 좋아하는 친구 수
            if (this.likeCount > o2.likeCount) {
                return -1;
            } else if (this.likeCount < o2.likeCount) {
                return 1;
            } else {
            	//주위 빈자리 수
                if (this.nearCount > o2.nearCount) {
                    return -1;
                } else if (this.nearCount < o2.nearCount) {
                    return 1;
                } else {
                	//y축 작을 수록
                    if (this.y > o2.y) {
                        return 1;
                    } else if (this.y < o2.y) {
                        return -1;
                    } else {
                    	//x축 작을 수록
                        if (this.x > o2.x) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        }
    }
	
}
