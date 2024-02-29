import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        long good[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i <N ; i++){
            good[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(good);

        for(int k = 0;k<N;k++){
            long find = good[k];
            int i = 0;
            int j = N-1;

            while(i<j){
                if(good[i]+good[j]==find){
                    if(i != k && j != k){
                        result++;
                        break;
                    } else if (i==k) {
                        i++;
                    } else if (j==k){
                        j--;
                    }
                } else if (good[i]+good[j]<find) {
                    i++;
                }else{
                    j--;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}