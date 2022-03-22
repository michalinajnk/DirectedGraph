import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    int id;
    private T data;
    private List<Edge<T>> edges = new ArrayList();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(int id, T data){
        this.data = data;
        this.id = id;
    }

    Vertex(int id){
        this.id = id;
    }


    public int getId(){
        return id;
    }

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }

    public Edge giveMeEdge(Vertex end, List<Edge<T>> list){
        for(Edge ed: list){
            if(ed.getVertex2().getId() == end.getId())
                return ed;
        }
        return null;
    }

    public Edge giveMeEdge(Vertex end){
        for(Edge ed: getEdges()){
            if(ed.getVertex2().getId() == end.getId())
                return ed;
        }
        return null;
    }


    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void addAdjacentVertex(Vertex<T> vertex){
        getAdjacentVertexes().add(vertex);
    }

    public String toString(){
        return String.valueOf(data);
    }

    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }

    public List<Edge<T>> getEdges(){
        return edges;
    }

    public int getDegree(){
        return edges.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

