import java.util.*;

public class BellmanFord1{
    public static int N;
    public static int[][] graph;
    public static void main(String [] args){
        System.out.println("Enter the number of vertices");
        Scanner scanner  =  new Scanner(System.in);
        N = scanner.nextInt();
        System.out.println("Enter the source vertex");
        int src = scanner.nextInt();
        System.out.println("Enter the Weight Matrix of Graph");
        graph = new int[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                graph[i][j] = scanner.nextInt();
        bellmanford(src-1);
    }
    public static void bellmanford(int source){
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for(int i = 0;i<N;i++){
            for(int u=0;u<N;u++){
                for(int v=0;v<N;v++){
                    if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                        dist[v] = graph[u][v] + dist[u];
                    }
                }
            }
            for(int u = 0;u<N;u++){
                for(int v=0;v<N;v++){
                    if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                        System.out.println("Graph has a negative cycle");
                        return;
                    }
                }
            }
        }
        printsolution(dist);
    }
    public static void printsolution(int [] dist){
        System.out.println("vertex \t Distance from source");
        for(int i=0;i<N;i++){
            System.out.println((i+1)+"\t\t"+dist[i]);
        }
    }
}