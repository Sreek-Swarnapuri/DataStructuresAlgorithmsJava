package org.sreek.ds.usage.impl.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sreek.ds.implementation.graph.Graph;
import org.sreek.ds.implementation.graph.matrix.BasicAdjacencyMatrixGraph;

public class AdjacencyMatrixGraphUsage {

    private static final Logger logger = LogManager.getLogger(AdjacencyMatrixGraphUsage.class);

    public static void main(String[] args) {
        Graph graph = new BasicAdjacencyMatrixGraph(4);

        graph.displayGraph();

        logger.info("is directed graph? {}", graph.isDirectedGraph());

        graph.addEdge(2, 3);

        graph.addEdge(2, 1);

        System.out.println("is directed graph? " + graph.findNeighbours(2));

        graph.displayGraph();
    }

}
