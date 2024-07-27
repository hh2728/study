import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            int sum;

            if(map.get(temp) != null){
                sum = map.get(temp);
            }else {
                sum = 0;
            }

            min = Math.min(min,temp);
            max = Math.max(max,temp);

            list.add(temp);
            map.put(temp,sum+1);
            total += temp;
        }

        Collections.sort(list);

        List<Integer> sortList = new ArrayList<>(map.keySet());

        sortList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Objects.equals(map.get(o1), map.get(o2)) ?  o1-o2 : map.get(o2) - map.get(o1);
            }
        });


        int result = sortList.get(0);

        if(sortList.size() > 1 && map.get(sortList.get(1)) == map.get(result)){
            result = sortList.get(1);
        }

        System.out.println((int)Math.round((double)total/N ) );
        System.out.println(list.get( (N/2) ));
        System.out.println(result);
        System.out.println(Math.abs(max-min));
    }
}
