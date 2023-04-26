package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_17266_어두운굴다리 {
	
	static int N,M;
	static int[] arr;
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); //굴다리의 길이
        M = Integer.parseInt(br.readLine()); //설치할 가로수 갯수.
        
        arr = new int[M];// 가로등이 설치된 지점 입력 받기
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int result = 0;

        while(left <= right) {
            
        	int mid = (left + right) / 2;
            
        	// mid 높이로 모든 지점을 비출 수 있다면 result 갱신 후 높이를 줄여 재탐색
            if(possible(mid)) {
                result = mid;
                right = mid - 1;
            }
            
            // 모든 지점을 비출 수 없다면 높이를 높여 재탐색
            else
                left = mid + 1;
        }
        
        System.out.println(result);
    }

    static boolean possible(int target) {
        //System.out.println("target "+target);
    	int prev = 0; // 이전 가로등이 비춘 마지막 지점, 0 지점부터 모두 비춰주어야 하기 때문에 0부터 시작

        for(int i = 0; i < arr.length; i++) {
            /*
             * 가로등이 있는 지점에서 비출 수 있는 높이(target)을 빼면 가로등이 비추는 최소값을 알 수가 있습니다.
             * 이 최소값을 기준으로 가로등이 빈곳없이 다 비추는지 조건을 확인합니다.
             */
            if(arr[i] - target <= prev) {
            	//System.out.println(arr[i] + " "+ target + " "+ prev);
                prev = arr[i] + target;
                //System.out.println(" - "+prev);
                // Arr[i] + target을 하게되면 가로등이 다시 비춰야만 하는 최소값을 리턴할 수 있습니다.
            } else { return false; }
            /*
             * 가로등의 시작 지점에서 높이(target)만큼 비춘 곳이
             * 이전 가로등이 마지막으로 비춘 곳에 도달하지 못하면 모든 지점을 비출수 없습니다.
             */
        }
        /*
         * 마지막 지점도 가로등이 비출 수 있는지 확인해야 하기 때문에
         * 마지막 가로등이 비출 수 있는 끝 지점에서 굴다리의 끝 좌표를 뺐을 때 0보다 작거나 같아야 마지막 지점도 비춰집니다.
         */
        //System.out.println("prev "+ prev);
        return N - prev <= 0;
    }

}
