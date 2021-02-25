/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkLadderProject;

import DataStructures.Vertex;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import Exceptions.NoPathException;
import java.util.*;

/**
 * A HyperLink graph, which may be used to graph connects between linked pages
 * on a web application.
 *
 * @author Wesley Gore
 * @version 1.3
 * @param <T> Generic element, extends Comparable
 */
public class HyperLinkGraph<T extends Comparable> extends HyperLinkGraphADT<T> {
    
    @Override
    public ArrayList<Vertex> getPathBetween(Vertex source, Vertex destination)
            throws EmptyCollectionException, InvalidArgumentException,
            ElementNotFoundException, NoPathException {
        
        if (isEmpty()) {
            throw new EmptyCollectionException("graph");
        }
        if (source == null || source.getElement() == null
                || destination == null || destination.getElement() == null) {
            throw new InvalidArgumentException("element");
        }
        if (!contains(source) || !contains(destination)) {
            throw new ElementNotFoundException("Either source/destination not found");
        }
        if (!hasPathFrom(source, destination)) {
            throw new NoPathException("no path");
        }
        
        ArrayList<Vertex> path = new ArrayList<>();
        Queue<Vertex> q = new LinkedList<>();
        Vertex[] p = new Vertex[vertices.size()];
        boolean[] visited = new boolean[vertices.size()];
        
        Vertex temp;
        
        q.add(source);
        visited[vertices.indexOf(source)] = true;
        
        while (!q.isEmpty()) {
            
            temp = q.remove();
            
            for (Vertex v : adjList.get(vertices.indexOf(temp))) {
                if (!visited[vertices.indexOf(v)]) {
                    q.add(v);
                    visited[vertices.indexOf(v)] = true;
                    p[vertices.indexOf(v)] = temp;
                }
            }
            
        }
        
        temp = destination;
        
        while (temp != null) {
            
            path.add(0,temp);
            temp = p[vertices.indexOf(temp)];
            
        }
        
        return path;
    }
    
    @Override
    public boolean isGraphConnected() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("graph");
        }
        for (Vertex v : vertices) {
            try {
                if (numVertices != breadthFirstTraversal(v).size()) {
                    return false;
                }
            } catch (InvalidArgumentException | ElementNotFoundException ex) {
                return false;
            }
        }
        
        return true;
        
    }
    
    @Override
    public boolean isGraphComplete() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("graph");
        }
        return (density() == 1.0);
        
    }
    
    @Override
    public double inclusiveness() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("graph");
        }
        
        if (numVertices == 1) {
            return 1.0;
        }
        
        double x = numVertices - numIsolatedPoints();
        double y = numVertices;
        
        return (x / y);
    }
    
    @Override
    public double density() throws EmptyCollectionException {
        
        if (isEmpty()) {
            throw new EmptyCollectionException("graph");
        }
        
        if (numVertices == 1) {
            return 1.0;
        }
        
        double x = 2 * ((numVertices * (numVertices - 1)) / 2.0);
        double y = numEdges;
        
        return (y / x);
        
    }
    
    @Override
    public ArrayList<Vertex> breadthFirstTraversal(Vertex v)
            throws EmptyCollectionException, InvalidArgumentException,
            ElementNotFoundException {
        
        if (isEmpty()) {
            throw new EmptyCollectionException("graph");
        }
        if (v == null || v.getElement() == null) {
            throw new InvalidArgumentException("element");
        }
        if (!contains(v)) {
            throw new ElementNotFoundException("element");
        }
       
        ArrayList<Vertex> path = new ArrayList<>();
        Queue<Vertex> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices.size()];
        Vertex curr = v;
        
        q.add(curr);
        visited[vertices.indexOf(curr)] = true;
        
        while (!q.isEmpty()) {
            curr = q.remove();
            path.add(curr);
            
            for (Vertex v2 : adjList.get(vertices.indexOf(curr))) {
                if (!visited[vertices.indexOf(v2)]) {
                    q.add(v2);
                    visited[vertices.indexOf(v2)] = true;
                }
            }
        }
        
        return path;
       
    }
    
    @Override
    public boolean isALinkLadder(Vertex source, Vertex destination)
            throws EmptyCollectionException, InvalidArgumentException,
            ElementNotFoundException {
        
        if (isEmpty()) {
            throw new EmptyCollectionException("graph");
        }
        if (source == null || source.getElement() == null
                || destination == null || destination.getElement() == null) {
            throw new InvalidArgumentException("element");
        }
        if (!contains(source) || !contains(destination)) {
            throw new ElementNotFoundException("Either source/destination not found");
        }
        
        return hasPathTo(source, destination) && hasPathTo(destination, source);
        
    }
    
}
