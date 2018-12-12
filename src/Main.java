
        public class Main {
            public static void main(String[] args) {
                Dijkstra d = new Dijkstra();
                Graph graph = new Graph ("teste", true, true);
                graph.addVertex("v1");
                graph.addVertex("v2");
                graph.addVertex("v3");
                graph.addVertex("v4");
                graph.addVertex("v5");
                graph.addEdge("v1", "v2", 5, "a1");
                graph.addEdge("v2", "v3", 7, "a2");
                graph.addEdge("v3", "v4", 3, "a3");
                graph.addEdge("v4", "v5", 4, "a4");
                graph.addEdge("v1", "v4", 9, "a5");
                graph.addEdge("v3", "v5", 1, "a6");
                graph.addEdge("v4", "v2", 2, "a7");

                System.out.println(d.findSmallerPathDijkstra(graph, "v1"));
                //Menu menu = new Menu();
                //menu.createGraphMenu();
            }
        }

