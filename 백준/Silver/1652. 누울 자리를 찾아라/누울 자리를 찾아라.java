import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        int horizontal = 0;
        int vertical = 0;

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            int check_h = 0, check_v = 0; // 연속된 빈칸을 카운트하기 위한 변수
            for (int j = 0; j < N; j++) {

                // 가로 -> .이 연속되고, X를 만나거나 벽을 만났는데 연속된 빈칸이 2개 이상 연속으로 있으면 horizontal을 증가시킴
                if (map[i][j] == '.') check_h++;
                if (map[i][j] == 'X' || (j == N - 1)) {
                    if (check_h >= 2) horizontal++;
                    check_h = 0;
                }

                // 세로 -> .이 연속되고, X를 만나거나 벽을 만났는데 연속된 빈칸이 2개 이상 연속으로 있으면 vertical을 증가시킴
                if (map[j][i] == '.') check_v++;
                if (map[j][i] == 'X' || (j == N - 1)) {
                    if (check_v >= 2) vertical++;
                    check_v = 0;
                }
            }
        }

        System.out.println(horizontal + " " + vertical);

    }
}