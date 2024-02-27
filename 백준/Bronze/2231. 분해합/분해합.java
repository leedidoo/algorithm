import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result =0;

        for (int i=0; i<N; i++){
            int num = i;
            int sum = 0;

            // 각 자리수를 더해줌
            while(num !=0 ){
                sum += num % 10;
                num /= 10 ;
            }

            // 각 자리수의 합과 현재 숫자의 합이 N 이되는 값을 result에 저장
            if(sum + i == N){
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}