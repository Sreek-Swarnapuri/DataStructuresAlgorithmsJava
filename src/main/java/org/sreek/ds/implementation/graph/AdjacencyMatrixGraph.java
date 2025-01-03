package org.sreek.ds.implementation.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

    List<Integer> vertices;
    int[][] adjacentMatrix;

    private static final Logger logger = LogManager.getLogger(AdjacencyMatrixGraph.class);

    public AdjacencyMatrixGraph(int noOfVertices) {
        this.vertices = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++){
            this.vertices.add(i);
        }
        this.adjacentMatrix = new int[noOfVertices][noOfVertices];

    }

    /**
     * Adds an edge between the given source and destination vertices. Returns false
     * if any of the provided vertices do not exist
     * <br>
     * Time Complexity: O(n) - need to traverse through the vertices and check if they exist or not.
     *
     * @param source - starting vertex of the edge
     * @param destination - ending vertex of the edge
     * @return {@code true} if edge is added into the matrix. {@code false} if provided
     * vertices do not exist in the matrix.

     */
    @Override
    public boolean addEdge(int source, int destination) {
        if(!this.vertices.contains(source) || !this.vertices.contains(destination)) {
            logger.warn("Source or Destination provided is invalid while adding an edge!");
            return false;
        }
        adjacentMatrix[source][destination] = 1;
        adjacentMatrix[destination][source] = 1;
        return true;
    }

    @Override
    public boolean removeEdge(int source, int destination) {
        if(!this.vertices.contains(source) || !this.vertices.contains(destination)) {
            logger.warn("Source or Destination provided is invalid while removing an edge!");
            return false;
        }
        adjacentMatrix[source][destination] = 0;
        adjacentMatrix[destination][source] = 0;
        return true;
    }

    @Override
    public boolean addVertex(int vertex) {
        if(this.vertices.contains(vertex)){
            logger.warn("Provided vertex already exists!");
            return false;
        }
        this.vertices.add(vertex);
        int[][] newMatrix = new int[this.vertices.size()][this.vertices.size()];
        for (int i = 0; i < this.adjacentMatrix.length; i++) {
            for (int j = 0; j <this.adjacentMatrix[0].length; j++) {
                newMatrix[i][j] = this.adjacentMatrix[i][j];
            }
        }
        this.adjacentMatrix = newMatrix;
        return true;
    }

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
