import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StronglyComponent<T> {


        public List<Set<Vertex<T>>> searchingComponent(Graph<T> graph) {


            Deque<Vertex<T>> stack = new ArrayDeque<>();
            Set<Vertex<T>> visited = new HashSet<>();

            for (int i = 0; i < graph.vertices().size(); i++) {       //wyznaczam kolejnosc przeszukiwanych 'w' dla transponowanego grafu
                Vertex vertex = (Vertex) graph.vertices().get(i);  // aby przejsc przez 'w' w kolejnosci w jakiej wystepuja
                if (visited.contains(vertex))
                    continue;
                depthSearch(vertex, visited, stack);
            }

            Graph<T> transposedGraph = transposedGraph(graph);

            visited.clear();
            List<Set<Vertex<T>>> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                Vertex<T> vertex = transposedGraph.getVertex(stack.poll().getId()); //pobieram pierwszy odw 'w' dodany na stos
                if (visited.contains(vertex)) {
                    continue;
                }
                Set<Vertex<T>> set = new HashSet<>();
                depthSearch_transposedGraph(vertex, visited, set);
                result.add(set);
            }
            return result;
        }

    private Graph<T> transposedGraph(Graph<T> graph) {
        Graph<T> reverseGraph = new Graph(graph.vertices(),graph);
        for (Edge<T> edge : graph.getAll_edges()) {
            reverseGraph.addEdge(edge.getVertex2().getId(), edge.getVertex1()
                    .getId(), edge.getLabel());
        }
        return reverseGraph;
    }


        private void depthSearch(Vertex<T> vertex, Set<Vertex<T>> visited, Deque<Vertex<T>> stack) {
            visited.add(vertex);
            for (Vertex<T> v : vertex.getAdjacentVertexes()) {
                if (visited.contains(v)) {
                    continue;
                }
                depthSearch(v, visited, stack);
            }
            stack.offerFirst(vertex); //dodaje na poczatek kolejki
        }

        private void depthSearch_transposedGraph(Vertex<T> vertex, Set<Vertex<T>> visited, Set<Vertex<T>> set) {
            visited.add(vertex);
            set.add(vertex);//dodaje odwiedzany najpierw a ponizej sasiadow
            if(vertex.getAdjacentVertexes() == null)
                depthSearch_transposedGraph(vertex, visited, set);
                for (Vertex<T> v : vertex.getAdjacentVertexes()) {
                    if (visited.contains(v)) {
                        continue;
                    }
                    depthSearch_transposedGraph(v, visited, set);
                }
            }


    }

