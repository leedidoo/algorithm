import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String example = br.readLine();
		String[] str = example.split("-");

		for (int i = 0; i < str.length; i++) {
			int tmp = mySum(str[i]);
			if (i == 0)
				answer = answer + tmp;
			else
				answer = answer - tmp;
		}
		System.out.println(answer);
	}

	static int mySum(String a) {
		int sum = 0;
		String[] tmp = a.split("[+]"); //+는 정규 표현식에서 1회 이상 반복을 의미하기 때문에 [+]로 사용
		for (int i = 0; i < tmp.length; i++) {
			sum += Integer.parseInt(tmp[i]);
		}
		return sum;
	}
}