import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String [] args) {
        StronglyComponent<Integer> componentClass = new StronglyComponent();
        PathSearch<String> pathClass = new PathSearch();

        List<Vertex<String>> vertices = new LinkedList();
        Vertex v1 = new Vertex<String>(0,"A");
        Vertex v2 = new Vertex<String>(1,"B");
        Vertex v3 = new Vertex<String>(2,"C");
        Vertex v4 = new Vertex<String>(3,"D");
        Vertex v5 = new Vertex<String>(4,"E");
        Vertex v6 = new Vertex<String>(5,"F");
        Vertex v7 = new Vertex<String>(6,"G");
        Vertex v8 = new Vertex<String>(7,"H");

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);
        vertices.add(v8);

        List<Edge<String>> edges = new LinkedList();
        edges.add(new Edge<String>(v1,v2, "ALA"));
        edges.add(new Edge<String>(v1,v3, "HANNA"));
        edges.add(new Edge<String>(v4,v6, "MICHALINA"));
        edges.add(new Edge<String>(v3,v5, "FAUSTYNA"));
        edges.add(new Edge<String>(v6,v8, "KUBA"));
        edges.add(new Edge<String>(v7,v1,"ZOSIA" ));
        edges.add(new Edge<String>(v8,v2, "ŁUCJA"));
        edges.add(new Edge<String>(v5,v7, "MARTA"));

        List<Vertex<String>> vertices2 = new LinkedList();
        Vertex v9 = new Vertex<String>(0,"I");
        Vertex v10 = new Vertex<String>(1,"j");
        Vertex v11 = new Vertex<String>(2,"k");
        Vertex v12 = new Vertex<String>(3,"l");
        Vertex v13 = new Vertex<String>(4,"m");
        Vertex v14 = new Vertex<String>(5,"n");
        Vertex v15 = new Vertex<String>(6,"o");
        Vertex v16 = new Vertex<String>(7,"p");

        vertices2.add(v9);
        vertices2.add(v10);
        vertices2.add(v11);
        vertices2.add(v12);
        vertices2.add(v13);
        vertices2.add(v14);
        vertices2.add(v15);
        vertices2.add(v16);

        List<Edge<String>> edges2 = new LinkedList();
        edges2.add(new Edge<String>(v9,v10, "ŁYŻWA"));
        edges2.add(new Edge<String>(v11,v12, "OSKA"));
        edges2.add(new Edge<String>(v12,v14, "WERONIKA"));
        edges2.add(new Edge<String>(v15,v13, "WIDEO"));
        edges2.add(new Edge<String>(v10,v16, "DOBRO"));
        edges2.add(new Edge<String>(v6,v9,"ZIMAX" ));
        edges2.add(new Edge<String>(v10,v11, "LENISTWO"));
        edges2.add(new Edge<String>(v9,v12, "TARTA"));

        List<Vertex<String>> vertices3 = new LinkedList();
        Vertex w1 = new Vertex<String>(0,"at");
        Vertex w2 = new Vertex<String>(1,"jw");
        Vertex w3 = new Vertex<String>(2,"ks");
        Vertex w4 = new Vertex<String>(3,"lq");
        Vertex w5 = new Vertex<String>(4,"mp");
        Vertex w6 = new Vertex<String>(5,"na");
        Vertex w7 = new Vertex<String>(6,"so");
        Vertex w8 = new Vertex<String>(7,"fp");

        vertices3.add(w1);
        vertices3.add(w2);
        vertices3.add(w3);
        vertices3.add(w4);
        vertices3.add(w5);
        vertices3.add(w6);
        vertices3.add(v7);
        vertices3.add(v8);

        List<Edge<String>> edges3  = new LinkedList();
        edges3.add(new Edge<String>(w1,w2, "STOK"));
        edges3.add(new Edge<String>(w3,w4, "KOK"));
        edges3.add(new Edge<String>(w2,w4, "BLOK"));
        edges3.add(new Edge<String>(w5,w8, "WIDOK"));
        edges3.add(new Edge<String>(w4,w7, "SOK"));
        edges3.add(new Edge<String>(w6,w7,"BUT" ));
        edges3.add(new Edge<String>(w1,w3, "WIADERKO"));
        edges3.add(new Edge<String>(w7,w8, "WERS"));




        Graph graph = new Graph(edges, vertices, true);
        Graph graph2 = new Graph(edges2, vertices2, true);
        Graph graph3 = new Graph(edges3, vertices3, true);


        System.out.println( pathClass.pathSearch(graph,v1,v7));
        System.out.println(graph.adjacentVertices(v1) == graph.getVertex(0).getAdjacentVertexes());
        System.out.println(graph.getAll_edges());
        System.out.println(graph.edgeLabel(v1,v2));
        List<Set<Vertex<String>>> stronglyConnectedComponent =  componentClass.searchingComponent(graph);
        stronglyConnectedComponent.forEach(set -> {
        set.forEach(v -> System.out.print(v.getId() + " "));
        System.out.println();
        });

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(pathClass.pathSearch(graph2,v6,v12));
        System.out.println(graph2.adjacentVertices(v10));
        System.out.println(graph2.getAll_edges());
        System.out.println(graph2.edgeLabel(v9,v12));
        List<Set<Vertex<String>>> stronglyConnectedComponent2 =  componentClass.searchingComponent(graph2);
        stronglyConnectedComponent2.forEach(set -> {
            set.forEach(v -> System.out.print(v.getId() + " "));
            System.out.println();
        });
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println( pathClass.pathSearch(graph3,w2,w7));
        System.out.println(graph3.adjacentVertices(w1));
        System.out.println(graph3.getAll_edges());
        System.out.println(graph3.edgeLabel(w7,w8));
        List<Set<Vertex<String>>> stronglyConnectedComponent3 =  componentClass.searchingComponent(graph);
        stronglyConnectedComponent3.forEach(set -> {
            set.forEach(v -> System.out.print(v.getId() + " "));
            System.out.println();
        });


    }
        }
