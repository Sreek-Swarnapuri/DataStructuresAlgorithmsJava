package org.sreek.ds.implementation.graph.matrix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sreek.ds.implementation.graph.Graph;

/**
 * Graph implementation using Adjacency Matrix which is static, unweighted and does not re-size
 * automatically. Fixed size Adjacency Matrix implementation which does not add or
 * remove vertices. It can also be directed or Undirected based on the initialization.
 * <br>
 * If we provide the initial size of the graph as 3, it will have vertices 0,1 & 2
 * until it is destroyed.
 */
public class BasicAdjacencyMatrixGraph implements Graph {

    private static final Logger logger = LogManager.getLogger(BasicAdjacencyMatrixGraph.class);
    boolean[][] adjacencyMatrix;
    boolean isDirected;

    /**
     * Creates an undirected Graph using Adjacency Matrix
     *
     * @param noOfVertices Number of vertices in the graph
     */
    public BasicAdjacencyMatrixGraph(int noOfVertices) {
        this.adjacencyMatrix = new boolean[noOfVertices][noOfVertices];
    }

    /**
     * Creates a Graph using Adjacency Matrix, it will be directed or undirected based in the inputs
     *
     * @param noOfVertices Number of vertices in the graph
     * @param isDirected   Determines if the Graph is Directed or Undirected
     */
    public BasicAdjacencyMatrixGraph(int noOfVertices, boolean isDirected) {
        this.adjacencyMatrix = new boolean[noOfVertices][noOfVertices];
        this.isDirected = isDirected;
    }


    /**
     * Adds an edge for the provided source and destination vertices. Adds edge only
     * from source to destination if the graph is directed.
     *
     * @param source      source vertex
     * @param destination destination vertex
     * @return {@code true} if edge is added successfully. {@code false} otherwise.
     */
    @Override
    public boolean addEdge(int source, int destination) {
        if (validateSourceAndDestination(source, destination))
            return false;

        if (isDirected) {
            adjacencyMatrix[source][destination] = true;
        } else {
            adjacencyMatrix[source][destination] = true;
            adjacencyMatrix[destination][source] = true;
        }

        return true;
    }

    /**
     * Removes an edge for the provided source and destination vertices. Removes edge only
     * from source to destination if the graph is directed.
     *
     * @param source      source vertex
     * @param destination destination vertex
     * @return {@code true} if edge is removed successfully. {@code false} otherwise.
     */
    @Override
    public boolean removeEdge(int source, int destination) {
        if (validateSourceAndDestination(source, destination))
            return false;

        if (isDirected) {
            adjacencyMatrix[source][destination] = false;
        } else {
            adjacencyMatrix[source][destination] = false;
            adjacencyMatrix[destination][source] = false;
        }

        return true;
    }

    /**
     * Always {@code false} as adding a vertex is not present in this implementation of
     * Adjacency Matrix Graph.
     *
     * @return {@code false} always
     */
    @Override
    public boolean addVertex(int vertex) {
        return false;
    }

    /**
     * Always {@code false} as removing a vertex is not present in this implementation of
     * Adjacency Matrix Graph.
     *
     * @return {@code false} always
     */
    @Override
    public boolean removeVertex(int vertex) {
        return false;
    }

    /**
     * Returns true if the graph is directed, false otherwise.
     *
     * @return {@code boolean}
     */
    @Override
    public boolean isDirectedGraph() {
        return isDirected;
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

    private boolean validateSourceAndDestination(int source, int destination) {
        if ((source > 0 && source < this.adjacencyMatrix.length) || (destination > 0 && destination < this.adjacencyMatrix.length)) {
            return true;
        }
        logger.error("Provided source or destination vertex is invalid");
        return false;
    }
}
