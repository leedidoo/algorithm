import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> myQueue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            myQueue.add(i);
        }
        while(myQueue.size()>1){
            myQueue.poll(); // 맨위 카드 버림
            myQueue.add(myQueue.poll()); // 그 다음 카드 add
        }
        System.out.println(myQueue.poll()); //마지막 남은 카드 출력
    }
}