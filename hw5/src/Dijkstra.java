import java.util.*;
import java.lang.Math;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Iterator;


public class Dijkstra {

    // Keep a fast index to nodes in the map
    private Map<String, Vertex> vertexNames;

    /**
     * Construct an empty Dijkstra with a map. The map's key is the name of a vertex
     * and the map's value is the vertex object.
     */
    public Dijkstra() {
        vertexNames = new HashMap<String, Vertex>();
    }

    public Map<String, Vertex> getVertexMap(){
        return vertexNames;
    }

    public void setVertexMap(Map<String, Vertex> vertexNames){
        this.vertexNames = vertexNames;
    }

    /**
     * Adds a vertex to the dijkstra. Throws IllegalArgumentException if two vertices
     * with the same name are added.
     *
     * @param v
     *          (Vertex) vertex to be added to the dijkstra
     */
    public void addVertex(Vertex v) {
        if (vertexNames.containsKey(v.name))
            throw new IllegalArgumentException("Cannot create new vertex with existing name.");
        vertexNames.put(v.name, v);
    }

    /**
     * Gets a collection of all the vertices in the dijkstra
     *
     * @return (Collection<Vertex>) collection of all the vertices in the dijkstra
     */
    public Collection<Vertex> getVertices() {
        return vertexNames.values();
    }

    /**
     * Gets the vertex object with the given name
     *
     * @param name
     *          (String) name of the vertex object requested
     * @return (Vertex) vertex object associated with the name
     */
    public Vertex getVertex(String name) {
        return vertexNames.get(name);
    }

    /**
     * Adds a directed edge from vertex u to vertex v
     *
     * @param nameU
     *          (String) name of vertex u
     * @param nameV
     *          (String) name of vertex v
     * @param cost
     *          (double) cost of the edge between vertex u and v
     */
    public void addEdge(String nameU, String nameV, Double cost) {
        if (!vertexNames.containsKey(nameU))
            throw new IllegalArgumentException(nameU + " does not exist. Cannot create edge.");
        if (!vertexNames.containsKey(nameV))
            throw new IllegalArgumentException(nameV + " does not exist. Cannot create edge.");
        Vertex sourceVertex = vertexNames.get(nameU);
        Vertex targetVertex = vertexNames.get(nameV);
        Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
        sourceVertex.addEdge(newEdge);
    }

    /**
     * Adds an undirected edge between vertex u and vertex v by adding a directed
     * edge from u to v, then a directed edge from v to u
     *
     * @param nameU
     *          (String) name of vertex u
     * @param nameV
     *          (String) name of vertex v
     * @param cost
     *          (double) cost of the edge between vertex u and v
     */
    public void addUndirectedEdge(String nameU, String nameV, double cost) {
        addEdge(nameU, nameV, cost);
        addEdge(nameV, nameU, cost);
    }

    // STUDENT CODE STARTS HERE

    /**
     * Computes the euclidean distance between two points as described by their
     * coordinates
     *
     * @param ux
     *          (double) x coordinate of point u
     * @param uy
     *          (double) y coordinate of point u
     * @param vx
     *          (double) x coordinate of point v
     * @param vy
     *          (double) y coordinate of point v
     * @return (double) distance between the two points
     */
    public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {
        //todo
        double x2 = (ux-vx)*(ux-vx);
        double y2 = (uy-vy)*(uy-vy);
        double result = Math.sqrt(x2+y2);
        return result;
    }

    /**
     * Calculates the euclidean distance for all edges in the map using the
     * computeEuclideanCost method.
     */
    public void computeAllEuclideanDistances() {
        // TODO
        Collection<Vertex> set = vertexNames.values();
        Iterator<Vertex> itr = set.iterator();
        //loop through all the vertexes in the map
        while(itr.hasNext()) {
            Vertex current = itr.next();
            List<Edge> edgeList = current.adjacentEdges;
            Iterator<Edge> itr1 = edgeList.iterator();

            //for a given vertex, loop through all its adjacentEdges;
            while(itr1.hasNext()) {
                Edge e = itr1.next();
                if(e.source.equals(current)) {
                    //current is source
                    Vertex x = current;
                    Vertex y = e.target;
                    e.distance = computeEuclideanDistance(x.x, x.y, y.x, y.y);

                } else {
                    //e.target == current
                    //current is target
                    Vertex x = e.source;
                    Vertex y = current;
                    e.distance = computeEuclideanDistance(x.x, x.y, y.x, y.y);

                }
            }


        }
    }

