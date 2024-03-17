import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int []N = new int[str.length()];

        for(int i = 0;i<str.length();i++){
            N[i]=Integer.parseInt(str.substring(i,i+1));
        }
        for(int i=0;i<str.length();i++){
            int Max=i;
            for(int j=i+1;j<str.length();j++){
                if(N[j]>N[Max])
                    Max=j;
            }
            if(N[i]<N[Max]){
                int temp =N[i];
                N[i]=N[Max];
                N[Max]=temp;
            }
        }
        for(int i=0;i<str.length();i++){
            System.out.print(N[i]);
        }
    }
}