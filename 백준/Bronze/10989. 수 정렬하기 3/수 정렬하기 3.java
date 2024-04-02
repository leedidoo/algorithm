import java.io.*;

public class Main {
    public static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A=new int[N];
        
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(A,5);

        for(int i=0;i<N;i++){
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();

    }
    public static void Radix_Sort(int[] A, int max_size){
        int[] output = new int[A.length];
        int jarisu=1;
        int cnt=0;

        while(cnt != max_size){ //최대 자릿수 만큼 반복
            int[] bucket = new int [10];
            for(int i=0;i<A.length;i++){
                bucket[(A[i]/jarisu)%10]++; //일의 자릿수부터 시작
            }
            for(int i=1;i<10;i++){ // 합배열을 이용해 인덱스 계산
                bucket[i] += bucket[i-1];
            }
            for(int i=A.length-1;i>=0;i--){
                output[bucket[(A[i]/jarisu%10)]-1]=A[i]; // 현재 자릿수 기준으로 정렬
                bucket[(A[i]/jarisu)%10]--;
            }
            for(int i=0;i<A.length;i++){
                // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
                A[i]=output[i];
            }
            jarisu=jarisu*10; // 자릿수 증가시키기
            cnt++;
        }
    }
}