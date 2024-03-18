import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine()); // 사람의 수
        int[]A = new int[N]; // 돈을 인출하는 데 걸리는 시간을 저장하는 배열 A
        int[]S = new int[N]; // A의 합 배열
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<N;i++){
            A[i]=Integer.parseInt(st.nextToken()); // A배열 입력받아서 저장
        }

        for(int i=1;i<N;i++){ // 삽입 정렬
            int insert_point=i;
            int insert_value = A[i];
            for(int j=i-1;j>=0;j--){ //j가 i-1부터 0까지 뒤에서부터 반복하면서 현재 위치에서 삽입 위치 찾기
                if(A[j]<A[i]){
                    insert_point =j+1;
                    break;
                }
                if(j==0){
                    insert_point=0;
                }
            }
            for(int j=i;j>insert_point;j--){ 
                A[j]=A[j-1]; //삽입을 위해 삽입 위치에서 i까지 데이터를 한 칸씩 뒤로 밀기
            }
            A[insert_point] = insert_value; // 현재 위치에 데이터 삽입
        }
        S[0]=A[0];
        for(int i=1;i<N;i++){ //합 배열 만드는 반복문
            S[i]=S[i-1]+A[i];
        }
        int sum =0;
        for(int i=0;i<N;i++){
            sum = sum +S[i];
        }
        System.out.println(sum);
    }
}