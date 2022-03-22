import java.util.*;

public class Graph<T> implements IGraph {

    private  List<Edge<T>> all_edges = new LinkedList();
   private   Map<Integer,Vertex<T>> all_vertices = new TreeMap();
    private List<Vertex<T>> vertex_list = new LinkedList();


    public Graph(List<Edge<T>> edges, List<Vertex<T>> vertices, boolean isDirected){
        isDirected = true;
        vertex_list.addAll(vertices);
       all_edges = edges;
        for(Vertex v: vertices)
            all_vertices.put(v.getId(),v);
        for(Edge e: edges) {
            Vertex source = e.getVertex1();
            source.addAdjacentVertex(e, e.getVertex2());

        }

    }

    public Graph(List<Vertex<T>> vertices, Graph<T> graph){
        all_vertices = new TreeMap();
        all_edges = new LinkedList();
        this.vertex_list =  vertices;


    }


    public List<Edge<T>> getAll_edges(){
        return all_edges;
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAll_edges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getLabel());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public Vertex<T> getVertex(int id){
        return all_vertices.get(id);
    }

    @Override
    public List<Vertex<T>> vertices() {
          return vertex_list;
    }

    @Override
    public T edgeLabel(Vertex w1, Vertex w2) {
    return (T) w1.giveMeEdge(w2,w1.getEdges()).getLabel();

    }

    @Override
    public List<Vertex> adjacentVertices(Vertex w) {
       return w.getAdjacentVertexes();
    }



    public void addEdge(int id1,int id2, T label) {
        Vertex<T> vertex1 = null;
        if (all_vertices.containsKey(id1)) {
            vertex1 = all_vertices.get(id1);
        } else {
            vertex1 = new Vertex<T>(id1);
            all_vertices.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if (all_vertices.containsKey(id2)) {
            vertex2 = all_vertices.get(id2);
        } else {
            vertex2 = new Vertex<T>(id2);
            all_vertices.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1, vertex2, label);
        all_edges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
    }

}
