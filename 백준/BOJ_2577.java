package self_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        int [] arr = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int multiply = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());

        String str = Integer.toString(multiply);

        for(int i=0; i<str.length();i++){
            for(int j=0;j<10;j++){
                if(str.charAt(i)-'0' == j){
                    ++arr[j];
                    break;
                }
            }
        }

        for( int i=0;i<10;i++){
            System.out.println(arr[i]);
        }

    }
}