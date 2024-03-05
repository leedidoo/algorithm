import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int [N];

        for(int i =0; i<N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num =1;  //오름차순 수
        boolean result =true;

        for(int i=0;i< A.length;i++){
            int su = A[i]; //현재 수열의 수
            if(su>=num){ //현재 수열의 값 >= 오름차순 자연수 : 값이 같아질 때까지 push()
                while(su>=num){ //push()
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else{ //현재 수열의 값 < 오름차순 자연수 : pop()을 수행해 수열 원소를 꺼냄
                int n = stack.pop(); //스택의 가장 위의 수가 만들어야하는 수열의 수보다 크면 수열을 출력할 수 없음
                if(n>su){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb);
    }
}