import java.util.ArrayList;
import java.util.PriorityQueue;

public class StudyOfGraphs {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
       public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }
    }
    /*
    for dijkistra:
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int node ,int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;    //comparioson on basis of distance //ascending order
        }
    }
     */
   //  study of graphs
      /*
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>(); //new arraylist at every index of array
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));

    }

    public static void createGraphforDFS(ArrayList<DFS.Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<DFS.Edge>(); //new arraylist at every index of array
        }
        graph[0].add(new DFS.Edge(0, 1));
        graph[0].add(new DFS.Edge(0, 2));

        graph[1].add(new DFS.Edge(1, 0));
        graph[1].add(new DFS.Edge(1, 3));

        graph[2].add(new DFS.Edge(2, 0));
        graph[2].add(new DFS.Edge(2, 4));

        graph[3].add(new DFS.Edge(3, 1));
        graph[3].add(new DFS.Edge(3, 4));
        graph[3].add(new DFS.Edge(3, 5));

        graph[4].add(new DFS.Edge(4, 2));
        graph[4].add(new DFS.Edge(4, 3));
        graph[4].add(new DFS.Edge(4, 3));

        graph[5].add(new DFS.Edge(5, 3));
        graph[5].add(new DFS.Edge(5, 4));
        graph[5].add(new DFS.Edge(5, 6));

        graph[6].add(new DFS.Edge(6,5));
    }

    public static boolean isCyclicDirected(ArrayList<Edge>[] graph, boolean vis[], int curr, boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0;i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true; //cycle
            } else if(!vis[e.dest]){
                if(isCyclicDirected(graph , vis , e.dest , rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;

    }

    public static void dfs(ArrayList<DFS.Edge> graph[], boolean vis[] , int curr){
        System.out.print(curr+" ");  //we initailize it on first hand so we use it here
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            DFS.Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) { //if neighbour is not visited
                dfs(graph ,vis, e.dest ); //call dfs again for neighbour  considering it as a new start
            }
        }
    }

    public static void printAllPaths(ArrayList<DFS.Edge> graph[], boolean[] viz, int curr , String path, int tar ) {
        //time complexity O(V^V)
        //base case
         if (curr == tar) {
            System.out.println(path);
            return;
         }
            for (int i = 0; i < graph[curr].size(); i++) {
            DFS.Edge e = graph[curr].get(i);
            if (!viz[e.dest]) { //destintion is unvisited
                viz[curr] = true;
                printAllPaths(graph, viz, e.dest,path + e.dest, tar); //update curr and path value and then recall
                viz[curr] = false; //make unvisited again
            }
         }
    }

    public static void bfs(ArrayList<Edge> graph[] , int V , boolean[] vis , int start){ //time comple O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(start); //starting point;
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false) {
                System.out.print(curr + " ");  //step 1
                vis[curr] = true; //step 2
                //step 3 below
                for(int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void dijkstra(ArrayList<Edge> graph[] , int src , int V){       //time compextiy = O(E+ElogV)  elogv is becuz of priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;    //code for infinity
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove(); //shortest distance
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i=0; i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.weight < dist[v]){
                        dist[v] = dist[u] + e.weight; //relaxtion
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void createGraphforDijkistra(ArrayList<dijkistra.Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<dijkistra.Edge>(); //new arraylist at every index of array
        }
        graph[0].add(new dijkistra.Edge(0,2,2));
        graph[0].add(new dijkistra.Edge(0,1,4));

        graph[1].add(new dijkistra.Edge(1,3,7));
        graph[1].add(new dijkistra.Edge(1,2,1));

        graph[2].add(new dijkistra.Edge(2,4,3));

        graph[3].add(new dijkistra.Edge(3,5,1));


        graph[4].add(new dijkistra.Edge(4,3,2));
        graph[4].add(new dijkistra.Edge(4,5,5));

    }

     */
    public static void main(String[] args) {

        /* study of graphs
        //considering a new example with 4 vvertices , so making graph accordingly
        //Adjacency List O(1) = constant time complexity
        int V = 4; //no. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        int[] o={1,2,3,4,6,7,8};

        for(int i=0 ; i<V ; i++) {
            boolean isCycle = isCyclicDirected(graph,vis, 0, rec);
            if (!vis[i]) {
                if(isCycle) {
                    System.out.println(isCycle);
                    break;
                };
                }
                //time complexity O(e+v)
            }

         */
        /*

         for dfs:
         public static void main(String[] args) {
            /*
             *       1 --- 3
             *      /      | \
             *     0       |  5 -- 6
             *     \       |/
             *      2 ---- 4
             *
        int V = 7; //no. of vertices
        ArrayList<DFS.Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean viz[] = new boolean[V];
//            for(int i=0;i<V ; i++){
//                if(viz[i] == false){
//                dfs(graph,viz,0);
//                }
//            }
        int src = 0 , tar = 5;
        printAllPaths(graph , viz , src , "0" , tar);
    }
         */
        /*

        for bfs:

         public static void main(String[] args) {
        /*
        *       1 --- 3
        *      /      | \
        *     0       |  5 -- 6
        *     \       |/
        *      2 ---- 4
        *
        int V = 7; //no. of vertices
        ArrayList<BFS.Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean vis[] = new boolean[V];
        for(int i=0;i< vis.length;i++){
            if(!vis[i]){ //which will be obviously false for thee first one
                bfs(graph ,V ,vis,i);
            }
        }
    }
         */

        /*
        for dijkistra:
        *   public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph , 0 , V);


    }
        * */
        }

    public static class primsalgo {
        static class Edge{
            int src;
            int dest;
            int weight;
            public Edge(int s, int d, int wt){
                this.src = s;
                this.dest = d;
                this.weight = wt;
            }
        }
        public static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0;i<graph.length;i++){
                graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0,1,10));
            graph[0].add(new Edge(0,2,15));
            graph[0].add(new Edge(0,3,30));

            graph[1].add(new Edge(1,0,10));
            graph[1].add(new Edge(1,3,40));

            graph[2].add(new Edge(2,0,15));
            graph[2].add(new Edge(2,3,50));

            graph[3].add(new Edge(3,1,40));
            graph[3].add(new Edge(3,2,50));

        }

        public static class Pair implements Comparable<Pair>{
            int node;
            int cost;

            public Pair(int node, int cost){
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compareTo(Pair p2){
                return this.cost - p2.cost;
            }
        }

        public static void primsALgo(ArrayList<Edge> graph[], int V){
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(); //non-mst set (node, cost)
            boolean vis[] = new boolean[V];   //mst set
            pq.add(new Pair(0,0));
            int mstCost = 0;

            while(!pq.isEmpty()){
                Pair curr = pq.remove() ; //auto gets one with least value
                if (!vis[curr.node]) {
                    vis[curr.node] = true;
                    mstCost = mstCost + curr.cost ;

                    for(int i=0; i<graph[curr.node].size(); i++){
                        Edge e = graph[curr.node].get(i);
                        if(!vis[e.dest]){
                            pq.add(new Pair(e.dest , e.weight));
                        }
                    }
                }
            }
            System.out.println("minimum cost of mst is " + mstCost);
        }

        public static void main(String[] args) {
            int V=4;
            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            primsALgo(graph , V);
        }

    }
}

