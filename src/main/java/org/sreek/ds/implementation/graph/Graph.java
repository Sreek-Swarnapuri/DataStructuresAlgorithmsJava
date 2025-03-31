package org.sreek.ds.implementation.graph;

import java.util.List;

public interface Graph {
    
    public boolean addEdge(int source, int destination);
    public boolean removeEdge(int source, int destination);
    
    public boolean addVertex(int vertex);
    public boolean removeVertex(int vertex);

    public boolean isDirectedGraph();
    
    // get degree of vertex
    public int getDegreeOfVertex(int vertex);
    public int getInDegreeOfVertex(int vertex);
    public int getOutDegreeOfVertex(int vertex);
    
    public List<Integer> findNeighbours(int vertex);

    public void displayGraph();
    
}
