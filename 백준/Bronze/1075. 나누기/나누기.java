import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int res = (N/100)*100;

        while(true){
            if(res%F == 0) {
                break;
            }
            res++;
        }
        System.out.printf("%02d",res%100);
    }
}