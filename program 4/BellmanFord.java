
import java.util.*;

public class BellmanFord {
    private static int N;
    private static int[][] graph;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes");
        N = scanner.nextInt();
        System.out.println("Enter the Weight of the matrix");
        graph = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j = 0;j<N;j++){
                graph[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the Souce Node");
        int Source = scanner.nextInt();
        
        bellmanFord(Source);
        scanner.close();
    }
    public static void bellmanFord(int souce){
        int dist[] = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[souce] = 0;

        for(int i= 0;i<N;i++){
            for(int u = 0;u<N;u++){
                for(int v = 0;v<N;v++){
                    if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                        dist[v] = dist[u]+graph[u][v];
                    }
                }
            }
        }

        for(int u=0;u<N;u++){
            for(int v=0;v<N;v++){
                if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    System.out.println("Graph has negative cycle");
                    return;
                }
            }
        }
        solutionPrint(dist);
    }
    public static void solutionPrint(int[] dist){
        System.out.println("Vertex\tDistace from souce node");
        for(int i=0;i<N;i++){
            System.out.println((i+1)+"\t\t"+dist[i]);
        }
    }
}
    
