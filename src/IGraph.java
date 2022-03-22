import java.util.List;

public interface IGraph<T> {
        List<Vertex> vertices(); //zwraca wszystkie wierzcholki grafu
        T edgeLabel(Vertex w1, Vertex w2); //pobiera etykietę krawędzi pomiędzywierzchołkami
        //wartość NULL oznacza brak krawędzi
        List<Vertex> adjacentVertices(Vertex w); //zwraca wierzchołki, do których istniejekrawędz z w
    }

