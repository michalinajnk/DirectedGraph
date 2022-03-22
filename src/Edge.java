import java.util.Objects;

public class Edge<T>{
        private Vertex<T> vertex1;
        private Vertex<T> vertex2;
        private T label;
        private boolean isDirected = true;



        Edge(Vertex vertex1, Vertex vertex2, T label){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.label = label;

        }


        public T getLabel(){
            return label;
        }


        Vertex getVertex1(){
            return vertex1;
        }

        Vertex getVertex2(){
            return vertex2;
        }


        @Override
        public String toString() {
            return "Edge [vertex1=" + vertex1
                    + ", vertex2=" + vertex2 + ", label=" + label + "]";
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return isDirected == edge.isDirected &&
                Objects.equals(vertex1, edge.vertex1) &&
                Objects.equals(vertex2, edge.vertex2) &&
                Objects.equals(label, edge.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex1, vertex2, label, isDirected);
    }
}

