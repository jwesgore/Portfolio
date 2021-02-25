/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkLadderProject;

import DataStructures.*;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import Exceptions.NoPathException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wes
 * @version 1.3
 * @param <T>
 */
public class HyperLinkGraphTest<T extends Comparable> extends ALDiGraph<T> {

    private final Vertex<Character> v1 = new Vertex('a');
    private final Vertex<Character> v2 = new Vertex('b');
    private final Vertex<Character> v3 = new Vertex('c');
    private final Vertex<Character> v4 = new Vertex('d');

    /**
     * Empty
     *
     * @throws Exception
     */
    public HyperLinkGraphTest() throws Exception {
        //unused
    }

    /**
     * Test of getPathBetween method, of class HyperLinkGraph.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPathBetween() throws Exception {

        HyperLinkGraph<Character> g3 = new HyperLinkGraph<>();
        ArrayList<Vertex> list = new ArrayList<>();
        ArrayList<Vertex> list2 = new ArrayList<>();

        try {
            g3.getPathBetween(v1, v2);
            fail("expected an EmptyCollectionsException to be thrown");
        } catch (EmptyCollectionException ex) {
            assertNotNull(ex);
        }

        g3.addVertex(v1);
        g3.addVertex(v2);
        g3.addEdge(v1, v2);
        list.add(v1);
        list.add(v2);

        try {
            g3.getPathBetween(null, null);
            fail("expected an InvalidArguementException to be thrown");
        } catch (InvalidArgumentException ex) {
            assertNotNull(ex);
        }
        
        try {
            g3.getPathBetween(v3, v4);
            fail("expected an ElementNotFoundException to be thrown");
        } catch (ElementNotFoundException ex) {
            assertNotNull(ex);
        }
        
        try {
            g3.getPathBetween(v2, v1);
            fail("expected a NoPathException to be thrown");
        } catch (NoPathException ex) {
            assertNotNull(ex);
        }

        assertEquals(list, g3.getPathBetween(v1, v2)); //small path

        g3.addVertex(v3);
        g3.addEdge(v2, v3);

        assertEquals(list, g3.getPathBetween(v1, v2)); //extended path in middle

        list.add(v3);

        assertEquals(list, g3.getPathBetween(v1, v3)); //extended path at end

        g3.addEdge(v1, v3);
        list2.add(v1);
        list2.add(v3);

        assertTrue(list.equals(g3.getPathBetween(v1, v3))
                || list2.equals(g3.getPathBetween(v1, v3))); //two possible paths

    }

    /**
     * Test of isGraphConnected method, of class HyperLinkGraph.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testIsGraphConnected() throws Exception {

        HyperLinkGraph<Character> g3 = new HyperLinkGraph<>();

        try {
            g3.isGraphConnected();
            fail("expected an EmptyCollectionsException to be thrown");
        } catch (EmptyCollectionException ex) {
            assertNotNull(ex);
        }

        g3.addVertex(v1);

        assertTrue(g3.isGraphConnected()); //graph with only one vertex

        g3.addVertex(v2);

        assertFalse(g3.isGraphConnected());  //two vertices unconnected

        g3.addVertex(v3);
        g3.addEdge(v1, v2);

        assertFalse(g3.isGraphConnected()); //three vertices, two connected

        g3.addEdge(v2, v3);

        assertFalse(g3.isGraphConnected()); //three vertices singly connected

        g3.addEdge(v3, v1);

        assertTrue(g3.isGraphConnected()); //three vertices in loop

    }

    /**
     * Test of isGraphComplete method, of class HyperLinkGraph.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testIsGraphComplete() throws Exception {

        HyperLinkGraph<Character> g3 = new HyperLinkGraph<>(); //temporaty graph

        try {
            g3.isGraphComplete();
            fail("expected an EmptyCollectionsException to be thrown");
        } catch (EmptyCollectionException ex) {
            assertNotNull(ex);
        }

        g3.addVertex(v1);

        assertTrue(g3.isGraphComplete());  //graph with one vertex

        g3.addVertex(v2);

        assertFalse(g3.isGraphComplete());  //two unconnected vertices

        g3.addVertex(v3);
        g3.addEdge(v1, v2);

        assertFalse(g3.isGraphComplete()); //one connected, one disconnected 

        g3.addEdge(v1, v3);
        g3.addEdge(v2, v3);

        assertFalse(g3.isGraphComplete()); //one way edges only

        g3.addEdge(v3, v1);
        g3.addEdge(v3, v2);
        g3.addEdge(v2, v1);

        assertTrue(g3.isGraphComplete());  //edges both ways

    }

    /**
     * Test of inclusiveness method, of class HyperLinkGraph.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testInclusiveness() throws Exception {

        HyperLinkGraph<Character> g3 = new HyperLinkGraph<>(); //temp graph

        try {
            g3.inclusiveness();
            fail("expected an EmptyCollectionsException to be thrown");
        } catch (EmptyCollectionException ex) {
            assertNotNull(ex);
        }

        g3.addVertex(v1);

        assertEquals(1.0, g3.inclusiveness(), 0.0); //one vertex

        g3.addVertex(v2);

        assertNotEquals(1.0, g3.inclusiveness(), 0.0); //two unconnected vertices

        g3.addVertex(v3);
        g3.addVertex(v4);
        g3.addEdge(v3, v4);

        assertEquals(0.5, g3.inclusiveness(), 0.0); // two seperate islands

    }

    /**
     * Test of density method, of class HyperLinkGraph.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDensity() throws Exception {

        HyperLinkGraph<Character> g3 = new HyperLinkGraph<>();

        try {
            g3.density();
            fail("expected an EmptyCollectionsException to be thrown");
        } catch (EmptyCollectionException ex) {
            assertNotNull(ex);
        }

        g3.addVertex(v1);

        assertEquals(1.0, g3.density(), 0.0); //1 point, 0 edge

        g3.addVertex(v2);

        assertEquals(0.0, g3.density(), 0.0); //2 point, 0 edge

        g3.addEdge(v1, v2);

        assertEquals(0.5, g3.density(), 0.0); //2 point, 1 edge

        g3.addEdge(v2, v1);

        assertEquals(1.0, g3.density(), 0.0); //2 point, 2 edge

        g3.addVertex(v3);

        assertEquals(0.33, g3.density(), 0.01); //3 point, 2 edge

        g3.addEdge(v1, v3);

        assertEquals(0.5, g3.density(), 0.0); //3 point, 3 edge

    }

    /**
     * Test of breadthFirstTraversal method, of class HyperLinkGraph.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBreadthFirstTraversal() throws Exception {

        HyperLinkGraph<Character> g3 = new HyperLinkGraph<>();
        ArrayList<Vertex> list = new ArrayList<>();
        ArrayList<Vertex> list2 = new ArrayList<>();
        ArrayList<Vertex> list3 = new ArrayList<>();

        try {
            g3.breadthFirstTraversal(v1);
            fail("expected an EmptyCollectionsException to be thrown");
        } catch (EmptyCollectionException ex) {
            assertNotNull(ex);
        }

        g3.addVertex(v1);
        
        try {
            g3.getPathBetween(null, null);
            fail("expected an InvalidArguementException to be thrown");
        } catch (InvalidArgumentException ex) {
            assertNotNull(ex);
        }
        
        try {
            g3.breadthFirstTraversal(v2);
            fail("expected an ElementNotFoundException to be thrown");
        } catch (ElementNotFoundException ex) {
            assertNotNull(ex);
        }

        assertNotEquals(list, g3.breadthFirstTraversal(v1)); // empty list

        list.add(v1);

        assertEquals(list, g3.breadthFirstTraversal(v1)); //list with only one point

        g3.addVertex(v2);
        list.add(v2);

        assertNotEquals(list, g3.breadthFirstTraversal(v1)); //make sure graphs are unchanged
        assertNotEquals(list, g3.breadthFirstTraversal(v2));

        list2.add(v2);
        g3.addEdge(v1, v2);

        assertEquals(list, g3.breadthFirstTraversal(v1)); //edge to v1 - > v2
        assertEquals(list2, g3.breadthFirstTraversal(v2)); //no outgoing edge

        g3.addVertex(v3);
        g3.addEdge(v2, v3);
        g3.addEdge(v3, v1);
        list.add(v3);

        assertEquals(list, g3.breadthFirstTraversal(v1)); //with a loop

        g3.addVertex(v4);

        assertEquals(list, g3.breadthFirstTraversal(v1)); //disconnected point

        g3.addEdge(v4, v2);

        assertEquals(list, g3.breadthFirstTraversal(v1)); //connected but not accessible point

        g3.addEdge(v3, v4);
        g3.addEdge(v2, v4);
        list.add(v4);
        list3.add(v1);
        list3.add(v2);
        list3.add(v4);
        list3.add(v3);

        assertTrue(list.equals(g3.breadthFirstTraversal(v1))
                || list3.equals(g3.breadthFirstTraversal(v1))); //two possible lists

        assertFalse(list.equals(g3.breadthFirstTraversal(v2))
                && list3.equals(g3.breadthFirstTraversal(v2))); //different starting point

    }

    /**
     * Test of isALinkLadder method, of class HyperLinkGraph.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testIsALinkLadder() throws Exception {

        HyperLinkGraph<Character> g3 = new HyperLinkGraph<>();

        try {
            g3.isALinkLadder(v1, v2);
            fail("expected an EmptyCollectionsException to be thrown");
        } catch (EmptyCollectionException ex) {
            assertNotNull(ex);
        }

        g3.addVertex(v1);
        g3.addVertex(v2);
        
        try {
            g3.getPathBetween(null, null);
            fail("expected an InvalidArguementException to be thrown");
        } catch (InvalidArgumentException ex) {
            assertNotNull(ex);
        }
        
        try {
            g3.isALinkLadder(v3, v4);
            fail("expected an ElementNotFoundException to be thrown");
        } catch (ElementNotFoundException ex) {
            assertNotNull(ex);
        }
        

        assertFalse(g3.isALinkLadder(v1, v2)); //two unconnected points

        g3.addEdge(v1, v2);

        assertFalse(g3.isALinkLadder(v1, v2)); //connected only one way

        g3.addEdge(v2, v1);

        assertTrue(g3.isALinkLadder(v1, v2));  //connected both ways

    }

}
