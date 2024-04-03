import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A=new int[N];

        int start = 0;
        int end = 0;

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken()); //A  배열 저장하기
            if(start<A[i]) start=A[i]; //시작 인덱스 저장 (A 배열 중 최댓값)
            end=end+A[i]; //종료 인텍스 저장(A 배열의 총합)
        }
        while(start<=end){
            int middle = (start+end)/2;
            int sum = 0;
            int cnt = 0;
            for(int i=0;i<N;i++){
                if(sum+A[i]>middle){
                    cnt++;
                    sum=0;
                }
                sum= sum+A[i]; // 현재 블루레이에 저장할 수  없어 새로운 블루레이로 교체
            }
            if(sum != 0) cnt++; // 탐색 후 sum 이 0이 아니면 블루레이가 1개 더 필요
            if(cnt>M) start = middle+1;
            else end = middle-1;
        }
        System.out.println(start);
    }
}