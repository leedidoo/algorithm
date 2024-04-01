import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5]; // 서로 다른 5개의 숫자를 담을 배열
        int cnt=0;
        int num=0; // 적어도 대부분의 배수를 저장할 변수

        for(int i=0;i<5;i++){ // 5개 숫자 입력 받아  arr 배열에 저장
            arr[i]=Integer.parseInt(st.nextToken());
        }
        while(true){
            num++; //숫자를 증가시키면서 cnt가 3개가 되면
            for(int i=0;i<5;i++){
                if(num%arr[i]==0) cnt++;
            }
            if(cnt>=3) break;
            cnt=0;
        }
        System.out.println(num);
    }
}