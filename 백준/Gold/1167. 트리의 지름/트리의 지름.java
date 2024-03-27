import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 트리의 지름 구하기
    // 트리의 지름은 트리를 구성하는 노드 중 두 노드 사이의 거리가 가장 긴 것
    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A=new ArrayList[N+1];

        for(int i=1; i<=N;i++){
            A[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            while(true){
                int E = Integer.parseInt(st.nextToken());
                if(E==-1)
                    break;
                int V = Integer.parseInt(st.nextToken());
                A[S].add(new Edge(E,V));
            }
        }
        distance = new int [N+1];
        visited = new boolean[N+1];
        BFS(1);
        int Max =1;
        for(int i=2;i<=N;i++){ //***** distance배열에서 가장 큰 값으로 다시 시작점 설정 *****
            if(distance[Max]<distance[i]){ 
                Max=i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max); // 새로운 시작접으로 실행
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index]=true;
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            for(Edge i: A[nowNode]){
                int e =i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e]=true;
                    queue.add(e);
                    distance[e]=distance[nowNode]+v;
                }
            }
        }
    }
}
class Edge{
    int e;
    int value;
    public Edge(int e,int value){
        this.e=e;
        this.value=value;
    }
}