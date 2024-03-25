import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    //재귀함수를 이용한 DFS
    static void DFS(int num, int jarisu){
        //입력받은 N 자리 수의 신기한 소수를 출력하고
        //N-자리수가 아니면 재귀함수를 통해 N-자리수의 신기한 소수만 출력한다.
        if(jarisu == N){
            if(isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        for(int i=1;i<10;i++){
            //소수이려면 일의 자리가 짝수이면 안됨
            if(i%2==0){
                continue;
            }
            if(isPrime(num*10+i)){
                DFS(num*10+i,jarisu+1);
            }
        }
    }
    // 소수 판별
    // 2부터 현재 수/2까지 반복해서 현재수가 i로 나누어떨어지면 소수가 아니고 나누어 덜어지지 않으면 소수이다.
    static boolean isPrime(int number){
        for(int i=2;i<=number/2;i++)
            if(number%i==0)
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        //한 자리수 소수는 2,4,5,7 밖에 없고, 이어서 자리수를 늘리면서 신기한 소수 찾을거임
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

}