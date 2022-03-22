
import java.util.*;

public class PathSearch<T> {

    private  Stack<Vertex<T>> stack;
    private Set<Vertex<T>> visited;
    private List<T> path;
    private Vertex previous;


    public List<T> pathSearch(Graph graph, Vertex v1, Vertex v2) throws NoSuchElementException {
        stack = new Stack();
        visited = new HashSet();
        path = new ArrayList();
        stack.push(v1);

        while(!stack.isEmpty()){
            Vertex current = stack.pop();

            if(!visited.isEmpty() && graph.edgeLabel(previous, current) != null)
                path.add((T) graph.edgeLabel(previous, current));

            visited.add(current);
            if(current == v2)
                return path;
            else
                previous =  current;

             for(int i = 0; i < current.getAdjacentVertexes().size(); i++){
                 Vertex adjacent_vertex = (Vertex) current.getAdjacentVertexes().get(i);
                 if(!visited.contains(adjacent_vertex)) {
                     if (adjacent_vertex == v2) {
                         path.add((T) current.giveMeEdge(adjacent_vertex).getLabel());
                         return path;
                     }
                     stack.push(adjacent_vertex);
                 }
             }

        }
        throw new NoSuchElementException("Path between the nodes was not detected in this graph");
    }

  }