    /**
     * Dijkstra's Algorithm.
     *
     * @param s
     *          (String) starting city name
     */
    public void doDijkstra(String s) {
        // TODO
        ArrayList<Vertex> vertices = new ArrayList<>();
        Collection<Vertex> allVertex = getVertices();
        Iterator<Vertex> itr = allVertex.iterator();
        int unvisited = 0;

        //ArrayList vertices contains all the vertices in this map. Initialize them.
        while(itr.hasNext()) {
            Vertex v = itr.next();
            v.distance = Double.POSITIVE_INFINITY;
            v.prev = null;
            v.known = false;
            vertices.add(v);
            unvisited = unvisited+1;
        }

        //find the start point
        Vertex start = getVertex(s);
        start.distance = 0;
        start.known=true;
        start.prev = null;
        unvisited = unvisited-1;

        //begin to loop and update all the information
        while(unvisited>0) {
            List<Edge> adj =  start.adjacentEdges;
            Iterator<Edge> itrEdge = adj.iterator();
            //update dv and pv
            while(itrEdge.hasNext()) {
                //update this adjacent vertex's distance and prev
                Edge adjEdge = itrEdge.next();
                double new_distance = adjEdge.distance + start.distance;
                if(adjEdge.source.equals(start)) {
                    //update the target vertex
                    Vertex toBeUpdate = adjEdge.target;
                    if(toBeUpdate.distance > new_distance) {
                        toBeUpdate.distance = new_distance;
                        toBeUpdate.prev = start;
                    }
                } else {
                    //update the source vertex
                    Vertex toBeUpdate = adjEdge.source;
                    if(toBeUpdate.distance > new_distance) {
                        toBeUpdate.distance = new_distance;
                        toBeUpdate.prev = start;
                    }
                }

            }

            //choose the next start point
            double minDistance = Double.POSITIVE_INFINITY;
            Vertex minVertex = null;
            Iterator<Vertex> itr2 = allVertex.iterator();

            //find the min-distance in the unvisited list
            while(itr2.hasNext()) {
                Vertex p = itr2.next();
                if(p.known==false && p.distance<minDistance) {
                    minDistance = p.distance;
                    minVertex = p;
                }
            }

            //new start
            start = minVertex;
            start.known = true;
            unvisited = unvisited-1;

        }

    }






    /**
     * Returns a list of edges for a path from city s to city t. This will be the
     * shortest path from s to t as prescribed by Dijkstra's algorithm
     *
     * @param s
     *          (String) starting city name
     * @param t
     *          (String) ending city name
     * @return (List<Edge>) list of edges from s to t
     */
    public List<Edge> getDijkstraPath(String s, String t) {
        if(s.equals(t)) {
            Vertex a = getVertex(s);
            Vertex b = getVertex(t);
            Edge e3 = new Edge(a, b, 0);
            ArrayList<Edge> r = new ArrayList<>();
            r.add(e3);
            return r;
        }

        Vertex sVertex = getVertex(s);
        List<Edge> sEdge = sVertex.adjacentEdges;
        Iterator<Edge> itrrr  = sEdge.iterator();
        while(itrrr.hasNext()) {
            Edge o = itrrr.next();
            Vertex tttarget = getVertex(t);
            if(o.target.equals(tttarget)) {
                ArrayList<Edge> r1 = new ArrayList<>();
                r1.add(o);
                return r1;
            }
        }

        LinkedList<Vertex> path = new LinkedList<>();
        doDijkstra(s);
        Vertex target = getVertex(t);
        while(target.prev != null) {
            path.add(target);
            target = target.prev;
        }
        ArrayList<Vertex> path2 = new ArrayList<>();

        while(path.size()!=0) {
            Vertex v = path.pop();
            path2.add(v);
        }

        int n = path2.size();

        ArrayList<Edge> result = new ArrayList<>();
        for(int i=n-1; i>0; i--) {
            Vertex s1 = path2.get(i);
            Vertex t1 = path2.get(i-1);
            Edge e = new Edge(s1, t1, computeEuclideanDistance(s1.x, s1.y, t1.x, t1.y));
            result.add(e);
        }

        Vertex salt=result.get(0).source;
        Vertex san = getVertex(s);
        Edge e5 = new Edge(san, salt, computeEuclideanDistance(san.x, san.y, salt.x, salt.y));
        result.add(0, e5);

        return result;

    }

    // STUDENT CODE ENDS HERE

    /**
     * Prints out the adjacency list of the dijkstra for debugging
     */
    public void printAdjacencyList() {
        for (String u : vertexNames.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(u);
            sb.append(" -> [ ");
            for (Edge e : vertexNames.get(u).adjacentEdges) {
                sb.append(e.target.name);
                sb.append("(");
                sb.append(e.distance);
                sb.append(") ");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }


    /**
     * A main method that illustrates how the GUI uses Dijkstra.java to
     * read a map and represent it as a graph.
     * You can modify this method to test your code on the command line.
     */
    public static void main(String[] argv) throws IOException {
        String vertexFile = "cityxy.txt";
        String edgeFile = "citypairs.txt";

        Dijkstra dijkstra = new Dijkstra();
        String line;

        // Read in the vertices
        BufferedReader vertexFileBr = new BufferedReader(new FileReader(vertexFile));
        while ((line = vertexFileBr.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                vertexFileBr.close();
                throw new IOException("Invalid line in vertex file " + line);
            }
            String cityname = parts[0];
            int x = Integer.valueOf(parts[1]);
            int y = Integer.valueOf(parts[2]);
            Vertex vertex = new Vertex(cityname, x, y);
            dijkstra.addVertex(vertex);
        }
        vertexFileBr.close();

        BufferedReader edgeFileBr = new BufferedReader(new FileReader(edgeFile));
        while ((line = edgeFileBr.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                edgeFileBr.close();
                throw new IOException("Invalid line in edge file " + line);
            }
            dijkstra.addUndirectedEdge(parts[0], parts[1], Double.parseDouble(parts[2]));
        }
        edgeFileBr.close();

        // Compute distances.
        // This is what happens when you click on the "Compute All Euclidean Distances" button.
        dijkstra.computeAllEuclideanDistances();

        // print out an adjacency list representation of the graph
        dijkstra.printAdjacencyList();

        // This is what happens when you click on the "Draw Dijkstra's Path" button.

        // In the GUI, these are set through the drop-down menus.
        String startCity = "SanFrancisco";
        String endCity = "Boston";

        dijkstra.doDijkstra(startCity);
        // Get weighted shortest path between start and end city.
        List<Edge> path = dijkstra.getDijkstraPath(startCity, endCity);

        System.out.print("Shortest path between "+startCity+" and "+endCity+": ");
        System.out.println(path);
    }

}
