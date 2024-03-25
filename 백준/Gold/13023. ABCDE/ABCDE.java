import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited; // 방문 여부
    static ArrayList<Integer>[] A; //DFS구현을 위한 ArrayList
    static boolean arrive; 

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드 수
        int M =Integer.parseInt(st.nextToken()); //에지 수
        arrive = false;
        A=new ArrayList[N];
        visited = new boolean[N];
        for(int i =0;i<N;i++){ // 인접 리스트 초기화
            A[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){ //인접 리스트 데이터 입력 받아서 저장
            st=new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E); //방향이 없어서 양쪽으로 저장
            A[E].add(S);
        }
        for(int i=0;i<N;i++){
            DFS(i,1); // 깊이는 1부터 시작
            if(arrive)
                break;
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");// 5의 깊이가 없다면 0출력

    }
    public static void DFS(int now,int depth){
        if(depth==5||arrive){ // 깊이가 5가 되면 프로그램 종료
            arrive =true;
            return;
        }
        visited[now]=true; //방문 배열에 현재 노드 방문 표시하고
        for(int i :A[now]){  //현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS실행
            if(!visited[i]){
                DFS(i,depth+1); // 재귀 호출될 때마다 깊이 1씩 증가
            }
        }
        visited[now]=false;
    }
}