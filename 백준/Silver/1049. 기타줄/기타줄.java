import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, pack = Integer.MAX_VALUE, piece = Integer.MAX_VALUE, answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pack = Math.min(pack, Integer.parseInt(st.nextToken()));
			piece = Math.min(piece, Integer.parseInt(st.nextToken()));
		}

		if (piece * 6 <= pack)
			answer = piece * N;
		else {
			answer = (N / 6) * pack;
			answer += Math.min(N % 6 * piece, pack);
		}
		System.out.println(answer);
	}
}