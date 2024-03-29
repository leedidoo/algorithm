import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //배열 입력받아서 저장
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(A);

        // 확인할 target 개수 m 입력받아 저장
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 확인할 target m개를 입력받아 A에 있는지
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = A.length - 1;

            // 이진 탐색하고
            while (start <= end) {
                int midi = (start + end) / 2;
                int midV = A[midi];
                if (midV > target) { // 중앙값이 타켓보다 크면
                    end = midi - 1; // 종료 인덱스 = 중간 인덱스 -1
                } else if (midV < target) { // 중앙값이 타켓보다 작으면
                    start = midi + 1; // 시작 인덱스 = 중간 인덱스 + 1
                } else { // 찾았으면 반복문 종료
                    find = true;
                    break;
                }
            }
            //있으면 1 없으면 0 출력
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        } // for 문 종료
    }
}