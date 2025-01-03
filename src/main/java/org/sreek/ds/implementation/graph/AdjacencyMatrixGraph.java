package org.sreek.ds.implementation.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

    private static final Logger logger = LogManager.getLogger(AdjacencyMatrixGraph.class);
    List<Integer> vertices;
    int[][] adjacentMatrix;

    public AdjacencyMatrixGraph(int noOfVertices) {
        this.vertices = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            this.vertices.add(i);
        }
        this.adjacentMatrix = new int[noOfVertices][noOfVertices];

    }

    /**
     * Adds an edge between the given source and destination vertices.
     * <br>
     * Time Complexity: O(V) - V - no of vertices, need to traverse through the vertices list and check if they
     * exist or not.
     *
     * @param source      - starting vertex of the edge
     * @param destination - ending vertex of the edge
     * @return {@code true} if edge is added into the matrix. {@code false} if provided
     * vertices do not exist in the matrix.
     */
    @Override
    public boolean addEdge(int source, int destination) {
        if (!this.vertices.contains(source) || !this.vertices.contains(destination)) {
            logger.warn("Source or Destination provided is invalid while adding an edge!");
            return false;
        }
        adjacentMatrix[source][destination] = 1;
        adjacentMatrix[destination][source] = 1;
        return true;
    }

    /**
     * Removes an edge between the given source and destination vertices,
     * <br>
     * Time Complexity: O(V) - V - no of vertices, need to traverse through the vertices list and check if they
     * exist or not.
     *
     * @param source      - starting vertex of the edge
     * @param destination - ending vertex of the edge
     * @return {@code true} if edge is added into the matrix. {@code false} if provided
     *      * vertices do not exist in the matrix.
     */
    @Override
    public boolean removeEdge(int source, int destination) {
        if (!this.vertices.contains(source) || !this.vertices.contains(destination)) {
            logger.warn("Source or Destination provided is invalid while removing an edge!");
            return false;
        }
        adjacentMatrix[source][destination] = 0;
        adjacentMatrix[destination][source] = 0;
        return true;
    }

    /**
     * Adds a new vertex provided to the existing adjacency matrix.
     * <br>
     * Time Complexity: O(n ^ 2) - Need to loop through the 2d matrix to create a new Matrix with the additional vertex
     *
     * @param vertex - vertex to be added.
     * @return {@code true} if the addition is successful, {@code false} if the vertex already exists.
     */
    @Override
    public boolean addVertex(int vertex) {
        if (this.vertices.contains(vertex)) {
            logger.warn("Provided vertex already exists!");
            return false;
        }
        this.vertices.add(vertex);
        int[][] newMatrix = new int[this.vertices.size()][this.vertices.size()];
        for (int i = 0; i < this.adjacentMatrix.length; i++) {
            System.arraycopy(this.adjacentMatrix[i], 0, newMatrix[i], 0, this.adjacentMatrix[0].length);
        }
        this.adjacentMatrix = newMatrix;
        return true;
    }


    /**
     * Removes a vertex and its associated edges from the graph.
     * Shift rows from the vertex provided then shifts columns from the vertex provided.
     * Then replaces the current matrix with the new matrix.
     * <br>
     * Time Complexity: O(n ^ 2) - Need to loop through the 2d matrix thrice to perform necessary actions.
     *
     * @param vertex - vertex to be removed.
     * @return {@code true} if the removal is successful, {@code false} otherwise.
     */
    /* An Example below
        0 1 2                      0 1 2                         0 1
        - - -                      - - -                         - -
    0 | 1 0 1                  0 | 1 0 1                     0 | 1 1
    1 | 0 0 0 => shift rows => 1 | 1 0 1 => shift columns => 1 | 1 1
    2 | 1 0 1

     */
    @Override
    public boolean removeVertex(int vertex) {
        if (!this.vertices.contains(vertex)) {
            logger.warn("Provided vertex does not exist");
            return false;
        }
        int indexOfVertex = this.vertices.indexOf(vertex);

        // Shift rows
        for (int i = indexOfVertex; i < this.adjacentMatrix.length; i++) {
            for (int j = 0; j < this.adjacentMatrix[i].length; j++) {
                this.adjacentMatrix[i][j] = this.adjacentMatrix[i+1][j];
            }
        }

        // Shift columns
        for (int i = 0; i < this.adjacentMatrix.length; i++) {
            for (int j = indexOfVertex; j < this.adjacentMatrix[i].length; j++) {
                this.adjacentMatrix[i][j] = this.adjacentMatrix[i][j+1];
            }
        }

        int[][] newMatrix = new int[this.vertices.size()-1][this.vertices.size()-1];

        for (int i = 0; i < newMatrix.length; i++) {
            System.arraycopy(this.adjacentMatrix[i], 0, newMatrix[i], 0, newMatrix[i].length);
        }

        this.adjacentMatrix = newMatrix;

        this.vertices.remove(vertex);
        return true;
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

    /**
     * IN PROGRESS
     */
    @Override
    public void displayGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices.size(); i++) {
            sb.append(vertices.get(i)).append(" ");
        }
        for (int i = 0; i < vertices.size(); i++) {
            sb.append("---");
        }

        for (int i = 0; i < adjacentMatrix.length; i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < adjacentMatrix[i].length; j++) {

            }
        }

    }
}
