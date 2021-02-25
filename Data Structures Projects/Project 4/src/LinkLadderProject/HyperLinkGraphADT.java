/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkLadderProject;

import DataStructures.ALDiGraph;
import DataStructures.Vertex;
import Exceptions.*;
import java.util.ArrayList;

/**
 * ADT for HyperLinkGraph project.
 *
 * @author Brian Thompson
 * @version 18/4/2018
 * @param <T>
 */
public abstract class HyperLinkGraphADT<T extends Comparable> extends ALDiGraph<T> {

    /**
     * Returns an ArrayList with the path from element to element2. Keep in mind
     * that the method from ALDiGraph in your DSLibrary HasPathBetween will not only 
     * be needed for checking the last exception, but it is also almost identical 
     * to the solution for this one.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return a list of the vertices along the path from element to element2
     * @throws EmptyCollectionException if the graph has no vertices
     * @throws InvalidArgumentException if either element is null
     * @throws ElementNotFoundException if either element is not in the graph
     * @throws NoPathException if there is no path between the two elements
     */
    public abstract ArrayList<Vertex> getPathBetween(Vertex source, Vertex destination) 
            throws EmptyCollectionException, InvalidArgumentException, 
            ElementNotFoundException, NoPathException;

    /**
     * Determines if the graph is connected.
     * There is a basic algorithm for accomplishing this that we covered in class:
     * For every vertex, perform a breadthFirstTraversal. If every BFT returns a
     * list equal to the size of the graph, then the graph is connected.
     * Requires a working BFT method (found below)
     * @return true/false if the graph is connected.
     * @throws EmptyCollectionException If the graph has no vertices
     */
    public abstract boolean isGraphConnected() throws EmptyCollectionException; 

    /**
     * Determines if a graph is complete. While you could solve this method by
     * iterating through the graph and ensuring that every vertex has an edge to
     * every other vertex, this is unnecessary. We can do this simply, two different ways:
     * If the graph's number of edges is equal 
     * to the number of possible edges (we can't have duplicates)
     * the graph is complete.
     * Alternatively, if the graph has a density of 1.0, this suggests the graph
     * is complete.
     * @return true/false if the graph is complete
     * @throws EmptyCollectionException If the graph has no vertices
     */
    public abstract boolean isGraphComplete() throws EmptyCollectionException;

    /**
     * Returns the ratio of vertices with a connection out of total vertices.
     * Be sure to check the ALDiGraph class in your DS_Library for a method
     * that will help with this. You should not be iterating through anything
     * in this method's body. 
     * @return vertices w/ edges / total number vertices
     * @throws EmptyCollectionException if the graph has no vertices
     */
    public abstract double inclusiveness() throws EmptyCollectionException;

    /**
     * Returns a ratio of how complete the graph is.
     * The ratio is number of edges / number of possible edges
     * You can compute the number of possible edges in a directed graph with the 
     * following formula:
     * where n = number of vertices:
     * 2 * ((n * (n - 1)) / 2)
     * @precondition if the graph has only vertex, the density is 1.
     * @return the density of the graph
     * @throws EmptyCollectionException if the graph has no vertices
     */
    public abstract double density() throws EmptyCollectionException;

    /**
     * A basic breadthFirstTraversal. You should have an example of this code in
     * your labs, or you can find it online. You will need a queue and an array - 
     * I highly recommend using Java's built in Queue, which is instantiated with
     * a LinkedList.
     * @param v the starting vertex
     * @return an array list of all nodes visited in the traversal
     * @throws EmptyCollectionException if the graph has no vertices
     * @throws InvalidArgumentException if the starting vertex or its element is null
     * @throws ElementNotFoundException if the starting vertex is not in the graph
     */
    public abstract ArrayList<Vertex> breadthFirstTraversal(Vertex v) throws EmptyCollectionException,
            InvalidArgumentException, ElementNotFoundException;

    
    /**
     * Determines if a WebPage is a link ladder. A link ladder has a path from
     * the source to the destination and from the destination to the source.
     * This should be relatively easy if you use the methods in the ALDiGraph
     * class in your DSLibrary.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true/false if there is a round-trip path between the two vertices
     * @throws EmptyCollectionException If the graph has no vertices
     * @throws InvalidArgumentException If either vertex or its element is null
     * @throws ElementNotFoundException If either vertex is not in the graph
     */
    public abstract boolean isALinkLadder(Vertex source, Vertex destination) 
            throws EmptyCollectionException, InvalidArgumentException, ElementNotFoundException;
}
