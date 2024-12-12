package boj_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10872 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer=1;
		
		for(int i=N;i>1;i--) {

			answer *= i;
			
		}
		System.out.println(answer);

	}

}
