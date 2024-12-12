package self_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt=0;
        for( int i=0;i<8;i++){
            String chess = br.readLine();
            for(int j=0;j<8;j++){
                if(chess.charAt(j)=='F' && (i+j)%2==0) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
