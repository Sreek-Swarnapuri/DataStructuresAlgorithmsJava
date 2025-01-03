package org.sreek.ds.implementation.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Graph implementation using Adjacency Matrix which is static and does not re-size
 * automatically. Fixed size Adjacency Matrix implementation which does not add or
 * remove vertices.
 * <br>
 * If we provide the initial size of the graph as 3, it will have vertices 0,1 & 2
 * until it is destroyed.
 */
public class BasicAdjacencyMatrixGraph implements Graph{

    int[][] adjacencyMatrix;

    private static final Logger logger = LogManager.getLogger(BasicAdjacencyMatrixGraph.class);

    public BasicAdjacencyMatrixGraph(int vertices) {
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    @Override
    public boolean addEdge(int source, int destination) {
        if(source < 0 || source >= this.adjacencyMatrix.length || destination < 0 || destination >= this.adjacencyMatrix.length ){
            logger.error("Provided source or destination vertex is invalid");
            return false;
        }
        return true;
    }

    @Override
    public boolean removeEdge(int source, int destination) {
        return false;
    }

    /**
     * Always {@code false} as adding a vertex is not present in this implementation of
     * Adjacency Matrix Graph.
     * @return {@code false} always
     */
    @Override
    public boolean addVertex(int vertex) {
        return false;
    }

    /**
     * Always {@code false} as removing a vertex is not present in this implementation of
     * Adjacency Matrix Graph.
     * @return {@code false} always
     */
    @Override
    public boolean removeVertex(int vertex) {
        return false;
    }

    @Override
    public boolean isDirectedGraph() {
        return false;
    }

    @Override
    public int getDegreeOfVertex(int vertex) {
        return 0;
    }

    @Override
    public int getInDegreeOfVertex(int vertex) {
        return 0;
    }

    @Override
    public int getOutDegreeOfVertex(int vertex) {
        return 0;
    }

    @Override
    public int[] findNeighbours(int vertex) {
        return new int[0];
    }

    @Override
    public void checkIfEdgeExists(int source, int destination) {

    }

    @Override
    public void displayGraph() {

    }
}
