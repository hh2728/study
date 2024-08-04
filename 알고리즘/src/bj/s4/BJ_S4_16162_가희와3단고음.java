import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i= 0 ; i <N; i++){
            int temp = Integer.parseInt(st.nextToken());

            if(temp == start){
                result++;
                start = start+number;
            }
        }
      
        System.out.println(result);
    }
}
