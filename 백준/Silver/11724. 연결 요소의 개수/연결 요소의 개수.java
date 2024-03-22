import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[]A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //노드수 n 에지수 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited=new boolean[n+1];

        // 인접 리스트의 각 ArrayList 초기화
        for(int i=1;i<n+1;i++){
            A[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s); // 방향이 없는 그래프이기 때문에 양쪽에 에지를 더해줌
        }

        int cnt =0; // DFS개수 구하기 위한 변수
        for(int i=1;i<n+1;i++){
            if(!visited[i]){ // 방문하지 않은 노드가 없을 때까지 반복하기
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v]=true;
        for(int i:A[v]){
            if(visited[i]==false){
                DFS(i);
            }
        }
    }
}